package com.rw.slamschedule.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.slamschedule.bean.pojo.MqttHead;
import com.rw.slamschedule.bean.pojo.MqttReceiveSlamMessage;
import com.rw.slamschedule.bean.pojo.MqttReceiveTerminalMessage;
import com.rw.slamschedule.bean.pojo.MqttSendSlamMessage;
import com.rw.slamschedule.configuration.MqttConfiguration;
import com.rw.slamschedule.domain.*;
import com.rw.slamschedule.repository.CommandHistoryRepository;
import com.rw.slamschedule.service.*;
import com.rw.slamschedule.utils.MqttUtil;
import com.rw.slamschedule.utils.ObjectConvert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class MqttComponent {

    private CommandMapperService commandMapperService;
    private CommandHistoryService commandHistoryService;
    private TodoService todoService;
    private ButtonService buttonService;
    private SlamService slamService;

    private ObjectMapper mapper;
    private MqttConfiguration.MqttGateway mqttGateway;
    private MqttUtil mqttUtil;

    @Autowired
    public MqttComponent(CommandMapperService commandMapperService, CommandHistoryService commandHistoryService, TodoService todoService, ButtonService buttonService, ObjectMapper mapper, SlamService slamService, MqttConfiguration.MqttGateway mqttGateway) {
        this.commandMapperService = commandMapperService;
        this.commandHistoryService = commandHistoryService;
        this.todoService = todoService;
        this.buttonService = buttonService;
        this.mapper = mapper;
        this.slamService = slamService;
        this.mqttGateway = mqttGateway;
    }

    public void mqttMessageParse(String json) throws IOException {
        MqttHead mqttHead = mapper.readValue(json, MqttHead.class);
        mqttUtil = new MqttUtil(mqttHead.getFrom());
        switch (mqttUtil.getObjectType()) {
            case "slam": {
                MqttReceiveSlamMessage mqttMessage = mapper.readValue(json, MqttReceiveSlamMessage.class);
                slamProcess(mqttHead, mqttMessage);
            }break;
            case  "term": {
                MqttReceiveTerminalMessage mqttMessage = mapper.readValue(json, MqttReceiveTerminalMessage.class);
                terminalProcess(mqttHead, mqttMessage);
            }break;
            default: {
                log.warn("Can not parse mqtt message:" + json);
            }
        }

        todoProcess();
        System.out.println("Mqtt receive json: "+json);
    }

    /**解析接收到的terminal命令，并将命令存入数据库*/
    private void terminalProcess(MqttHead mqttHead, MqttReceiveTerminalMessage mqttReceiveTerminalMessage) {
        switch (mqttUtil.getObjectRange()) {
            case "single": {
                Button button = buttonService.findByTerminal_IdAndId(mqttUtil.getObjectId(), mqttReceiveTerminalMessage.getButtonId());
                if(button != null) {
                    CommandMapper commandMapper = commandMapperService.findOne(button.getCommandMapperId());
                    Todo todo = ObjectConvert.commandMapper2Todo(mqttUtil.getObjectId(), button.getId(), commandMapper.getId());
                    todo.setSendTimestamp(mqttHead.getTimestamp());
                    todo.setState("wait");
                    todoService.addTodo(todo);
                }
                else
                {
                    log.warn("can not find the button:" + mqttReceiveTerminalMessage.toString());
                }

            }break;
            default:{
                log.warn("Unknow Terminal Range:" + mqttUtil.getObjectRange());
            }

        }
    }

    private void slamProcess(MqttHead mqttHead, MqttReceiveSlamMessage mqttReceiveSlamMessage) {
        switch (mqttUtil.getObjectRange()) {
            case "single" :{
                mqttReceiveSlamMessage.setId(mqttUtil.getObjectId());
                Slam slam = ObjectConvert.mqttReceiveSlamMessage2Slam(mqttReceiveSlamMessage);
                slamService.updateSlam(slam);
                commandHistoryProcess(slam);
            }break;
            default:{
                log.warn("Unknow Slam Range:" + mqttUtil.getObjectRange());
            }
        }
    }

    /**
     * 将完成的任务移除并记录
     * */
    @Transactional
    void commandHistoryProcess(Slam slam) {
        Todo todo = todoService.findOneBySlamIdAndState(slam.getId(), "runing");
        if (todo != null && slam.getState().equals("idle")) {
            CommandMapper commandMapper = commandMapperService.findOne(todo.getCommandMapperId());
            CommandHistory commandHistory = ObjectConvert.todo2CommandHistory(todo, commandMapper);
            commandHistoryService.addCommandHistory(commandHistory);
            todoService.removeTodo(todo);
        }
    }

    /**
     * 功能：分配任务
     * 说明：根据不同需求，取不同的slam及todo对象并发布任务，将来根据需求来修改*/
    @Transactional
    void todoProcess() throws JsonProcessingException {
        List<Slam> slamList = slamService.findByState("idle");
        List<Todo> todoList= todoService.findAllByState("wait");
        if (slamList.size()>0 && todoList.size()>0) {
            Slam slam = slamList.get(0);
            Todo todo = todoList.get(0);

            todo.setSlamId(slam.getId());
            todo.setState("send");
            todoService.updateState(todo);

            slam.setState("ready");
            slamService.updateSlam(slam);

            CommandMapper commandMapper = commandMapperService.findOne(todo.getCommandMapperId());

            MqttSendSlamMessage mqttSendSlamMessage = new MqttSendSlamMessage();
            mqttSendSlamMessage.setMessageType("command");
            mqttSendSlamMessage.setFrom("rw/term/single"
                    + todo.getTerminalId() + "/"
                    + todo.getButtonId());
            mqttSendSlamMessage.setSubmessages(commandMapper.getSubmessages());
            mqttSendSlamMessage.setTimestamp(String.valueOf(System.currentTimeMillis()));

            String json = mapper.writeValueAsString(mqttSendSlamMessage);
            String topic = "rw/slam/single/" + slam.getId();

            mqttGateway.sendToMqtt(json, topic);
        }
    }
}

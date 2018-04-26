package com.rw.slamschedule.core.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.slamschedule.configuration.MqttConfiguration;
import com.rw.slamschedule.core.dto.receiveMessage.MqttRecvSlamMessage;
import com.rw.slamschedule.core.dto.sendMessage.MqttSendSlamMessage;
import com.rw.slamschedule.core.handler.ControlHandler;
import com.rw.slamschedule.domain.CommandHistory;
import com.rw.slamschedule.domain.CommandMapper;
import com.rw.slamschedule.domain.Slam;
import com.rw.slamschedule.domain.Todo;
import com.rw.slamschedule.service.CommandHistoryService;
import com.rw.slamschedule.service.CommandMapperService;
import com.rw.slamschedule.service.SlamService;
import com.rw.slamschedule.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Component
@Slf4j
public class SlamHandler implements ControlHandler {
    @Autowired
    ObjectMapper mapper;

    @Autowired
    SlamService slamService;

    @Autowired
    TodoService todoService;

    @Autowired
    CommandMapperService commandMapperService;

    @Autowired
    CommandHistoryService commandHistoryService;

    @Autowired
    MqttConfiguration.MqttGateway mqttGateway;

    private MqttRecvSlamMessage slamMessage;


    @Override
    public void setMessage(String strMessage) {
        try {
            this.slamMessage = mapper.readValue(strMessage, MqttRecvSlamMessage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process() {
        try {
            if (slamMessage == null) log.warn("Message struct is null");
            else {
                switch (slamMessage.getMessageType()) {
                    case "info":
                        infoProcess();
                        break;
                    default:
                        log.info("Unknown message");
                }
            }
        }
        catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }

    }


    @Transactional
    protected void infoProcess() throws JsonProcessingException {
        for (Slam slam :
                slamMessage.getSlams()) {
            slam.setTimestamp(slamMessage.getTimestamp());
            Slam slamOld = slamService.findOne(slam.getSlamId());


            if (slamOld != null) {
                if (slamOld.getTimestamp() > slam.getTimestamp())
                    continue;
                else if (slamOld.getState().equals("idle") && slam.getState().equals("idle")) {
                    /**
                     * 待命
                     */
                    if (todoService.findOneBySlamId(slam.getSlamId()) == null) {
                        Todo todo = todoService.findOneByState("wait");
                        todo.setSlamId(slam.getSlamId());
                        todo.setState("send");
                        todoService.updateSlamIdAndState(todo);

                        CommandMapper commandMapper = commandMapperService.findOne(todo.getCommandMapperId());

                        MqttSendSlamMessage sendSlamMessage = new MqttSendSlamMessage();
                        sendSlamMessage.setMessageType("command");
                        String strFrom = "rw/term/single/" + todo.getTerminalId();
                        sendSlamMessage.setFrom(strFrom);
                        sendSlamMessage.setTimestamp(System.currentTimeMillis());
                        sendSlamMessage.setSubmessages(commandMapper.getSubmessages());
                        String strSend = mapper.writeValueAsString(sendSlamMessage);

                        String strTopic = "rw/slam/single/" + slam.getSlamId().toString();
                        mqttGateway.sendToMqtt(strSend, strTopic);


                    }
                } else if (slamOld.getState().equals("idle") && slam.getState().equals("busy")) {
                    /**
                     * 执行
                     */
                    Todo todo = todoService.findOneBySlamId(slam.getSlamId());
                    if (todo != null) {
                        todo.setState("doing");
                        todoService.updateStateAndDoingTimestamp(todo);
                    }

                } else if (slamOld.getState().equals("busy") && slam.getState().equals("idle")) {
                    /**
                     * 完成任务
                     */
                    Todo todo = todoService.findOneBySlamId(slam.getSlamId());
                    if (todo != null) {
                        CommandMapper commandMapper = commandMapperService.findOne(todo.getCommandMapperId());

                        CommandHistory commandHistory = new CommandHistory();
                        commandHistory.setSlamId(todo.getSlamId());
                        commandHistory.setTerminalId(todo.getTerminalId());
                        commandHistory.setButtonId(todo.getButtonId());
                        commandHistory.setReceiveTimestamp(todo.getSendTimestamp());
                        commandHistory.setCommandString(commandMapper.toString());

                        commandHistoryService.addCommandHistory(commandHistory);

                        todoService.removeTodo(todo);
                    }
                }

            }


            slamService.updateSlam(slam);

        }
    }
}

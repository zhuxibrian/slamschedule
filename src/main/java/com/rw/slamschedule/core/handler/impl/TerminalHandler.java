package com.rw.slamschedule.core.handler.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.slamschedule.core.dto.receiveMessage.MqttRecvTermMessage;
import com.rw.slamschedule.core.handler.ControlHandler;
import com.rw.slamschedule.domain.Button;
import com.rw.slamschedule.domain.CommandMapper;
import com.rw.slamschedule.domain.Todo;
import com.rw.slamschedule.exception.RwException;
import com.rw.slamschedule.service.ButtonService;
import com.rw.slamschedule.service.CommandMapperService;
import com.rw.slamschedule.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class TerminalHandler implements ControlHandler {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    TodoService todoService;

    @Autowired
    CommandMapperService commandMapperService;

    @Autowired
    ButtonService buttonService;

    private MqttRecvTermMessage termMessage;


    @Override
    public void setMessage(String strMessage) {
        try {
            this.termMessage = mapper.readValue(strMessage, MqttRecvTermMessage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //@Override
    public void process() {
        if (termMessage == null) log.warn("Message struct is null");
        else {
            try{
                switch (termMessage.getMessageType()) {
                    case "connect":
                        connectProcess();
                        break;
                    case "keyEvent":
                        keyEventProcess();
                        break;
                    default:
                        log.info("Unknown message");

                }
            } catch (RwException e) {
                log.warn(e.getMessage() + ": " + e.getData());
            }


        }

    }

    private void keyEventProcess() throws RwException {
        Button button = buttonService.findByTerminal_IdAndId(termMessage.getObjectIdInFrom(),
                Integer.valueOf(termMessage.getIndex()));

        if (button == null) {
            throw new RwException("the button is not exist", termMessage.toString());
        }

        CommandMapper commandMapper = commandMapperService.findByName(button.getCommandMapperName());

        if (commandMapper == null) {
            throw new RwException("the commandmapper is not exist", button.getCommandMapperName());
        }

        Todo todo = new Todo();
        todo.setTerminalId(button.getTerminal().getId());
        todo.setButtonId(button.getButtonId());
        todo.setSendTimestamp(termMessage.getTimestamp());
        todo.setState("wait");
        todo.setCommandMapperId(commandMapper.getId());

        todoService.addTodo(todo);
    }

    private void connectProcess() {

    }
}

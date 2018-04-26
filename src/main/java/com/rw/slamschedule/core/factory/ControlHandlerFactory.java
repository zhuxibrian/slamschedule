package com.rw.slamschedule.core.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.slamschedule.core.dto.MqttHead;
import com.rw.slamschedule.core.handler.ControlHandler;
import com.rw.slamschedule.core.handler.impl.SlamHandler;
import com.rw.slamschedule.core.handler.impl.TerminalHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class ControlHandlerFactory {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    TerminalHandler terminalHandler;

    @Autowired
    SlamHandler slamHandler;

    public ControlHandler createHandler(String strMqttMessage) throws IOException {

        ControlHandler controlHandler;

        MqttHead mqttHead = mapper.readValue(strMqttMessage, MqttHead.class);

        switch (mqttHead.getTypeInFrom()) {
            case "slam":
                controlHandler = slamHandler;//new SlamHandler();
                break;

            case "term":
                controlHandler =  terminalHandler;//new TerminalHandler();
                break;

            default:
                controlHandler = null;
        }

        return controlHandler;
    }
}

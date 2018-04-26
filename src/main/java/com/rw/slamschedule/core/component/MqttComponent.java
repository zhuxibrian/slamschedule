package com.rw.slamschedule.core.component;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.slamschedule.core.factory.ControlHandlerFactory;
import com.rw.slamschedule.core.handler.ControlHandler;
import com.rw.slamschedule.core.handler.impl.TerminalHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class MqttComponent {
    @Autowired
    ObjectMapper mapper;

    @Autowired
    ControlHandlerFactory controlHandlerFactory;

    public void mqttMessageParse(String strMessage) throws IOException {
        ControlHandler controlHandler = controlHandlerFactory.createHandler(strMessage);
        controlHandler.setMessage(strMessage);
        controlHandler.process();
    }
}

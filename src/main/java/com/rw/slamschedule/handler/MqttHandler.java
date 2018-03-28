package com.rw.slamschedule.handler;


import com.rw.slamschedule.bean.MqttComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import java.io.IOException;

public class MqttHandler implements MessageHandler {

    @Autowired
    MqttComponent mqttComponent;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        try {
            System.out.println("----: "+message.getPayload());
            mqttComponent.mqttMessageParse(message.getPayload().toString());
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }

}

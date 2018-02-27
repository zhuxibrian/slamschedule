package com.rw.slamschedule.handler;


import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class MqttHandler implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        System.out.println("!!!!!!!!!!!!!!!!!!!" + message.getPayload());
    }

}

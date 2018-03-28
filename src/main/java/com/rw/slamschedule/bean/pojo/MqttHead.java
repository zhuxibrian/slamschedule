package com.rw.slamschedule.bean.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MqttHead {
    private String messageType;
    private String text;
    private String timestamp;
    private String from;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "MqttHead{" +
                "messageType='" + messageType + '\'' +
                ", text='" + text + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}

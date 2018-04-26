package com.rw.slamschedule.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MqttHead {
    private String messageType;
    private String text;
    private Long timestamp;
    private String from;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    @JsonIgnore
    public String getTypeInFrom() {
        return from.split("/")[1];
    }

    @JsonIgnore
    public String getRangeInFrom() {
        String stringList[] = from.split("/");
        if (stringList.length < 3)
            return null;

        return stringList[2];
    }

    @JsonIgnore
    public Integer getObjectIdInFrom() {
        String stringList[] = from.split("/");
        if (stringList.length < 4)
            return null;

        return Integer.valueOf(stringList[3]);
    }
}

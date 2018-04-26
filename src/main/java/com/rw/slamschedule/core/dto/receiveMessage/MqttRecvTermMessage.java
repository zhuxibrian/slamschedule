package com.rw.slamschedule.core.dto.receiveMessage;

import com.rw.slamschedule.core.dto.MqttHead;

public class MqttRecvTermMessage extends MqttHead {

    private Integer keyCount;
    private Integer ledCount;
    private Integer Index;
    private String event;

    public Integer getKeyCount() {
        return keyCount;
    }

    public void setKeyCount(Integer keyCount) {
        this.keyCount = keyCount;
    }

    public Integer getLedCount() {
        return ledCount;
    }

    public void setLedCount(Integer ledCount) {
        this.ledCount = ledCount;
    }

    public Integer getIndex() {
        return Index;
    }

    public void setIndex(Integer index) {
        Index = index;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}

package com.rw.slamschedule.bean.pojo;

import com.rw.slamschedule.domain.Submessage;

import java.util.List;

public class MqttSendSlamMessage extends MqttHead{

    private List<Submessage> submessages;

    public List<Submessage> getSubmessages() {
        return submessages;
    }

    public void setSubmessages(List<Submessage> submessages) {
        this.submessages = submessages;
    }

}
package com.rw.slamschedule.core.dto.sendMessage;

import com.rw.slamschedule.core.dto.MqttHead;
import com.rw.slamschedule.domain.Submessage;

import java.util.List;
import java.util.Set;

public class MqttSendSlamMessage extends MqttHead {

    private Set<Submessage> submessages;

    public Set<Submessage> getSubmessages() {
        return submessages;
    }

    public void setSubmessages(Set<Submessage> submessages) {
        this.submessages = submessages;
    }

}
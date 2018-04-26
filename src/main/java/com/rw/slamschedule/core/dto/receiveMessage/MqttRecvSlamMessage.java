package com.rw.slamschedule.core.dto.receiveMessage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rw.slamschedule.core.dto.MqttHead;
import com.rw.slamschedule.domain.Slam;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MqttRecvSlamMessage extends MqttHead{

    private List<Slam> slams;

    public List<Slam> getSlams() {
        return slams;
    }

    public void setSlams(List<Slam> slams) {
        this.slams = slams;
    }
}

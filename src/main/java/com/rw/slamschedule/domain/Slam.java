package com.rw.slamschedule.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slam {

    @Id
    private Integer slamId;

    @Column
    private String text;

    @Column
    private String location;

    @Column
    private String state;

    @Column
    private String faultInfo;

    @Column
    private String serveState;

    private Integer battery;
    private String rotation;

    private Long timestamp;



    public Integer getSlamId() {
        return slamId;
    }

    public void setSlamId(Integer slamId) {
        this.slamId = slamId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public String getServeState() {
        return serveState;
    }

    public void setServeState(String serveState) {
        this.serveState = serveState;
    }

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    public String getFaultInfo() {
        return faultInfo;
    }

    public void setFaultInfo(String faultInfo) {
        this.faultInfo = faultInfo;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}

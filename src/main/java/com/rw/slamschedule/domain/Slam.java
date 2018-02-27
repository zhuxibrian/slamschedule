package com.rw.slamschedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Slam {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String ip;

    @Column
    private Integer groupId;

    @Column
    private Double locationX;

    @Column
    private Double locationY;

    @Column
    private Boolean idle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Double getLocationX() {
        return locationX;
    }

    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    public Double getLocationY() {
        return locationY;
    }

    public void setLocationY(Double locationY) {
        this.locationY = locationY;
    }

    public Boolean getIdle() {
        return idle;
    }

    public void setIdle(Boolean idle) {
        this.idle = idle;
    }
}

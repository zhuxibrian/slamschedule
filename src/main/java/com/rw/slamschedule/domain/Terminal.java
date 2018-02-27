package com.rw.slamschedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Terminal {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    /**locationX/Y用来存储该终端在地图上坐标，用于显示*/
    @Column
    private Double locationX;

    @Column
    private Double locationY;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

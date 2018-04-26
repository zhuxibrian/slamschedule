package com.rw.slamschedule.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Terminal {

    @Id
    private Integer id;

    @Column
    private String name;

    /**locationX/Y用来存储该终端在地图上坐标，用于显示*/
    @Column
    private Double locationX;

    @Column
    private Double locationY;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "terminal")
    List<Button> buttons;

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

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }
}

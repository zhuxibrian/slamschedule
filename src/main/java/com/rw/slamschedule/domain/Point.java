package com.rw.slamschedule.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String x;

    @Column
    private String y;

    @ManyToOne
    @JoinColumn(name = "submessage",foreignKey = @ForeignKey(name = "fk_submessage_fc"))
    @JsonIgnore
    private Submessage submessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Submessage getSubmessage() {
        return submessage;
    }

    public void setSubmessage(Submessage submessage) {
        this.submessage = submessage;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", x='" + x.toString() + '\'' +
                ", y='" + y.toString() + '\'' +
                '}';
    }
}

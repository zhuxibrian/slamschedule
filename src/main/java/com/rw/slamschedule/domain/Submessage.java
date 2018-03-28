package com.rw.slamschedule.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Submessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String submessage;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "submessage")
    @OrderBy(value = "id asc")
    private List<Point> points;

    @Column
    private String appending;

    @Column
    private String isMilestone;

    @Column
    private String serveTime;

    @ManyToOne
    @JoinColumn(name = "commandMapperId",foreignKey = @ForeignKey(name = "fk_commandMapper_fc"))
    @JsonIgnore
    private CommandMapper commandMapper;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubmessage() {
        return submessage;
    }

    public void setSubmessage(String submessage) {
        this.submessage = submessage;
    }

    public String getAppending() {
        return appending;
    }

    public void setAppending(String appending) {
        this.appending = appending;
    }

    public String getIsMilestone() {
        return isMilestone;
    }

    public void setIsMilestone(String isMilestone) {
        this.isMilestone = isMilestone;
    }

    public String getServeTime() {
        return serveTime;
    }

    public void setServeTime(String serveTime) {
        this.serveTime = serveTime;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public CommandMapper getCommandMapper() {
        return commandMapper;
    }

    public void setCommandMapper(CommandMapper commandMapper) {
        this.commandMapper = commandMapper;
    }

    @Override
    public String toString() {
        return "Submessage{" +
                "id=" + id +
                ", submessage='" + submessage + '\'' +
                ", points=" + points.toString() +
                ", appending='" + appending + '\'' +
                ", isMilestone='" + isMilestone + '\'' +
                ", serveTime='" + serveTime + '\'' +
                '}';
    }


}


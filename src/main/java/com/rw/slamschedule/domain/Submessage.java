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

    /**子命令注释*/
    @Column
    private String submessage;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "submessage")
    @OrderBy(value = "id asc")
    private List<Point> points;

    @Column
    private String appending;

    @Column
    private String isMilestone;

    /**充电桩序号*/
    @Column
    private String slot;

    @Column
    private String timeout;

    @Column
    private String action;

    /**手动控制方向*/
    @Column
    private String direct;

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

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
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
                ", points=" + points +
                ", appending='" + appending + '\'' +
                ", isMilestone='" + isMilestone + '\'' +
                ", slot='" + slot + '\'' +
                ", timeout='" + timeout + '\'' +
                ", action='" + action + '\'' +
                ", direct='" + direct + '\'' +
                ", commandMapper=" + commandMapper +
                '}';
    }
}


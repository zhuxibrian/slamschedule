package com.rw.slamschedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long commandMapperId;

    @Column
    private Integer terminalId;

    @Column
    private Integer buttonId;

    /**执行命令的slam id*/
    @Column
    private Integer slamId;

    /**执行状态*/
    @Column
    private Integer state;

    /**接收时间时间戳*/
    @Column
    private Integer receiveTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommandMapperId() {
        return commandMapperId;
    }

    public void setCommandMapperId(Long commandMapperId) {
        this.commandMapperId = commandMapperId;
    }

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public Integer getButtonId() {
        return buttonId;
    }

    public void setButtonId(Integer buttonId) {
        this.buttonId = buttonId;
    }

    public Integer getSlamId() {
        return slamId;
    }

    public void setSlamId(Integer slamId) {
        this.slamId = slamId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getReceiveTimestamp() {
        return receiveTimestamp;
    }

    public void setReceiveTimestamp(Integer receiveTimestamp) {
        this.receiveTimestamp = receiveTimestamp;
    }
}

package com.rw.slamschedule.domain;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer terminalId;

    @Column
    private Integer buttonId;

    @Column
    private Long sendTimestamp;

    @Column
    private Integer commandMapperId;

    /**执行命令的slam id*/
    @Column
    private Integer slamId;

    /**执行状态*/
    @Column
    private String state;

    /**接收时间时间戳*/
    @Column
    private Long receiveTimestamp = System.currentTimeMillis();

    @Column
    private Long doingTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getSendTimestamp() {
        return sendTimestamp;
    }

    public void setSendTimestamp(Long sendTimestamp) {
        this.sendTimestamp = sendTimestamp;
    }

    public Integer getCommandMapperId() {
        return commandMapperId;
    }

    public void setCommandMapperId(Integer commandMapperId) {
        this.commandMapperId = commandMapperId;
    }

    public Integer getSlamId() {
        return slamId;
    }

    public void setSlamId(Integer slamId) {
        this.slamId = slamId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getReceiveTimestamp() {
        return receiveTimestamp;
    }

    public void setReceiveTimestamp(Long receiveTimestamp) {
        this.receiveTimestamp = receiveTimestamp;
    }

    public Long getDoingTimestamp() {
        return doingTimestamp;
    }

    public void setDoingTimestamp(Long doingTimestamp) {
        this.doingTimestamp = doingTimestamp;
    }
}

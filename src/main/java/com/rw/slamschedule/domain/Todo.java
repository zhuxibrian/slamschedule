package com.rw.slamschedule.domain;

import javax.persistence.*;

@Entity
@IdClass(TodoPk.class)
public class Todo {

    @Id
    private String terminalId;

    @Id
    private String buttonId;

    @Id
    private String sendTimestamp;

    @Column
    private Integer commandMapperId;

    /**执行命令的slam id*/
    @Column
    private String slamId;

    /**执行状态*/
    @Column
    private String state;

    /**接收时间时间戳*/
    @Column
    private Long receiveTimestamp = System.currentTimeMillis();

    @Column
    private Long doingTimestamp;

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public String getSendTimestamp() {
        return sendTimestamp;
    }

    public void setSendTimestamp(String sendTimestamp) {
        this.sendTimestamp = sendTimestamp;
    }

    public Integer getCommandMapperId() {
        return commandMapperId;
    }

    public void setCommandMapperId(Integer commandMapperId) {
        this.commandMapperId = commandMapperId;
    }

    public String getSlamId() {
        return slamId;
    }

    public void setSlamId(String slamId) {
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

package com.rw.slamschedule.domain;

import javax.persistence.*;

@Entity
public class CommandHistory {
    @Id
    @GeneratedValue
    private Integer id;

    @Lob
    @Basic(fetch= FetchType.LAZY)
    private String commandString;

    @Column
    private String terminalId;

    @Column
    private String buttonId;

    @Column
    private String slamId;

    @Column
    private Long receiveTimestamp;

    @Column
    private Long finishTimestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommandString() {
        return commandString;
    }

    public void setCommandString(String commandString) {
        this.commandString = commandString;
    }

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

    public String getSlamId() {
        return slamId;
    }

    public void setSlamId(String slamId) {
        this.slamId = slamId;
    }

    public Long getReceiveTimestamp() {
        return receiveTimestamp;
    }

    public void setReceiveTimestamp(Long receiveTimestamp) {
        this.receiveTimestamp = receiveTimestamp;
    }

    public Long getFinishTimestamp() {
        return finishTimestamp;
    }

    public void setFinishTimestamp(Long finishTimestamp) {
        this.finishTimestamp = finishTimestamp;
    }
}

package com.rw.slamschedule.domain;

import javax.persistence.*;

@Entity
public class CommandHistory {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    @Basic(fetch= FetchType.LAZY)
    private String commandString;

    @Column
    private Integer terminalId;

    @Column
    private Integer buttonId;

    @Column
    private Integer slamId;

    @Column
    private Integer receiveTimestamp;

    @Column
    private Integer finishTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommandString() {
        return commandString;
    }

    public void setCommandString(String commandString) {
        this.commandString = commandString;
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

    public Integer getReceiveTimestamp() {
        return receiveTimestamp;
    }

    public void setReceiveTimestamp(Integer receiveTimestamp) {
        this.receiveTimestamp = receiveTimestamp;
    }

    public Integer getFinishTimestamp() {
        return finishTimestamp;
    }

    public void setFinishTimestamp(Integer finishTimestamp) {
        this.finishTimestamp = finishTimestamp;
    }
}

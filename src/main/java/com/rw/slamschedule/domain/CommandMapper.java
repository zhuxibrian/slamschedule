package com.rw.slamschedule.domain;

import javax.persistence.*;

@Entity
public class CommandMapper {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer terminalId;

    @Column
    private Integer buttonId;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    private String commandString;

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

    public String getCommandString() {
        return commandString;
    }

    public void setCommandString(String commandString) {
        this.commandString = commandString;
    }
}

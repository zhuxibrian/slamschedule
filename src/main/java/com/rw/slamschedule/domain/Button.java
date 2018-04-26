package com.rw.slamschedule.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Button {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer buttonId;

    @Column
    private String commandMapperName;

    @ManyToOne
    @JoinColumn(name = "terminalId",foreignKey = @ForeignKey(name = "fk_terminal_fc"))
    @JsonIgnore
    private Terminal terminal;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getButtonId() {
        return buttonId;
    }

    public void setButtonId(Integer buttonId) {
        this.buttonId = buttonId;
    }

    public String getCommandMapperName() {
        return commandMapperName;
    }

    public void setCommandMapperName(String commandMapperName) {
        this.commandMapperName = commandMapperName;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
}

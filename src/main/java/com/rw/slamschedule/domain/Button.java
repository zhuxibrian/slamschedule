package com.rw.slamschedule.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Button {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String targetRange;

    @Column
    private String targetId;

    @Column
    private Integer commandMapperId;

    @ManyToOne
    @JoinColumn(name = "terminalId",foreignKey = @ForeignKey(name = "fk_terminal_fc"))
    @JsonIgnore
    private Terminal terminal;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetRange() {
        return targetRange;
    }

    public void setTargetRange(String targetRange) {
        this.targetRange = targetRange;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Integer getCommandMapperId() {
        return commandMapperId;
    }

    public void setCommandMapperId(Integer commandMapperId) {
        this.commandMapperId = commandMapperId;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
}

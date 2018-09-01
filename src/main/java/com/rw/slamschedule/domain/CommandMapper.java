package com.rw.slamschedule.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class CommandMapper {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "commandMapper")
    @OrderBy(value = "id asc")
    private Set<Submessage> submessages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Submessage> getSubmessages() {
        return submessages;
    }

    public void setSubmessages(Set<Submessage> submessages) {
        this.submessages = submessages;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CommandMapper to string";
    }
}


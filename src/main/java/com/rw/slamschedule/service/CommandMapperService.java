package com.rw.slamschedule.service;

import com.rw.slamschedule.domain.CommandMapper;
import com.rw.slamschedule.domain.Submessage;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface CommandMapperService  {
    CommandMapper findOne(Integer id);

    CommandMapper addCommandMapper(CommandMapper commandMapper);

    List<CommandMapper> findAll();

    CommandMapper removeCommandMapper(Integer id);

    CommandMapper updateCommandMapper(CommandMapper commandMapper);

    CommandMapper findByName(String name);

    Page<CommandMapper> findAll(Integer page, Integer size);

    CommandMapper addSubmessage(Integer id, Submessage submessage);
}

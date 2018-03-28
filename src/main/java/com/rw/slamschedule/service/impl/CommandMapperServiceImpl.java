package com.rw.slamschedule.service.impl;

import com.rw.slamschedule.domain.CommandMapper;
import com.rw.slamschedule.domain.Submessage;
import com.rw.slamschedule.repository.CommandMapperRepository;
import com.rw.slamschedule.service.CommandMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandMapperServiceImpl implements CommandMapperService {

    @Autowired
    private CommandMapperRepository repository;

    @Override
    public CommandMapper findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public CommandMapper addCommandMapper(CommandMapper commandMapper) {
        return repository.save(commandMapper);
    }

    @Override
    public List<CommandMapper> findAll() {
        return repository.findAll();
    }

    @Override
    public CommandMapper removeCommandMapper(Integer id) {
        CommandMapper commandMapper = repository.findOne(id);
        repository.delete(id);
        return commandMapper;
    }

    @Override
    public CommandMapper updateCommandMapper(CommandMapper commandMapper) {
        return repository.save(commandMapper);
    }

    @Override
    public CommandMapper findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Page<CommandMapper> findAll(Integer page, Integer size) {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC,"id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(page, size, sort);
        return repository.findAll(pageable);
    }

    @Override
    public CommandMapper addSubmessage(Integer id, Submessage submessage) {
        CommandMapper commandMapper = repository.findOne(id);
        commandMapper.getSubmessages().add(submessage);
        submessage.setCommandMapper(commandMapper);
        repository.save(commandMapper);

        return commandMapper;
    }


}

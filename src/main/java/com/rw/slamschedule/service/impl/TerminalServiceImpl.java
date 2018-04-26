package com.rw.slamschedule.service.impl;

import com.rw.slamschedule.domain.Button;
import com.rw.slamschedule.domain.Terminal;
import com.rw.slamschedule.repository.TerminalRepository;
import com.rw.slamschedule.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TerminalServiceImpl implements TerminalService{

    TerminalRepository repository;

    @Autowired
    public TerminalServiceImpl(TerminalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Terminal addTerminal(Terminal terminal) {
        return repository.save(terminal);
    }

    @Override
    @Transactional
    public Terminal updateTerminal(Terminal terminal) {
        Terminal terminalUpdate = repository.findOne(terminal.getId());
        terminal.setId(terminalUpdate.getId());
        return repository.save(terminal);
    }

    @Override
    public void removeTerminal(Integer id) {
        repository.delete(id);
    }

    @Override
    public Terminal findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public List<Terminal> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Terminal> findPage(Integer page, Integer size) {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC,"id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(page, size, sort);
        return repository.findAll(pageable);
    }

    @Override
    public Terminal addButton(Integer id, Button button) {

        Terminal terminal = repository.findOne(id);
        terminal.getButtons().add(button);
        button.setTerminal(terminal);
        repository.save(terminal);

        return terminal;
    }
}

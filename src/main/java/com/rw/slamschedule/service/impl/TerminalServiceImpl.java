package com.rw.slamschedule.service.impl;

import com.rw.slamschedule.domain.Terminal;
import com.rw.slamschedule.repository.TerminalRepository;
import com.rw.slamschedule.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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
        return repository.saveAndFlush(terminal);
    }

    @Override
    @Transactional
    public Terminal updateTerminal(Terminal terminal) {
        Terminal terminalUpdate = repository.findById(terminal.getId());
        terminal.setId(terminalUpdate.getId());
        return repository.saveAndFlush(terminal);
    }

    @Override
    public Terminal removeTerminal(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Terminal findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Terminal> findAll() {
        return repository.findAll();
    }
}

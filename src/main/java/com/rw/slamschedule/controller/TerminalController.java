package com.rw.slamschedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.slamschedule.domain.*;
import com.rw.slamschedule.exception.RwException;
import com.rw.slamschedule.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/terminals")
public class TerminalController {

    @Autowired
    TerminalService terminalService;

    @Autowired
    ObjectMapper mapper;

    @GetMapping
    public List<Terminal> getAllTerminals() {
        return terminalService.findAll();
    }

    @GetMapping(value="/{id}")
    public Terminal getTerminalById(@PathVariable String id) {
        return terminalService.findById(id);
    }

    @PostMapping
    @Transactional(rollbackFor = RwException.class)
    public Terminal postTerminal(@RequestBody String string) throws IOException, RwException {
        Terminal terminal = mapper.readValue(string, Terminal.class);

        if (terminalService.findById(terminal.getId()) != null) {
            throw new RwException("terminal already exist！", "");

        }

        for (Button button:terminal.getButtonList()) {
            button.setTerminal(terminal);
        }

        terminalService.addTerminal(terminal);

        return terminal;
    }

    @DeleteMapping(value = "/{id}")
    public Terminal deleteTerminalById(@PathVariable String id) {
        Terminal terminal = terminalService.findById(id);
        terminalService.removeTerminal(id);
        return terminal;
    }

    @PutMapping
    public Terminal putTerminal(@RequestBody String string) throws IOException {
        Terminal terminal = mapper.readValue(string, Terminal.class);
        for (Button button:terminal.getButtonList()) {
            button.setTerminal(terminal);
        }

        terminalService.updateTerminal(terminal);

        return terminal;
    }
}

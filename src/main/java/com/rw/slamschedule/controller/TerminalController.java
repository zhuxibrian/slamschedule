package com.rw.slamschedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.slamschedule.domain.*;
import com.rw.slamschedule.exception.RwException;
import com.rw.slamschedule.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/terminals")
public class TerminalController {

    @Autowired
    TerminalService terminalService;

    @GetMapping
    public List<Terminal> getAllTerminals() {
        return terminalService.findAll();
    }

    @GetMapping(value = "/page/{page}/size/{size}")
    public Page<Terminal> getTerminalByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return terminalService.findPage(page-1, size);
    }

    @GetMapping(value="/{id}")
    public Terminal getTerminalById(@PathVariable("id") Integer id) {
        return terminalService.findById(id);
    }

    @PostMapping
    @Transactional(rollbackFor = RwException.class)
    public Terminal postTerminal(@RequestBody Terminal terminal) throws IOException, RwException {

        if (terminal.getId() == null) {
            throw new RwException("terminal id is null！", "");
        }
        if (terminalService.findById(terminal.getId()) != null) {
            throw new RwException("terminal already exist！", "");
        }

        setTerminal(terminal);
        terminalService.addTerminal(terminal);

        return terminal;
    }

    @DeleteMapping(value = "/{id}")
    public Terminal deleteTerminalById(@PathVariable("id") Integer id) {
        Terminal terminal = terminalService.findById(id);
        terminalService.removeTerminal(id);
        return terminal;
    }

    @PutMapping
    public Terminal putTerminal(@RequestBody Terminal terminal) throws IOException {
        setTerminal(terminal);
        terminalService.updateTerminal(terminal);
        return terminal;
    }

    @PatchMapping(value = "/addbutton/{id}")
    public Terminal patchAddButton(@PathVariable("id") Integer id, @RequestBody Button button) {
        return terminalService.addButton(id, button);
    }


    private void setTerminal(Terminal terminal) {
        if (terminal.getButtons() == null)
            return;

        for (Button button:terminal.getButtons()) {
            button.setTerminal(terminal);
        }
    }
}

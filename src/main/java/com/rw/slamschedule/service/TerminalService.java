package com.rw.slamschedule.service;

import com.rw.slamschedule.domain.Button;
import com.rw.slamschedule.domain.Terminal;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface TerminalService {

    Terminal addTerminal(Terminal terminal);

    @Modifying
    Terminal updateTerminal(Terminal terminal);

    void removeTerminal(Integer id);

    Terminal findById(Integer id);

    List<Terminal> findAll();

    Page<Terminal> findPage(Integer page, Integer size);


    Terminal addButton(Integer id, Button button);
}

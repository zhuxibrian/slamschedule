package com.rw.slamschedule.service;

import com.rw.slamschedule.domain.Terminal;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface TerminalService {

    Terminal addTerminal(Terminal terminal);

    @Modifying
    Terminal updateTerminal(Terminal terminal);

    Terminal removeTerminal(String id);

    Terminal findById(String id);

    List<Terminal> findAll();
}

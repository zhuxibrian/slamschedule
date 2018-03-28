package com.rw.slamschedule.service.impl;

import com.rw.slamschedule.domain.Button;
import com.rw.slamschedule.repository.ButtonRepository;
import com.rw.slamschedule.service.ButtonService;
import org.springframework.stereotype.Service;

@Service
public class ButtonServiceImpl implements ButtonService {

    private ButtonRepository repository;

    public ButtonServiceImpl(ButtonRepository repository) {
        this.repository = repository;
    }


    @Override
    public Button findByTerminal_IdAndId(String termId, String buttonId) {
        return repository.findByTerminal_IdAndId(termId, buttonId);
    }
}

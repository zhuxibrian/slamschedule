package com.rw.slamschedule.service.impl;

import com.rw.slamschedule.domain.Button;
import com.rw.slamschedule.repository.ButtonRepository;
import com.rw.slamschedule.service.ButtonService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

@Service
public class ButtonServiceImpl implements ButtonService {

    private ButtonRepository repository;

    public ButtonServiceImpl(ButtonRepository repository) {
        this.repository = repository;
    }


    @Override
    public Button findByTerminal_IdAndId(Integer termId, Integer buttonId) {
        return repository.findByTerminal_IdAndAndButtonId(termId, buttonId);
    }

    @Override
    public Button removeButtonById(Integer id) {
        Button button = repository.findOne(id);
        button.getTerminal().getButtons().remove(button);
        repository.delete(id);
        return button;
    }

    @Override
    @Modifying
    public Button updateButton(Button button) {
        Button buttonOld = repository.findOne(button.getId());
        button.setTerminal(buttonOld.getTerminal());
        return repository.saveAndFlush(button);
    }

    @Override
    public Button findById(Integer id) {
        return repository.findOne(id);
    }
}

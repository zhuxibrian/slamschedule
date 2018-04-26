package com.rw.slamschedule.service;

import com.rw.slamschedule.domain.Button;

public interface ButtonService {
    Button findByTerminal_IdAndId(Integer termId, Integer buttonId);

    Button removeButtonById(Integer id);

    Button updateButton(Button button);

    Button findById(Integer id);
}

package com.rw.slamschedule.service;

import com.rw.slamschedule.domain.Button;

public interface ButtonService {
    Button findByTerminal_IdAndId(String termId, String buttonId);
}

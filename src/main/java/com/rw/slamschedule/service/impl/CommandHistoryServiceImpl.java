package com.rw.slamschedule.service.impl;


import com.rw.slamschedule.domain.CommandHistory;
import com.rw.slamschedule.repository.CommandHistoryRepository;
import com.rw.slamschedule.service.CommandHistoryService;
import org.springframework.stereotype.Service;

@Service
public class CommandHistoryServiceImpl implements CommandHistoryService {

    private CommandHistoryRepository repository;

    public CommandHistoryServiceImpl(CommandHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addCommandHistory(CommandHistory commandHistory) {
        repository.save(commandHistory);
    }
}

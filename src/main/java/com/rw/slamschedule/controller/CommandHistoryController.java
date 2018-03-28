package com.rw.slamschedule.controller;

import com.rw.slamschedule.domain.CommandHistory;
import com.rw.slamschedule.repository.CommandHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cmdHistorys")
public class CommandHistoryController {

    @Autowired
    private CommandHistoryRepository repository;

    @GetMapping(value = "")
    public Page<CommandHistory> getCommandHistoryByPageable(@PageableDefault(value = 15, sort = { "finishTimestamp" }, direction = Sort.Direction.ASC)
                                                           Pageable pageable) {
        return repository.findAll(pageable);
    }
}

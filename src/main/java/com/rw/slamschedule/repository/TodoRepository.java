package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByState(String state);

    Todo findByState(String state);

    Todo findBySlamIdAndState(Integer slamId, String State);

    Todo findBySlamId(Integer slamId);

    Todo findByTerminalIdAndButtonIdAndSendTimestamp(Integer termId, Integer buttonId, Long sendTimestamp);
}

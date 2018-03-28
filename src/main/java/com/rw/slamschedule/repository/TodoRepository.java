package com.rw.slamschedule.repository;

import com.rw.slamschedule.domain.Todo;
import com.rw.slamschedule.domain.TodoPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, TodoPk> {

    List<Todo> findAllByState(String state);

    Todo findByState(String state);

    Todo findBySlamIdAndState(String slamId, String State);

    Todo findByTerminalIdAndButtonIdAndSendTimestamp(String termId, String buttonId, String sendTimestamp);

    void deleteByTerminalIdAndButtonIdAndSendTimestamp(String termId, String buttonId, String sendTimestamp);
}

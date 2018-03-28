package com.rw.slamschedule.service;

import com.rw.slamschedule.domain.Todo;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface TodoService {
    Todo addTodo(Todo todo);

    void removeTodo(Todo todo);

    void removeAll();

    Todo findOneByState(String state);

    List<Todo> findAll();

    List<Todo> findAllByState(String state);

    Todo findOneBySlamIdAndState(String slamId, String state);

    @Modifying
    void updateState(Todo todo);

    @Modifying
    void updateSlamIdAndState(Todo todo);


}

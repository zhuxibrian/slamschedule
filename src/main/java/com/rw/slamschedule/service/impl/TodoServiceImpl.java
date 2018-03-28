package com.rw.slamschedule.service.impl;

import com.rw.slamschedule.domain.Todo;
import com.rw.slamschedule.domain.TodoPk;
import com.rw.slamschedule.repository.TodoRepository;
import com.rw.slamschedule.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;

    @Autowired
    TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Todo addTodo(Todo todo) {
        return repository.save(todo);
    }

    @Override
    public void removeTodo(Todo todo) {
        repository.deleteByTerminalIdAndButtonIdAndSendTimestamp(todo.getTerminalId(),
                todo.getButtonId(),
                todo.getSendTimestamp());
    }


    @Override
    public void removeAll() {
        repository.deleteAll();
    }

    @Override
    public Todo findOneByState(String state) {
        return repository.findByState(state);
    }

    @Override
    public List<Todo> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Todo> findAllByState(String state) {
        return repository.findAllByState(state);
    }

    @Override
    public Todo findOneBySlamIdAndState(String slamId, String state) {
        return repository.findBySlamIdAndState(slamId, state);
    }


    @Override
    @Transactional
    public void updateState(Todo todo) {
        Todo todoUpdate = repository.findByTerminalIdAndButtonIdAndSendTimestamp(todo.getTerminalId(),
                todo.getButtonId(),
                todo.getSendTimestamp());
        todoUpdate.setState(todo.getState());
        repository.save(todoUpdate);
    }

    @Override
    @Transactional
    public void updateSlamIdAndState(Todo todo) {
        Todo todoUpdate = repository.findByTerminalIdAndButtonIdAndSendTimestamp(todo.getTerminalId(),
                todo.getButtonId(),
                todo.getSendTimestamp());
        todoUpdate.setSlamId(todo.getSlamId());
        todoUpdate.setState(todo.getState());
        repository.save(todoUpdate);
    }


}

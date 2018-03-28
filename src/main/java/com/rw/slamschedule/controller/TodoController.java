package com.rw.slamschedule.controller;

import com.rw.slamschedule.domain.Todo;
import com.rw.slamschedule.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.findAll();
    }

    @GetMapping(value = "/{state}")
    public List<Todo> getTodosByState(@PathVariable String state) {
        return todoService.findAllByState(state);
    }

    @PostMapping
    public Todo postTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }
}

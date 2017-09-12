package com.example.todo.controller;

import com.example.todo.exception.TodoInvalidRequestException;
import com.example.todo.exception.TodoNotFoundException;
import com.example.todo.model.Status;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * ToDo Controller
 *
 * @author Piyawut Chiradejnunt<pchiradejnunt@gmail.com>
 */
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/api/v1/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodos() {
        return todoService.getAll();

    }

    @GetMapping("/api/v1/todos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo get(@PathVariable String id) {
        if(id == null) {
            throw new TodoInvalidRequestException("id is invalid.");
        }
        
        final Todo todo = todoService.getTodoById(id);
        if (todo == null) {
            throw new TodoNotFoundException("Task could not be found.");
        }
        return todoService.getTodoById(id);
    }

    @PostMapping("/api/v1/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @PutMapping("/api/v1/todos")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Todo todo) {
        if (todo.getId() == null) {
            throw new TodoNotFoundException("Task could not be found.");
        }

        todoService.update(todo);
    }

    @PutMapping("/api/v1/todos/{id}/status/{status}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void statusUpdate(@PathVariable String id, @PathVariable String status) {
        final Todo todo = todoService.getTodoById(id);
        final Status s = Status.valueOf(status.toUpperCase());
        if (todo == null) {
            throw new TodoNotFoundException("Task could not be found.");
        }
        todo.setStatus(s);
        todoService.update(todo);
    }

    @DeleteMapping("/api/v1/todos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        final Todo todo = todoService.getTodoById(id);
        if (todo == null) {
            throw new TodoNotFoundException("Task could not be found.");
        }
        todoService.delete(todo);
    }
}

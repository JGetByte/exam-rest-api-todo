package com.example.todo.service;

import com.example.todo.model.Status;
import com.example.todo.model.Todo;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Piyawut Chiradejnunt<pchiradejnunt@gmail.com>
 */
@Component
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    
    private SecureRandom random = new SecureRandom();
    
    static {
        final Todo todo1 = new Todo("001", "Todo 1", "Todo description 1", Status.PENDING);
        final Todo todo2 = new Todo("002", "Todo 2", "Todo description 2", Status.DONE);
        
        todos.add(todo1);
        todos.add(todo2);
    }
    
    public List<Todo> getAll(){
        return todos;
    }
    
    public Todo getTodoById(String id) {
        for (Todo todo : todos) {
            if (id.equals(todo.getId())) {
                return todo;
            }
        }
        return null;
        
    }
    
    public Todo save(Todo todo) {
        final String id = new BigInteger(100, random).toString(32);
        System.out.println("random: " + id);
        
        todo.setId(id);
        todos.add(todo);
        
        return todo;
    }
    
    public Todo update(Todo todo) {
        final Todo object = getTodoById(todo.getId());
        
        object.setTitle(todo.getTitle());
        object.setDescription(todo.getDescription());
        object.setStatus(todo.getStatus());
        
        return object;
        
    }
    
    public void delete(Todo todo) {
        todos.remove(todo);
        
    }
}

package com.example.todo.model;

import lombok.Data;

/**
 *
 * @author Piyawut Chiradejnunt<pchiradejnunt@gmail.com>
 */
@Data
public class Todo {
    
    private String id;
    private String title;
    private String description;
    private Status status;
    
    public Todo() {}
    
    public Todo(String id, String title, String description, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }
    
    public String toString() {
        return "{id:" + getId() +
                "title: " + getTitle() +
                "description: " + getDescription() +
                "status: " + getStatus().name() + "}";
    }
}

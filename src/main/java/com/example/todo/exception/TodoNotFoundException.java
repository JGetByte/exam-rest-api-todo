/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo.exception;

/**
 *
 * @author Piyawut Chiradejnunt<pchiradejnunt@gmail.com>
 */
public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(String message) {
        super(message);
    }
   
    
}

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
public class TodoInvalidRequestException extends RuntimeException {

    public TodoInvalidRequestException(String message) {
        super(message);
    }
    
    
}

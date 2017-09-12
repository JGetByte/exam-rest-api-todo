package com.example.todo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 *
 * @author Piyawut Chiradejnunt<pchiradejnunt@gmail.com>
 */
@ControllerAdvice
public class TodoExceptionHandler {
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TodoNotFoundException.class)
    public void handleNotFound(TodoNotFoundException tex) {
        // 404
        System.err.println("Task could not be found.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TodoInvalidRequestException.class)
    public void handleBadRequest(TodoInvalidRequestException iex) {
        // 400
        System.err.println("Invalid Request.");
    }
}

package com.example.demo.controller;

import com.example.demo.exception.EntityAlreadyExistException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "Произошла ошибка";
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public String handleEntityNotFound(EntityNotFoundException e) {
        return e.getMessage();
    }
    @ExceptionHandler(EntityAlreadyExistException.class)
    public String handleEntityAlreadyExistException(EntityAlreadyExistException e) {
        return e.getMessage();
    }

}

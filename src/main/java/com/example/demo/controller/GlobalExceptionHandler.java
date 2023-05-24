package com.example.demo.controller;

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

    @ExceptionHandler(Exception.class)
    public String handleEntityNotFound(EntityNotFoundException e) {
        return e.getMessage();
    }
}

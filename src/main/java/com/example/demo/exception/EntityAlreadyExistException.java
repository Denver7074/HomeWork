package com.example.demo.exception;

public class EntityAlreadyExistException extends Exception{
    public EntityAlreadyExistException(String message) {
        super(message);
    }
}

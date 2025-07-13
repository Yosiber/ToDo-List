package com.yohan.todolist.exceptions;

public class ForbiddenOperationException extends RuntimeException {

    public ForbiddenOperationException(Long userId) {
        super("La tarea no fue encontrada para el usuario: " + userId);
    }

    public ForbiddenOperationException(String message) {
        super(message);
    }
}

package com.yohan.todolist.exceptions;

public class TaskNotFoundException extends RuntimeException {

  public TaskNotFoundException(Long id) {
    super("Tarea no econtrada : " + id);
  }

  public TaskNotFoundException(String message) {
        super(message);
    }
}

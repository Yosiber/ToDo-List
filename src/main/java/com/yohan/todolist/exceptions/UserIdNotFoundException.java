package com.yohan.todolist.exceptions;

public class UserIdNotFoundException extends RuntimeException {

  public UserIdNotFoundException(Long id) {
    super("Id del usuario no encontrada : " + id);
  }

  public UserIdNotFoundException(String message) {
        super(message);
    }
}

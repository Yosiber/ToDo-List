package com.yohan.todolist.services;

import com.yohan.todolist.entities.UsersEntity;
import java.util.List;

public interface  UserService {

    UsersEntity createUser(UsersEntity user);

    List<UsersEntity> getAllUsers();

    UsersEntity getUserByID(Long id);

    void deleteUserByID(Long id);

}

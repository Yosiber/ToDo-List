package com.yohan.todolist.services.impl;

import com.yohan.todolist.entities.UsersEntity;
import com.yohan.todolist.repositories.UserRepository;
import com.yohan.todolist.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UsersEntity createUser(UsersEntity user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public List<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UsersEntity getUserByID(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserByID(Long id) {
        userRepository.deleteById(id);
    }


}

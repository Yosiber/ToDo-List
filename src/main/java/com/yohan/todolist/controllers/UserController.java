package com.yohan.todolist.controllers;


import com.yohan.todolist.dto.UserRequestDTO;
import com.yohan.todolist.entities.UsersEntity;
import com.yohan.todolist.mapper.UserMapper;
import com.yohan.todolist.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    //private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/usuarios")
    public ResponseEntity<List<UserRequestDTO>> getAllUsers() {
        List<UsersEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(userMapper.toDto(users));
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UserRequestDTO> getUserByID(@PathVariable Long id) {
        UsersEntity getUserByID = userService.getUserByID(id);
        return ResponseEntity.ok(userMapper.toDto(getUserByID));
    }

    @PostMapping("/registro")
    public ResponseEntity<UserRequestDTO> register(@RequestBody UserRequestDTO userDto) {
        // userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        UsersEntity createUser = userService.createUser(userMapper.toEntity(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toDto(createUser));
    }

    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUserByID(id);
        return ResponseEntity.noContent().build();
    }

}

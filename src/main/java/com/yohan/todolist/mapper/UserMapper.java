package com.yohan.todolist.mapper;

import com.yohan.todolist.dto.UserRequestDTO;
import com.yohan.todolist.entities.UsersEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public UserRequestDTO toDto(UsersEntity entity) {

        return UserRequestDTO.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }

    public List<UserRequestDTO> toDto(List<UsersEntity> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

    public UsersEntity toEntity(UserRequestDTO dto) {
        return UsersEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public List<UsersEntity> toEntity(List<UserRequestDTO> dto) {
        return dto.stream()
                .map(this::toEntity)
                .toList();
    }

}
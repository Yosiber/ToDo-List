package com.yohan.todolist.mapper;

import com.yohan.todolist.dto.TaskRequestDTO;
import com.yohan.todolist.entities.TasksEntity;
import com.yohan.todolist.entities.UsersEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskMapper {

    public TaskRequestDTO toDto(TasksEntity entity) {
        return TaskRequestDTO.builder()
                .title(entity.getTitle())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .expiration(entity.getExpiration())
                .build();
    }

    public List<TaskRequestDTO> toDto(List<TasksEntity> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

    public TasksEntity toEntity(TaskRequestDTO dto) {

        UsersEntity user = UsersEntity.builder()
                .id(dto.getUserId())
                .build();

        return TasksEntity.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .expiration(dto.getExpiration())
                .user(user)
                .build();
    }

    public TasksEntity toEntity(TaskRequestDTO dto, Long taskId){
        UsersEntity user = UsersEntity.builder()
                .id(dto.getUserId())
                .build();

        return TasksEntity.builder()
                .id(taskId)
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .expiration(dto.getExpiration())
                .user(user)
                .build();
    }

    public List<TasksEntity> toEntity(List<TaskRequestDTO> dto) {
        return dto.stream()
                .map(this::toEntity)
                .toList();
    }
}
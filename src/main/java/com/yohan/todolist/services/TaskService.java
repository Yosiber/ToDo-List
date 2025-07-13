package com.yohan.todolist.services;

import com.yohan.todolist.entities.TasksEntity;


import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    TasksEntity createTaskByUserID(TasksEntity task);

    List<TasksEntity> findByUserId(Long userId);

    void updateTaskByUserID(TasksEntity task);

    void deleteTaskByUserID(Long userId, Long taskId);

    List<TasksEntity> searchTaskByExpiration(LocalDate expiration);
}

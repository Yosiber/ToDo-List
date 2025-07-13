package com.yohan.todolist.services.impl;

import com.yohan.todolist.entities.TasksEntity;
import com.yohan.todolist.entities.UsersEntity;
import com.yohan.todolist.enums.StatusTypes;
import com.yohan.todolist.exceptions.ForbiddenOperationException;
import com.yohan.todolist.exceptions.TaskNotFoundException;
import com.yohan.todolist.exceptions.UserIdNotFoundException;
import com.yohan.todolist.exceptions.UserNotFoundException;
import com.yohan.todolist.repositories.TaskRepository;
import com.yohan.todolist.repositories.UserRepository;
import com.yohan.todolist.services.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;


    @Override
    public TasksEntity createTaskByUserID(TasksEntity task) {

        validateUserID(task);

        Long userId = task.getUser().getId();

        UsersEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        task.setUser(user);
        task.setCreatedAt(LocalDateTime.now());
        task.setModified(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @Override
    public List<TasksEntity> findByUserId(Long userId) {
        return taskRepository.findByUser_Id(userId);
    }


    @Override
    public void updateTaskByUserID(TasksEntity task) {

        validateUserID(task);

        if (task.getId() == null) {
            throw new IllegalArgumentException("La id de la tarea no puede ser nula");
        }

        Long userId = task.getUser().getId();

        Long taskId = task.getId();

        TasksEntity existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        if (!existingTask.getUser().getId().equals(userId)) {
            throw new ForbiddenOperationException(userId);
        }

        if (task.getTitle() != null && !task.getTitle().isEmpty()) {
            existingTask.setTitle(task.getTitle());
        }

        if (task.getDescription() != null && !task.getDescription().isEmpty()) {
            existingTask.setDescription(task.getDescription());
        }

        if (task.getStatus() != null) {
            existingTask.setStatus(task.getStatus());
        } else {
            existingTask.setStatus(StatusTypes.INCOMPLETE);
        }

        existingTask.setModified(LocalDateTime.now());
        taskRepository.save(existingTask);
    }

    @Override
    public void deleteTaskByUserID(Long userId, Long taskId) {

        TasksEntity task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        if (!task.getUser().getId().equals(userId)) {
            throw new ForbiddenOperationException("La tarea no pertenece al usuario " + userId);
        }

        taskRepository.delete(task);
    }

    @Override
    public List<TasksEntity> searchTaskByExpiration(LocalDate expiration) {
        return taskRepository.findByExpiration(expiration);
    }


    private void validateUserID(TasksEntity task) {
        if (task.getUser() == null || task.getUser().getId() == null) {
            throw new UserIdNotFoundException("El ID del usuario es obligatorio");
        }
    }

}

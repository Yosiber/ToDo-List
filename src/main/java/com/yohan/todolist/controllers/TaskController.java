package com.yohan.todolist.controllers;

import com.yohan.todolist.dto.TaskRequestDTO;
import com.yohan.todolist.entities.TasksEntity;
import com.yohan.todolist.mapper.TaskMapper;
import com.yohan.todolist.services.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/clientes/tareas")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;


    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<TaskRequestDTO>> findTasksByUserId(@PathVariable Long userId) {
        List<TasksEntity> findTasksByUserId = taskService.findByUserId(userId);
        return ResponseEntity.ok(taskMapper.toDto(findTasksByUserId));
    }

    @GetMapping("/fecha/{expiration}")
    public ResponseEntity<List<TaskRequestDTO>> searchTaskByDate(@PathVariable LocalDate expiration) {
        List<TasksEntity> searchTask = taskService.searchTaskByExpiration(expiration);
        return ResponseEntity.ok(taskMapper.toDto(searchTask));
    }


    @PostMapping("/crear")
    public ResponseEntity<TaskRequestDTO> createTask(@Valid @RequestBody TaskRequestDTO taskDto) {
        TasksEntity createTask = taskService.createTaskByUserID(taskMapper.toEntity(taskDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskMapper.toDto(createTask));
    }

    @DeleteMapping("eliminar/usuario/{userId}/tarea/{taskId}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long userId,
            @PathVariable Long taskId
    ) {
        taskService.deleteTaskByUserID(userId, taskId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{taskId}")
    public ResponseEntity<Void> updateTaskByUserID(@RequestBody TaskRequestDTO taskDto, @PathVariable Long taskId) {
        taskService.updateTaskByUserID(taskMapper.toEntity(taskDto, taskId));
        return ResponseEntity.noContent().build();
    }

}

package com.yohan.todolist.repositories;

import com.yohan.todolist.entities.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TasksEntity, Long> {
    List<TasksEntity> findByUser_Id(Long userId);

    List<TasksEntity> findByExpiration(LocalDate expiration);

}
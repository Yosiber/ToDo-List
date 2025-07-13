package com.yohan.todolist.repositories;

import com.yohan.todolist.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

}

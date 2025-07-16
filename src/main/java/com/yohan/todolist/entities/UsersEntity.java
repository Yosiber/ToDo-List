package com.yohan.todolist.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_usuarios")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nombre")
    private String name;

    @Column(nullable = false, unique = true, name = "correo")
    private String email;

    @Column(nullable = false, name = "contraseña")
    private String password;

    @Column(nullable = false, name = "fecha_creacion")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "fecha_actualizacion")
    @LastModifiedDate
    private LocalDateTime updatedAt;


}


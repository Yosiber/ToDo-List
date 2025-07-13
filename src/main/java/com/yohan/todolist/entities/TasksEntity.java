package com.yohan.todolist.entities;

import com.yohan.todolist.enums.StatusTypes;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_tareas")
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "titulo")
    private String title;

    @Column(nullable = false, name = "descripcion")
    private String description;

    @Column(nullable = false, name = "estado")
    @Enumerated(EnumType.STRING)
    private StatusTypes status;

    @Column(nullable = false, name = "fecha_creacion")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "fecha_actualizacion")
    @LastModifiedDate
    private LocalDateTime modified;

    @Column(nullable = false, name = "fecha_expiracion")
    private LocalDate expiration;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsersEntity user;
}


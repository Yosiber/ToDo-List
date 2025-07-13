package com.yohan.todolist.dto;

import com.yohan.todolist.enums.StatusTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {

    @NotBlank(message = "")
    private String title;

    @NotEmpty
    private Long userId;

    private String description;

    private StatusTypes status;

    private LocalDate expiration;
}

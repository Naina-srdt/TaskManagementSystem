package com.TaskManagementSystem.TaskManagementSystem.dto;

import lombok.Data;

@Data
public class TaskDto {

    private Long id;
    private String title;
    private String description;
    private String status;
    private Long intern_id;
}

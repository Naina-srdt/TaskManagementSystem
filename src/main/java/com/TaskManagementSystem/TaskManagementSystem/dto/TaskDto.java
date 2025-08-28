package com.TaskManagementSystem.TaskManagementSystem.dto;

import com.TaskManagementSystem.TaskManagementSystem.enums.Status;

public record TaskDto (

     Long id,
     String title,
     String description,
     Status status,
     Long intern_id
) {}

package com.TaskManagementSystem.TaskManagementSystem.dto;

public record TaskDto (

     Long id,
     String title,
     String description,
     String status,
     Long intern_id
) {}

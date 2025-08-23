package com.TaskManagementSystem.TaskManagementSystem.mapper;

import com.TaskManagementSystem.TaskManagementSystem.dto.TaskDto;
import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import com.TaskManagementSystem.TaskManagementSystem.entities.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public static Task toEntity(TaskDto dto, Intern intern) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(Task.Status.valueOf(dto.getStatus())); // assumes valid enum string
        task.setIntern(intern);
        return task;
    }

    public static TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus().toString());
        dto.setIntern_id(task.getIntern().getId());
        return dto;
    }
}

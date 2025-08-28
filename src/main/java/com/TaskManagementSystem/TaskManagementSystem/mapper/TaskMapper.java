package com.TaskManagementSystem.TaskManagementSystem.mapper;

import com.TaskManagementSystem.TaskManagementSystem.dto.TaskDto;
import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import com.TaskManagementSystem.TaskManagementSystem.entities.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(TaskDto dto, Intern intern) {
        Task task = new Task();
        task.setId(dto.id());
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(dto.status());
        task.setIntern(intern);
        return task;
    }

    public  TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getIntern().getId()
        );
    }
}

package com.TaskManagementSystem.TaskManagementSystem.controller;

import com.TaskManagementSystem.TaskManagementSystem.dto.TaskDto;
import com.TaskManagementSystem.TaskManagementSystem.entities.Task;
import com.TaskManagementSystem.TaskManagementSystem.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interns")
public class InternController {

    private final TaskService taskService;

    public InternController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasks(@PathVariable Long id) {
        return taskService.getTaskByIntern(id);
    }

    @GetMapping("/{id}/task")
    public List<TaskDto> getByTaskStatus(@PathVariable Long id, @RequestParam Task.Status status) {
        return taskService.getTaskByStatus(id, status);
    }

    @GetMapping("/{id}/task/latest")
    public List<TaskDto> getLatestTask(@PathVariable Long id) {
        return taskService.getLatestTask(id);
    }
}

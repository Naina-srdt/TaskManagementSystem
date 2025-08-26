package com.TaskManagementSystem.TaskManagementSystem.controller;

import com.TaskManagementSystem.TaskManagementSystem.dto.InternDto;
import com.TaskManagementSystem.TaskManagementSystem.dto.TaskDto;
import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import com.TaskManagementSystem.TaskManagementSystem.entities.Task;
import com.TaskManagementSystem.TaskManagementSystem.service.InternService;
import com.TaskManagementSystem.TaskManagementSystem.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interns")
public class InternController {

    private final TaskService taskService;
    private final InternService internService;

    public InternController(TaskService taskService, InternService internService) {
        this.taskService = taskService;
        this.internService = internService;
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasks(@PathVariable Long id) {
        return taskService.getTaskByIntern(id);
    }

    @GetMapping("/{id}/tasks/status")
    public List<TaskDto> getByTaskStatus(@PathVariable Long id, @RequestParam Task.Status status) {
        return taskService.getTaskByStatus(id, status);
    }

    @GetMapping("/{id}/tasks/latest")
    public List<TaskDto> getLatestTask(@PathVariable Long id) {
        return taskService.getLatestTask(id);
    }

    @GetMapping("/name")
    public ResponseEntity<Intern> getInternByName(@RequestParam String name) {
        Intern intern = internService.getInternByName(name);
        return ResponseEntity.ok(intern);
    }
}

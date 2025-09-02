package com.TaskManagementSystem.TaskManagementSystem.controller;

import com.TaskManagementSystem.TaskManagementSystem.dto.InternDto;
import com.TaskManagementSystem.TaskManagementSystem.dto.TaskDto;
import com.TaskManagementSystem.TaskManagementSystem.dto.projection.InternTaskDetails;
import com.TaskManagementSystem.TaskManagementSystem.enums.Status;
import com.TaskManagementSystem.TaskManagementSystem.service.InternService;
import com.TaskManagementSystem.TaskManagementSystem.service.TaskService;
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

    @PostMapping("/add")
    public InternDto createIntern(@RequestBody InternDto internDto) {
        return internService.createIntern(internDto);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasks(@PathVariable Long id) {
        return taskService.getTaskByIntern(id);
    }

    @GetMapping("/{id}/tasks/status")
    public List<TaskDto> getByTaskStatus(@PathVariable Long id, @RequestParam Status status) {
        return taskService.getInternTaskByStatus(id, status);
    }

    @GetMapping("/{internId}/tasks/latest")
    public List<TaskDto> getLatestTask(@PathVariable Long internId) {
        return taskService.getLatestTask(internId);
    }

    @GetMapping("/with-tasks")
    public List<InternTaskDetails> getInternTaskDetails() {
        return internService.getInternTaskDetails();
    }
}

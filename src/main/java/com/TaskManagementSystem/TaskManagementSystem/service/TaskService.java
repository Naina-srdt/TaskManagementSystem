package com.TaskManagementSystem.TaskManagementSystem.service;

import com.TaskManagementSystem.TaskManagementSystem.dto.TaskDto;
import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import com.TaskManagementSystem.TaskManagementSystem.entities.Task;
import com.TaskManagementSystem.TaskManagementSystem.exception.CustomException;
import com.TaskManagementSystem.TaskManagementSystem.mapper.TaskMapper;
import com.TaskManagementSystem.TaskManagementSystem.repository.InternRepo;
import com.TaskManagementSystem.TaskManagementSystem.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepo taskRepo;
    private final  TaskMapper taskMapper;
    private final InternRepo internRepo;

    public TaskService(TaskRepo taskRepo, TaskMapper taskMapper, InternRepo internRepo) {
        this.taskRepo = taskRepo;
        this.taskMapper = taskMapper;
        this.internRepo = internRepo;
    }

    //Create a new task for an intern
    public TaskDto createTask(TaskDto taskDto) {
        Intern intern = internRepo.findById(taskDto.getIntern_id())
                .orElseThrow(() -> new CustomException("Intern not found with ID: " + taskDto.getIntern_id()));

        Task task = TaskMapper.toEntity(taskDto, intern);
        Task savedTask = taskRepo.save(task);
        return TaskMapper.toDto(savedTask);
    }

    //Get all tasks of an intern
    public List<TaskDto> getTaskByIntern(Long internId){
        return taskRepo.findByInternId(internId).stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());
    }

    //Update task status
    public TaskDto updateStatus(Long taskId, Task.Status status){
        Task task = taskRepo.findById(taskId).orElseThrow(() -> new CustomException("Not Found"));
        task.setStatus(status);
        return taskMapper.toDto(taskRepo.save(task));
    }

    //Find tasks of an intern by status
    public List<TaskDto> getTaskByStatus(Long internId, Task.Status status){
        return  taskRepo.findByInternAndStatus(internId, status).stream().map(TaskMapper::toDto).collect(Collectors.toList());
    }

    //Get latest 5 tasks of an intern
    public List<TaskDto> getLatestTask(Long internId){
        return taskRepo.findLatestTask(internId).stream().map(TaskMapper::toDto).collect(Collectors.toList());
    }

}

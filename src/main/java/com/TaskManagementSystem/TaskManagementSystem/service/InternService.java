package com.TaskManagementSystem.TaskManagementSystem.service;

import com.TaskManagementSystem.TaskManagementSystem.dto.InternDto;
import com.TaskManagementSystem.TaskManagementSystem.dto.TaskDto;
import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import com.TaskManagementSystem.TaskManagementSystem.mapper.InternMapper;
import com.TaskManagementSystem.TaskManagementSystem.repository.InternRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternService {

    private final InternRepo internRepo;
    private final InternMapper mapper;

    public InternService(InternRepo internRepo, InternMapper mapper) {
        this.internRepo = internRepo;
        this.mapper = mapper;
    }

    //Create a new Intern
    public InternDto createIntern(InternDto internDto) {
        Intern intern = mapper.toEntity(internDto);
        return mapper.toDto(internRepo.save(intern));
    }

    //Get Intern by their Name
    public List<TaskDto> getByName(InternDto internDto, String name) {
        return internRepo.findInternByName(name);
    }
}

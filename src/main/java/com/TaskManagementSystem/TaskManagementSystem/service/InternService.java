package com.TaskManagementSystem.TaskManagementSystem.service;

import com.TaskManagementSystem.TaskManagementSystem.dto.InternDto;
import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import com.TaskManagementSystem.TaskManagementSystem.mapper.InternMapper;
import com.TaskManagementSystem.TaskManagementSystem.repository.InternRepo;
import org.springframework.stereotype.Service;

@Service
public class InternService {

    private final InternRepo internRepo;
    private final InternMapper mapper;

    public InternService(InternRepo internRepo, InternMapper mapper) {
        this.internRepo = internRepo;
        this.mapper = mapper;
    }

    public InternDto createIntern(InternDto internDto) {
        Intern intern = mapper.toEntity(internDto);
        return mapper.toDto(internRepo.save(intern));
    }
}

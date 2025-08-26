package com.TaskManagementSystem.TaskManagementSystem.service;

import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import com.TaskManagementSystem.TaskManagementSystem.repository.InternRepo;
import org.springframework.stereotype.Service;

@Service
public class InternService {

    private final InternRepo internRepo;

    public InternService(InternRepo internRepo) {
        this.internRepo = internRepo;
    }

    public Intern getInternByName(String name) {
        return (Intern) internRepo.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Intern not found with name: " + name));
    }
}

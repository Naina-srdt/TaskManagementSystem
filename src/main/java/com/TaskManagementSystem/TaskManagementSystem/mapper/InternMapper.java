package com.TaskManagementSystem.TaskManagementSystem.mapper;

import com.TaskManagementSystem.TaskManagementSystem.dto.InternDto;
import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import org.springframework.stereotype.Component;

@Component
public class InternMapper {

    public Intern toEntity(InternDto interndto){
        Intern intern = new Intern();
        intern.setId(interndto.getId());
        intern.setName(interndto.getName());
        intern.setEmail(interndto.getEmail());
        return intern;
    }

    public InternDto toDto(Intern intern){
        InternDto internDto = new InternDto();
        internDto.setId(intern.getId());
        internDto.setName(intern.getName());
        internDto.setEmail(intern.getEmail());
        return internDto;
    }
}

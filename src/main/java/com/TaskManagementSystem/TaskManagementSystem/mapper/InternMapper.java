package com.TaskManagementSystem.TaskManagementSystem.mapper;

import com.TaskManagementSystem.TaskManagementSystem.dto.InternDto;
import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import org.springframework.stereotype.Component;

@Component
public class InternMapper {

    public Intern toEntity(InternDto interndto){
        Intern intern = new Intern();
        intern.setId(interndto.id());
        intern.setName(interndto.name());
        intern.setEmail(interndto.email());
        return intern;
    }

    public InternDto toDto(Intern intern){
        return new InternDto(
                intern.getId(),
                intern.getName(),
                intern.getEmail()
        );
    }
}

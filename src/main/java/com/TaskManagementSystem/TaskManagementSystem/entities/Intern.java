package com.TaskManagementSystem.TaskManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Intern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Email(message = "Email must be valid")
    private String email;

    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> tasks;

}

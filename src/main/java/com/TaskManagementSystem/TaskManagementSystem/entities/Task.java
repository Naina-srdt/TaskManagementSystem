package com.TaskManagementSystem.TaskManagementSystem.entities;

import com.TaskManagementSystem.TaskManagementSystem.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "intern_id")
    private Intern intern;

    @Enumerated(EnumType.STRING)
    private Status status;
}

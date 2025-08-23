package com.TaskManagementSystem.TaskManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "intern_id")
    @JsonIgnore
    private Intern intern;

    public enum Status{
        PENDING,IN_PROGRESS,COMPLETED;
    }
}

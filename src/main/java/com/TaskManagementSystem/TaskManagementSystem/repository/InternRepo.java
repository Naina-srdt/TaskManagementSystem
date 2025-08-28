package com.TaskManagementSystem.TaskManagementSystem.repository;

import com.TaskManagementSystem.TaskManagementSystem.dto.projection.InternTaskDetails;
import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternRepo extends JpaRepository<Intern, Long> {

    //Get Intern with their task details
    @Query(value = """
             select intern.id,intern.name,intern.email, task.title, task.description,task.status
             from task,intern
             where task.intern_id = intern.id
            """, nativeQuery = true)
    List<InternTaskDetails> getInternTaskDetails();
}

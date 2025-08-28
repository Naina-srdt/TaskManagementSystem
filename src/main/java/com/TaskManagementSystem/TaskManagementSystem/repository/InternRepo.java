package com.TaskManagementSystem.TaskManagementSystem.repository;

import com.TaskManagementSystem.TaskManagementSystem.dto.TaskDto;
import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternRepo extends JpaRepository<Intern, Long> {

    //Find Intern by Name
    @Query(value = "select * from intern where name LIKE 'a%'", nativeQuery = true)
    List<TaskDto> findInternByName(String name);
}

package com.TaskManagementSystem.TaskManagementSystem.repository;

import com.TaskManagementSystem.TaskManagementSystem.entities.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InternRepo extends JpaRepository<Intern, Long> {

    Optional<Intern> findByNameIgnoreCase(String name);
}

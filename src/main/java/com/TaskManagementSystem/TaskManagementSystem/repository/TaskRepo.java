package com.TaskManagementSystem.TaskManagementSystem.repository;

import com.TaskManagementSystem.TaskManagementSystem.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    @Query(value = "select t from task where id = :internId AND status = IN_PROGRESS",nativeQuery = true)
    List<Task> findInternByIdAndStatus(Long internId, Task.Status status);

    @Query(value = "SELECT * FROM task WHERE intern_id = :internId ORDER BY id DESC LIMIT 5",nativeQuery = true)
    List<Task> findLatestTask(Long internId);

    List<Task> findByInternId(Long internId);
}

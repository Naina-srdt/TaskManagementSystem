package com.TaskManagementSystem.TaskManagementSystem.repository;

import com.TaskManagementSystem.TaskManagementSystem.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    @Query(value = "select t from task where id = internId AND status = status",nativeQuery = true)
    List<Task> findByInternAndStatus(Long internId, Task.Status status);

    @Query(value = "select * from task where id = 1 order by id DESC Limit 5",nativeQuery = true)
    List<Task> findLatestTask(Long internId);

    List<Task> findByInternId(Long internId);
}

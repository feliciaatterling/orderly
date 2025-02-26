package com.felicia.studyapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felicia.studyapp.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    Optional<Task> findTaskByName(String name);
    
}

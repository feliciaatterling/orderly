package com.felicia.studyapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felicia.studyapp.models.Task;
import com.felicia.studyapp.repositories.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task addNewTask(Task task) {
        Optional<Task> taskByName = taskRepository.findTaskByName(task.getName());
        if (taskByName.isPresent()) {
            throw new IllegalStateException("Name already taken");
        }
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setName(updatedTask.getName());
                    task.setDescription(updatedTask.getDescription());
                    task.setDeadline(updatedTask.getDeadline());
                    task.setImportance(updatedTask.getImportance());
                    task.setDifficulty(updatedTask.getDifficulty());
                    task.setSize(updatedTask.getSize());
                    task.setTag(updatedTask.getTag());
                    
                    return taskRepository.save(task); 
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    public void deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }


}

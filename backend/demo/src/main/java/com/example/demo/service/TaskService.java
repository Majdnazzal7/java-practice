package com.example.demo.service;


import com.example.demo.Task;
import com.example.demo.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Create a new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

// Update an existing task
public Task updateTask(Long id, Task updatedTask) {

    Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found"));

    task.setTitle(updatedTask.getTitle());
    task.setDescription(updatedTask.getDescription());
    task.setCompleted(updatedTask.getCompleted());

    return taskRepository.save(task);
}

    // Get task by ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // Delete task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

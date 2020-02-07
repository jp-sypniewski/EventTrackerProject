package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Task;
import com.skilldistillery.eventtracker.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository repo;
	
	@Override
	public List<Task> getAllTasks(){
		return repo.findAll();
	}
	
	@Override
	public Task getTaskById(int id) {
		Optional<Task> opt = repo.findById(id);
		Task task = null;
		if (opt.isPresent()) {
			task = opt.get();
		}
		return task;
	}
	
	@Override
	public Task createTask(Task task) {
		task = repo.saveAndFlush(task);
		return task;
	}
	
	@Override
	public Task updateTask(Task task) {
		Task updatedTask = new Task();
		updatedTask.setId(task.getId());
		updatedTask.setName(task.getName());
		updatedTask.setStatus(task.getStatus());
		updatedTask.setDueDate(task.getDueDate());
		updatedTask = repo.saveAndFlush(updatedTask);
		return updatedTask;
	}
	
	public boolean deleteTask(int id) {
		boolean deleted = false;
		
		
		
		return deleted;
	}

}

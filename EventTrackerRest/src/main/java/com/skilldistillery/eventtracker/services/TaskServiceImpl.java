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
	public Task updateTask(int tid, Task task) {
		Task updatedTask = null;
		Optional<Task> opt = repo.findById(tid);
		if (opt.isPresent()) {
			updatedTask = opt.get();
			updatedTask.setName(task.getName());
			updatedTask.setStatus(task.getStatus());
			updatedTask.setDueDate(task.getDueDate());
			updatedTask = repo.saveAndFlush(updatedTask);
		}
		
		return updatedTask;
	}
	
	@Override
	public boolean deleteTask(int id) {
		boolean deleted = false;
		if (repo.existsById(id)) {
			repo.deleteById(id);
			deleted = true;
		}
		return deleted;
	}

}

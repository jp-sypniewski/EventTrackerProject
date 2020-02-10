package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Task;
import com.skilldistillery.eventtracker.entities.Team;
import com.skilldistillery.eventtracker.repositories.TaskRepository;
import com.skilldistillery.eventtracker.repositories.TeamRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository repo;
	
	@Autowired
	private TeamRepository tRepo;
	
	@Override
	public List<Task> getAllTasksByTeam(int teamId){
		return repo.findByTeam_Id(teamId);
	}
	
	@Override
	public Task getTaskById(int teamId, int taskId) {
		Optional<Task> opt = repo.findById(taskId);
		Task task = null;
		if (opt.isPresent()) {
			task = opt.get();
			if (task.getTeam().getId() != teamId) {
				task = null;
			}
		}
		return task;
	}
	
	@Override
	public Task createTask(int teamId, Task task) {
		Task newTask = null;
		Optional<Team> opt = tRepo.findById(teamId);
		if (opt.isPresent()) {
			task.setTeam(opt.get());
			newTask = repo.saveAndFlush(task);
		}
		return newTask;
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

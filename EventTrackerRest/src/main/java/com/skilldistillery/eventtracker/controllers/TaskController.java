package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Task;
import com.skilldistillery.eventtracker.services.TaskService;

@RequestMapping("api")
@RestController
public class TaskController {
	
	@Autowired
	private TaskService svc;
	
	@GetMapping("tasks")
	public List<Task> getAllTasks(){
		List<Task> tasks = svc.getAllTasks();
		return tasks;
	}
	
	@GetMapping("tasks/{tid}")
	public Task getSingleTask(@PathVariable int tid) {
		Task task = svc.getTaskById(tid);
		if (task != null) {
			
		} else {
			
		}
		return task;
	}
	
	@PostMapping("tasks")
	public Task addTask(@RequestBody Task task) {
		task = svc.createTask(task);
		
		return task;
	}
	
	@PutMapping("tasks/{tid}")
	public Task updateTask(@PathVariable int tid,
			@RequestBody Task task) {
		task = svc.updateTask(tid, task);
		
		return task;
	}
	
	@DeleteMapping("tasks/{tid}")
	public void deleteTask(@PathVariable int tid) {
		boolean deleted = svc.deleteTask(tid);
		if (deleted) {
			
		} else {
			
		}
	}

}

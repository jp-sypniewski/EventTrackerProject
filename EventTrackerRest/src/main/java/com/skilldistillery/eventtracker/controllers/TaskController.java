package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Task addTask(@RequestBody Task task,
			HttpServletResponse response,
			HttpServletRequest request) {
		try {
			Task addedTask = svc.createTask(task);
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/")
				.append(addedTask.getId());
			response.setHeader("Location", url.toString());
			return addedTask;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			return null;
		}
	}
	
	@PutMapping("tasks/{tid}")
	public Task updateTask(@PathVariable int tid,
			@RequestBody Task task,
			HttpServletResponse response,
			HttpServletRequest request) {
		try {
			Task updatedTask = svc.updateTask(tid, task);
			if (updatedTask == null) {
				response.setStatus(400);
				return updatedTask;
			}
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/")
				.append(updatedTask.getId());
			response.setHeader("Location", url.toString());
			return updatedTask;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			return null;
		}
	}
	
	@DeleteMapping("tasks/{tid}")
	public void deleteTask(@PathVariable int tid,
			HttpServletResponse response) {
		try {
			boolean deleted = svc.deleteTask(tid);
			if (deleted) {
			response.setStatus(204);
			} else {
				response.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
		}
	}

}

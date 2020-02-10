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
	
	@GetMapping("teams/{teamId}/tasks")
	public List<Task> getAllTasksByTeam(@PathVariable Integer teamId) {
		List<Task> tasks = svc.getAllTasksByTeam(teamId);
		return tasks;
	}
	
	@GetMapping("teams/{teamId}/tasks/{taskId}")
	public Task getSingleTask(@PathVariable int teamId,
			@PathVariable int taskId,
			HttpServletResponse response) {
		Task task = svc.getTaskById(teamId, taskId);
		if (task == null) {
			response.setStatus(404);
		}
		return task;
	}
	
	@PostMapping("teams/{teamId}/tasks")
	public Task addTask(@PathVariable int teamId,
			@RequestBody Task task,
			HttpServletResponse response,
			HttpServletRequest request) {
		try {
			Task addedTask = svc.createTask(teamId, task);
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
	
	@PutMapping("teams/{teamId}/tasks/{taskId}")
	public Task updateTask(@PathVariable int teamId, 
			@PathVariable int taskId,
			@RequestBody Task task,
			HttpServletResponse response,
			HttpServletRequest request) {
		try {
			Task updatedTask = svc.updateTask(teamId, taskId, task);
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
	
	@DeleteMapping("teams/{teamId}/tasks/{taskId}")
	public void deleteTask(@PathVariable int teamId, 
			@PathVariable int taskId,
			HttpServletResponse response) {
		try {
			boolean deleted = svc.deleteTask(teamId, taskId);
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

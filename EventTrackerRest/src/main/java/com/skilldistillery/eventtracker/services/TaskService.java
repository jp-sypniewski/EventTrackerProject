package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Task;

public interface TaskService {

	List<Task> getAllTasksByTeam(int teamId);

	Task getTaskById(int teamId, int taskId);
	
	Task createTask(int teamId, Task task);

	Task updateTask(int tid, Task task);

	boolean deleteTask(int id);





}

package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Task;

public interface TaskService {

	List<Task> getAllTasks();

	Task getTaskById(int id);
	
	Task createTask(Task task);

	Task updateTask(int tid, Task task);

	boolean deleteTask(int id);


}

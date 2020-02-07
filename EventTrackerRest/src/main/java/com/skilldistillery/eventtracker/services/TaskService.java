package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Task;

public interface TaskService {

	List<Task> getAllTasks();

	Task getTaskById(int id);

	Task updateTask(Task task);

	Task createTask(Task task);

	boolean deleteTask(int id);

}

package com.skilldistillery.eventtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	List<Task> findByTeam_Id(int teamId);
	
}

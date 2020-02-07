package com.skilldistillery.jpaeventtracker.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Task {
	
	private int id;
	
	private String name;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	private LocalDateTime dueDate;
	
	private Status status;

}

package com.skilldistillery.eventtracker.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Team {
	
	// Fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="team")
	private List<Task> tasks;
	
	@JsonIgnore
	@OneToMany(mappedBy="team")
	private List<User> users;
	
	// Constructors

	public Team() {
		super();
	}

	public Team(int id, String name, List<Task> tasks, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.tasks = tasks;
		this.users = users;
	}
	
	// Getters/Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	// toString, hashCode, equals

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Team [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", tasks=");
		builder.append(tasks);
		builder.append(", users=");
		builder.append(users);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

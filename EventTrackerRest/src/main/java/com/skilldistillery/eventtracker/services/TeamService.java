package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Team;

public interface TeamService {

	List<Team> getAllTeams();
	
	Team getSingleTeam(int teamId);

	Team createTeam(Team team);

	Team updateTeam(int teamId, Team team);

}

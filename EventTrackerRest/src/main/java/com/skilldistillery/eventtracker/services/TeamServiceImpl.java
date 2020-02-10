package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Team;
import com.skilldistillery.eventtracker.repositories.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository repo;
	
	@Override
	public List<Team> getAllTeams() {
		List<Team> teams = repo.findAll();
		return teams;
	}
	
	@Override
	public Team getSingleTeam(int teamId) {
		Team team = null;
		Optional<Team> opt = repo.findById(teamId);
		if (opt.isPresent()) {
			team = opt.get();
		}
		return team;
	}
	
	@Override
	public Team createTeam(Team team) {
		Team newTeam = repo.saveAndFlush(team);
		return newTeam;
	}
	
	@Override
	public Team updateTeam(int teamId, Team team) {
		Team updatedTeam = null;
		Optional<Team> opt = repo.findById(teamId);
		if (opt.isPresent()) {
			updatedTeam = opt.get();
			updatedTeam.setName(team.getName());
		}
		return updatedTeam;
	}
		
}

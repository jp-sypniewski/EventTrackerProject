package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Team;
import com.skilldistillery.eventtracker.services.TeamService;

@RequestMapping("api")
@RestController
public class TeamController {
	
	@Autowired
	private TeamService svc;
	
	@GetMapping(path="teams")
	public List<Team> getAllTeams(){
		List<Team> teams = svc.getAllTeams();
		return teams;
	}
	
	@GetMapping(path="teams/{teamId}")
	public Team getSingleTeam(@PathVariable int teamId,
			HttpServletResponse response) {
		Team team = svc.getSingleTeam(teamId);
		if (team == null) {
			response.setStatus(404);
		}
		return team;
	}
	
	@PostMapping(path="teams")
	public Team addTeam(@RequestBody Team team,
			HttpServletResponse response,
			HttpServletRequest request) {		
		try {
			Team newTeam = svc.createTeam(team);
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/")
				.append(newTeam.getId());
			response.setHeader("Location", url.toString());
			return newTeam;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			return null;
		}
	}
	
	@PutMapping(path="teams/{teamId}")
	public Team updateTeam(@PathVariable int teamId,
			@RequestBody Team team,
			HttpServletResponse response,
			HttpServletRequest request) {		
		try {
			Team updatedTeam = svc.updateTeam(teamId, team);
			if (updatedTeam == null) {
				response.setStatus(400);
				return updatedTeam;
			}
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/")
				.append(updatedTeam.getId());
			response.setHeader("Location", url.toString());
			return updatedTeam;
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			return null;
		}
	}
	
	

}

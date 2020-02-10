package com.skilldistillery.eventtracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.services.TeamService;

@RequestMapping("api")
@RestController
public class TeamController {
	
	@Autowired
	private TeamService svc;
	

}

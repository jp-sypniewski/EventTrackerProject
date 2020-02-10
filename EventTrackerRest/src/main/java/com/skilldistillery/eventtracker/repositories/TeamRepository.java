package com.skilldistillery.eventtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}

package com.skilldistillery.eventtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTests {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("EventTracker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		user = null;
		em.close();
	}

	@DisplayName("testing user mapping entity for username")
	@Test
	void test0() {
		assertEquals("",user.getUsername());
	}
	
	@DisplayName("testing user mapping entity for email")
	@Test
	void test1() {
		assertEquals("", user.getEmail());
	}
	
	@DisplayName("testing user mapping entity for password")
	@Test
	void test2() {
		assertEquals("", user.getPassword());
	}
	
	@DisplayName("testing user mapping entity for team name")
	@Test
	void test3() {
		assertEquals("", user.getTeam().getName());
	}

}

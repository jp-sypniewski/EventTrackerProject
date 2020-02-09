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

class TaskTests {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Task task;

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
		task = em.find(Task.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		task = null;
		em.close();
	}

	@DisplayName("testing task mapping entity for name")
	@Test
	void test0() {
		assertEquals("homework",task.getName());
	}
	
	@DisplayName("testing task mapping entity for status")
	@Test
	void test1() {
		assertEquals(Status.open,task.getStatus());
	}
	
	@DisplayName("testing category mapping entity for due date")
	@Test
	void test2() {
		assertEquals(LocalDateTime.of(2020, 12, 12, 0, 0, 0),task.getDueDate());
	}
	
	@DisplayName("testing category mapping entity for due date")
	@Test
	void test3() {
		assertEquals("teamone",task.getTeam().getName());
	}

}

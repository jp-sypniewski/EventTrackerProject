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

class GroupTests {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Group group;

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
		group = em.find(Group.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		group = null;
		em.close();
	}

	@DisplayName("testing group mapping entity for name")
	@Test
	void test0() {
		assertEquals("",group.getName());
	}
	
	@DisplayName("testing group mapping entity for user list")
	@Test
	void test1() {
		assertEquals(0,group.getUsers().size());
	}
	
	@DisplayName("testing group mapping entity for task list")
	@Test
	void test2() {
		assertEquals(0,group.getTasks().size());
	}


}

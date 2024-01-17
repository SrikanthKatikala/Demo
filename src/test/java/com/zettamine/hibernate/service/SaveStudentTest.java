package com.zettamine.hibernate.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zettamine.hibernate.entity.Student;

class SaveStudentTest {
	private static SaveStudent save;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		save = new SaveStudent();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		save = null;
	}

	@Test
	void testInsertStudentDetails() {
		save.insertStudentDetails();
		assertNotNull(save);
	}

}

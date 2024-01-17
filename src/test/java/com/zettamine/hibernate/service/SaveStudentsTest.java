package com.zettamine.hibernate.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SaveStudentsTest {

	private static SaveStudents students;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		students = new SaveStudents();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		students = null;
	}

	@Test
	void test() {
		students.insertMultipleStudentDetails();
		assertNotNull(students);
	}

}

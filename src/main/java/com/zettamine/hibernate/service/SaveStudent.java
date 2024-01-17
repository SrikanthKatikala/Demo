package com.zettamine.hibernate.service;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zettamine.hibernate.entity.Student;

public class SaveStudent {
	
	private static final Logger LOGGER = LogManager.getLogger(SaveStudent.class);

	public void insertStudentDetails() {
		
		LOGGER.info("INFO Message "+LocalDateTime.now());
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml"); // XML Parsing - DOM parser
		SessionFactory sFactory = config.buildSessionFactory();
		
		Session session = sFactory.openSession();
		
		Transaction txt = session.beginTransaction();
		Student student = new Student();
		student.setStudentId(101);
		student.setStudentName("Ravi");
		student.setStudentEmail("ravi@gmail.com"); //transient
		
		session.save(student); // persistent
		System.out.println("======================================================");
		//session.evict(student); detached
		txt.commit();
		session.close();
		sFactory.close();
	}
}

//public static void main(String[] args) {
//SaveStudent s1 = new SaveStudent();
//s1.insertStudentDetails();
//}

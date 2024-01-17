package com.zettamine.hibernate.service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utility.HibernateUtility;

public class SaveStudents {

//	public static void main(String[] args) {
//		SaveStudents students = new SaveStudents();
//		students.insertMultipleStudentDetails();
//	}
	private static final Logger LOGGER = LogManager.getLogger(SaveStudent.class);
	
	public void insertMultipleStudentDetails() {
		
		
		LOGGER.info(" "+LocalDateTime.now());
		SessionFactory sFactory = HibernateUtility.getSessionFactory();
		Session session = sFactory.openSession();
		Transaction txt = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		String req ="";
		do {
			System.out.println("Enter student name and email: ");
			String name = sc.next();
			String email =sc.next();
			
			Student student = new Student(name, email);
			session.save(student);
			System.out.println("do you want to save one more student details ? [Y/N]: ");
			req = sc.next();
			Serializable studentId = student.getStudentId();
			System.out.printf("Student id is: %d\n\n",studentId);
		} while (req.equalsIgnoreCase("y"));
		
		txt.commit();
		session.close();
		sFactory.close();
	}
}

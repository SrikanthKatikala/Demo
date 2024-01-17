package com.zettamine.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utility.HibernateUtility;

public class UpdateStudent {

	public static void main(String[] args) {
		UpdateStudent us = new UpdateStudent();
		us.updateStudentDetails();
	}
	public void updateStudentDetails() {
		SessionFactory sf = HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
//		//--- updating student - approach-1 ---
//		Student student = new Student(104, "abdulzetta", "abdula@zetamine");
//		session.update(student);
		
		//---updating a student - approach-2 ---
				Student student = session.get(Student.class, 108);
				
				if(student != null) {
					System.out.println(student);
					student.setStudentName("koti"); //dirty object
				}else {
					System.out.println("--- no matching student found ----");
				}
				session.getTransaction().commit();
				session.close();
				sf.close();
	}
}

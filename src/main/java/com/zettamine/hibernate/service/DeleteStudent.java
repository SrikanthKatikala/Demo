package com.zettamine.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utility.HibernateUtility;

public class DeleteStudent {

	public static void main(String[] args) {
		DeleteStudent ds = new DeleteStudent();
		ds.deleteingStudentDetailsApproach1();
		//ds.deletetingStudentDetailsApproach2();
	}
	
	public void deleteingStudentDetailsApproach1() {
		SessionFactory sf = HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Student student = new Student(109, "krishna", "krish@gmail.com");
		session.delete(student);
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}
	
	public void deletetingStudentDetailsApproach2() {
		SessionFactory sf = HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();	
		
		Student student = session.get(Student.class, 108);
		if (student!=null) {
			System.out.println(student);
			//session.evict(student);
			session.delete(student);
		} else {
			System.out.println("-----No Match Record Found-----");
		}
		
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}

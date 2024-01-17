package com.zettamine.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utility.HibernateUtility;

public class SearchStudent1 {

	public static void main(String[] args) {
		SearchStudent1 s1 = new SearchStudent1();
		s1.getStudentDetailsLoadMethod();
		s1.getStudentDetailsGetMethod();
		s1.getStudentDetailsLoadMethod2();
	}
	public void getStudentDetailsLoadMethod() {
		
		SessionFactory sf = HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		
		Student student = new Student();
		System.out.println(student);
		try {
		session.load(student, 101);
		//session.load(student,1019);
		/*
		 * if id is not exists load method will give  org.hibernate.ObjectNotFoundException
		 */}catch(Exception e) {
			 System.out.println(e);
		 }
		System.out.println(student);
		
	}
	
	public void getStudentDetailsGetMethod() {
		SessionFactory sf = HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		
		Student student = session.get(Student.class, 105);
		//Student student = session.get(Student.class, 1019);
		/*
		 * Even though id is not exists get method create a object 
		 * */
		
		if (student!=null) {
			System.out.println(student);
		} else {
			System.out.println("------No matching record------");
		}
	}
	public void getStudentDetailsLoadMethod2() {
		SessionFactory sf = HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		
		Student student = session.load(Student.class, 1019);
		/*
		 * if id is not exists load method will give  org.hibernate.ObjectNotFoundException
		 * */
		
		System.out.println(student);
		session.close();
		sf.close();
	}
}

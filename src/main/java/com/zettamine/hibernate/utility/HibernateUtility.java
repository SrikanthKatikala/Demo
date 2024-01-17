package com.zettamine.hibernate.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	private static SessionFactory sFactory;
	 public static SessionFactory getSessionFactory() {
		 if (sFactory==null) {
			 Configuration config = new Configuration();
				config.configure("hibernate.cfg.xml"); // XML Parsing - DOM parser
				sFactory = config.buildSessionFactory();
				
		}
		 return sFactory;
	 }
}

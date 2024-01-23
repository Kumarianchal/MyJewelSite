package com.myjewel.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtility {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		try {
			if(sessionFactory==null) {
				sessionFactory=new Configuration()
						.configure("hibernate.cfg.xml")
						.buildSessionFactory();		
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return sessionFactory;
	}
	
	

}

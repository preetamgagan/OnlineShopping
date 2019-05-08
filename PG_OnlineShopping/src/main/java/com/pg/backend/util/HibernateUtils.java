package com.pg.backend.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static final SessionFactory factory;
	
	static {
		Configuration cfg = null;
		cfg = new Configuration();
		cfg.configure("/com/pg/backend/configure/hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		Session session = null;
		System.out.println("Factory :"+ factory);
		if(factory!=null) {
			if(session==null) {
				session = factory.openSession();
			}
		}
		//session = factory.getCurrentSession();
		System.out.println("Session :"+session);
		return session;
	}

public static  void closeSession(Session ses) {
     if(ses!=null)
    	 ses.close();
}

public  static void closeSessionFactory() {
	if(factory!=null)
		factory.close();
}
}


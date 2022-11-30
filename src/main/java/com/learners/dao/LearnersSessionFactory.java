package com.learners.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public  class LearnersSessionFactory {
	
	public static SessionFactory getDBConnection()
	{
		Configuration confi= new Configuration().configure();
		confi.addAnnotatedClass(com.learners.beans.Student.class);
		confi.addAnnotatedClass(com.learners.beans.Class.class);
		confi.addAnnotatedClass(com.learners.beans.Subject.class);
		confi.addAnnotatedClass(com.learners.beans.Teacher.class);
		confi.addAnnotatedClass(com.learners.beans.Collaborations.class);
		StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(confi.getProperties());
		SessionFactory factory = confi.buildSessionFactory(builder.build());
		return factory;
	}

}

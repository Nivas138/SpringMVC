package com.learingspring.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.learningspring.DAO.UserDetails;

@Component
public class SaveService {
	
	//private SessionFactory sessionFactory;
	
	public void save(UserDetails us) {
		
		Configuration cf = new Configuration().configure("hiberConfig.cfg.xml");
		
		SessionFactory ses = cf.buildSessionFactory();
		
		Session sss = ses.getCurrentSession();
		
		sss.save(us);		
	}
}

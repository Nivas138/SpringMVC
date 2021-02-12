package com.learingspring.service;

import javax.imageio.spi.ServiceRegistry;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.hibernate.service.*;

import com.learningspring.DAO.Laptop;
import com.learningspring.DAO.UserDetails;

@Component
public class SaveService {
	
	//private SessionFactory sessionFactory;
	
	public void save(UserDetails us,Laptop lp) {
		
		Configuration cf = new Configuration().configure("hiberConfig.cfg.xml").addAnnotatedClass(UserDetails.class).addAnnotatedClass(Laptop.class);
		
		SessionFactory ses = cf.buildSessionFactory();
		
		Session sss = ses.openSession();
		
		Transaction tx = sss.beginTransaction();
		
		//Put the Data in Data
		if(us != null) {
			sss.save(us);
		}else if(lp != null) {
			sss.save(lp);
		}
		
		
		tx.commit();
		
		ses.close();
				
	}
	
	public UserDetails get(int id) {
		
		Configuration cf = new Configuration().configure("hiberConfig.cfg.xml").addAnnotatedClass(UserDetails.class).addAnnotatedClass(Laptop.class);
		
		SessionFactory sf = cf.buildSessionFactory();
		
		Session ss = sf.openSession();
		
		Transaction tx = ss.beginTransaction();
		
		UserDetails us = null;
		
		Query q1 = ss.createQuery("from dbo.User_Details  where id="+id);
		
		us = (UserDetails) q1.uniqueResult();
		
		tx.commit();
		
		ss.close();
		
		return us;
		
	}
	
}

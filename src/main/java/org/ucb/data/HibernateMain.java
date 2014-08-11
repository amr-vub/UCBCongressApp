package org.ucb.data;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.ucb.data.dao.AnonymousUserManager;
import org.ucb.data.dao.IAnonymousUserManager;
import org.ucb.data.domain.Agenda;
import org.ucb.data.domain.HCP;
import org.ucb.data.domain.HCPInitialInterests;

public class HibernateMain {

	@Transactional
	public static void main(String[] args) {

		//Session session = connect2DB();
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		
		IAnonymousUserManager anonymousUserManager = applicationContext.getBean("anonymousUserManager", AnonymousUserManager.class);
		
		HCP user = new HCP();
		
		
		//
		Agenda hCP_agenda = new Agenda();
		hCP_agenda.setAgenda_hcp(user);
		List<HCPInitialInterests> hCP_hcpInitialInterests = new ArrayList<HCPInitialInterests>();
		HCPInitialInterests hcpInitialInterests = new HCPInitialInterests();
		hcpInitialInterests.setHCP_Initial_Interest("eplipsy");
		hcpInitialInterests.setHCPInitialInterests_hcp(user);
		hCP_hcpInitialInterests.add(hcpInitialInterests);
		
		user.setHCPID(0);
		user.setRegesteredStatus(true);
		user.setSpecialization("Eplipsy");
		user.setSub_specialization("Eplipsy Surgury");
		user.setHCP_agenda(hCP_agenda);
		user.setAcademic_practitioner_value("Academic");
		user.setHCP_hcpInitialInterests(hCP_hcpInitialInterests);
		
		//session.beginTransaction();
		
		//System.out.print(session.save(user));
				
		//session.getTransaction().commit();
		
		//System.out.print(anonymousUserManager.storeAnonymousUser(user));

		System.out.print(anonymousUserManager.anonymousUserExists(0));
	}
	
	private static Session connect2DB(){
		Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
		
		return session;
	}

}

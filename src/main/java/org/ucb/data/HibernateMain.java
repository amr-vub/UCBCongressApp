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
import org.ucb.data.domain.FeedbackAnswer;
import org.ucb.data.domain.HCP;
import org.ucb.data.domain.HCPInitialInterests;
import org.ucb.service.IServiceStub;
import org.ucb.service.ServiceStub;

public class HibernateMain {

	public static void main(String[] args) {

		//Session session = connect2DB();
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		
		IServiceStub iServiceStub = (IServiceStub) applicationContext.getBean("serviceStub");	
		HCP user = new HCP();
		
		
		//Initialization
		Agenda hCP_agenda = new Agenda();
		List<HCPInitialInterests> hCP_hcpInitialInterests = new ArrayList<HCPInitialInterests>();
		HCPInitialInterests hcpInitialInterests = new HCPInitialInterests();
		org.ucb.data.domain.Session ses = new org.ucb.data.domain.Session();
		List<org.ucb.data.domain.Session> sesArr = new ArrayList<org.ucb.data.domain.Session>();
		sesArr.add(ses);
		
		// Agenda
		hCP_agenda.setAgenda_hcp(user);
		hCP_agenda.setAgenda_Session(sesArr);
		//hCP_agenda.setAgenda_Session();
		
		//setting initial interests

		hcpInitialInterests.setHCP_Initial_Interest("eplipsy");
		hcpInitialInterests.setHCPInitialInterests_hcp(user);
		hCP_hcpInitialInterests.add(hcpInitialInterests);

		
		// feedback answer
		FeedbackAnswer fbAns = new FeedbackAnswer();
		fbAns.setFbAnswer(3);
		
		user.setHCPID(0);
		user.setRegesteredStatus(true);
		user.setSpecialization("Eplipsy1");
		user.setSub_specialization("Eplipsy Surgury");
		user.setHCP_agenda(hCP_agenda);
		user.setAcademic_practitioner_value("Academic");
		user.setHCP_hcpInitialInterests(hCP_hcpInitialInterests);
		
		//session.beginTransaction();
		
		//System.out.print(session.save(user));
				
		//session.getTransaction().commit();
		
		//System.out.print(iServiceStub.storeAnonymousUser(user));

		//HCP u = new HCP();
		//u.setHCPID(0);
		
		iServiceStub.deleteAnonymousUser(user);
		
		//anonymousUserManager.updateAnonymousUser(user);
		
		//System.out.print(anonymousUserManager.anonymousUserExists(0));
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

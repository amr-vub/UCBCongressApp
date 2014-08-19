package org.ucb.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;
import org.ucb.service.model.Greeting;
import org.ucb.service.model.Tservice;
import org.ucb.data.domain.Agenda;
import org.ucb.data.domain.FeedbackAnswer;
import org.ucb.data.domain.HCP;
import org.ucb.data.domain.HCPInitialInterests;
import org.ucb.service.IAnonymousUserServiceStub;

@ComponentScan({"org.ucb.sevices.controllers", "org.ucb.sevices.domain"})
@EnableAutoConfiguration
@ImportResource("/Spring-Module.xml")
public class Application {

    public static void main(String[] args) {
		/*
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/Spring-Module.xml");
		
		
		IAnonymousUserServiceStub iServiceStub = (IAnonymousUserServiceStub) applicationContext.getBean("anonymousUserServiceStub");
		
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
		
		//System.out.print(iServiceStub.storeAnonymousUser(user));
		*/    	
    	
        Tservice tservice = new Tservice();
        Greeting g = tservice.doInd();
        
        System.out.print(g.getContent());
    	
    	SpringApplication.run(Application.class, args);
   
    }
}
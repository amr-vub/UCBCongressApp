package org.ucb.service.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ucb.data.dao.IRegisteredUserManager;
import org.ucb.data.domain.Agenda;
import org.ucb.data.domain.FeedbackAnswer;
import org.ucb.data.domain.HCP;
import org.ucb.data.domain.HCPInitialInterests;
import org.ucb.data.domain.Login;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.service.IAnonymousUserServiceStub;
import org.ucb.service.model.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private IAnonymousUserServiceStub iAnonymousUserServiceStub;
    
    @Autowired
    private IRegisteredUserManager iRegisteredUserManager;

    @RequestMapping("/greeting")
    @Transactional
    public Greeting greeting(@RequestParam(value="accessCode", required=false, defaultValue="World") String name) {

    	HCP user = new HCP();
		
    	//HCP u = getiAnonymousUserServiceStub().getHCPbyID(0);
    	
    	RegisteredHCP registeredHCP = new RegisteredHCP(); //iRegisteredUserManager.findRegisteredUserById(0);
    	
    	registeredHCP.setAcademic_practitioner_value("academic");
    	registeredHCP.setCountry("Belgium");
    	registeredHCP.setEmail("x@y.com");
    	registeredHCP.setHCPName("jim");
    	registeredHCP.setRegisteredAt(new Date());
    	//registeredHCP.setHCPID(0);
    	
		
		//Initialization
		Agenda hCP_agenda = new Agenda();
		List<HCPInitialInterests> hCP_hcpInitialInterests = new ArrayList<HCPInitialInterests>();
		HCPInitialInterests hcpInitialInterests = new HCPInitialInterests();
		org.ucb.data.domain.Session ses = new org.ucb.data.domain.Session();
		List<org.ucb.data.domain.Session> sesArr = new ArrayList<org.ucb.data.domain.Session>();
		sesArr.add(ses);
		
		// login info
		Login login = new Login();
		login.setPassword("1234");
		login.setUsername("jim");
		registeredHCP.setRegHCP_login(login);
		login.setLogin_regHCP(registeredHCP);
		
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
		
    	iAnonymousUserServiceStub.storeAnonymousUser(user);
		
		//iRegisteredUserManager.storeRegisteredUser(registeredHCP);
    	/**/		
    	//HCP u = getiAnonymousUserServiceStub().getHCPbyID(0);
    	
    	//iRegisteredUserManager.updateRegisteredUser(registeredHCP);
    	
    	//getiAnonymousUserServiceStub().update_invitationsSent(u.getHCPID(), 5);
    	
    	
    	//Greeting g = new Greeting(u.getHCPID(), u.getSpecialization());		
		 
    	;
    	
		//iAnonymousUserServiceStub.deleteAnonymousUser(u);
		
		//return g;

    	return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    
//    @RequestMapping("/error")
//    public String error(){
//    	return "Something went wrong";
//    }

	public IAnonymousUserServiceStub getiAnonymousUserServiceStub() {
		return iAnonymousUserServiceStub;
	}

	public void setiAnonymousUserServiceStub(
			IAnonymousUserServiceStub iAnonymousUserServiceStub) {
		this.iAnonymousUserServiceStub = iAnonymousUserServiceStub;
	}
    
    
}
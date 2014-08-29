package org.ucb.service.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ucb.data.dao.IRegisteredUserManager;
import org.ucb.data.domain.Agenda;
import org.ucb.data.domain.Category;
import org.ucb.data.domain.Domain_of_Contact;
import org.ucb.data.domain.FeedbackAnswer;
import org.ucb.data.domain.HCP;
import org.ucb.data.domain.HCPInitialInterests;
import org.ucb.data.domain.LMRelatedWebinars;
import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.data.domain.LMRelatedpapers;
import org.ucb.data.domain.Login;
import org.ucb.data.domain.Preferences;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.data.domain.out.InitialInterests;
import org.ucb.data.domain.out.Specialization;
import org.ucb.data.domain.out.SubSpecialzation;
import org.ucb.data.domain.out.profession;
import org.ucb.service.IAnonymousUserServiceStub;
import org.ucb.service.model.Greeting;
import org.ucb.service.model.InitialInterestModel;
import org.ucb.service.survey.IInitialInterestService;
import org.ucb.services.identification.IRegisteredUserService;
import org.ucb.services.preferences.Preference;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private IAnonymousUserServiceStub iAnonymousUserServiceStub;
    
    @Autowired
    private IRegisteredUserService iRegisteredUserService;
    
    @Autowired
    private IInitialInterestService iMockInitialInterestService;

    @RequestMapping("/greeting")
    @Transactional
    public Greeting greeting(@RequestParam(value="accessCode", required=false, defaultValue="World") String name) throws ParseException {

    	RegisteredHCP user = new RegisteredHCP();
		
    	//HCP u = getiAnonymousUserServiceStub().getHCPbyID(0);
    	
    	//RegisteredHCPModel registeredHCP = new RegisteredHCPModel(); //iRegisteredUserManager.findRegisteredUserById(0);
    	
    	user.setAcademic_practitioner_value("academic");
    	user.setCountry("Belgium");
    	user.setEmail("x@y.com");
    	user.setHCPName("jim");
    	user.setRegisteredAt(new Date());
    	//registeredHCP.setHCPID(0);
    	
		
		//Initialization
    	
		// adding learn more data
		LMRelatedpapers lmRelatedpapers = new LMRelatedpapers();
		List<LMRelatedpapers> lmRelatedpapersList = new ArrayList<LMRelatedpapers>();
		lmRelatedpapers.setLMRelatedpapersAbstract("Epileptic encephalopathies are a"
				+ " devastating group of epilepsies with poor prognosis, of which"
				+ " the majority are of unknown etiology.");
		lmRelatedpapers.setLMRelatedpapersAuthors("Gemma L Carvill et al.");
		lmRelatedpapers.setLMRelatedpapersName("Targeted resequencing in epileptic "
				+ "encephalopathies identifies de novo mutations in CHD2 and SYNGAP1");
		lmRelatedpapers.setLMRelatedpapersLinks("http://www.nature.com/ng/journal/v45/n7/abs/ng.2646.html");		
		
		LMRelatedWebinars lmRelatedWebinars = new LMRelatedWebinars();
		
		
		LMRelatedWebsites lmRelatedWebsites =  new LMRelatedWebsites();
		List<LMRelatedWebsites> lmRelatedWebsitesList = new ArrayList<LMRelatedWebsites>();
		lmRelatedWebsites.setLMRelatedWebsitesAbstract("Nature Genetics publishes "
				+ "the very highest quality research in genetics");
		lmRelatedWebsites.setLMRelatedWebsitesLink("http://www.nature.com/ng/index.html");
		lmRelatedWebsites.setLMRelatedWebsitesName("Nature Genetics");		
		
		Agenda hCP_agenda = new Agenda();
		List<Agenda> hCP_agendaList = new ArrayList<Agenda>();
		List<HCPInitialInterests> hCP_hcpInitialInterests = new ArrayList<HCPInitialInterests>();
		HCPInitialInterests hcpInitialInterests = new HCPInitialInterests();
		org.ucb.data.domain.Session ses = new org.ucb.data.domain.Session();
		ses.setEndTime(new Date());
		ses.setPlace("Hall K11");
		ses.setStartTime(new Date());
		//
		String inputStr = "11-11-2012";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = dateFormat.parse(inputStr);
		//
		ses.setSessionDate(inputDate);
		ses.setSessionAbstract("Epileptic Encephalopathies");
		ses.setSession_agenda(hCP_agendaList);
		
		lmRelatedpapersList.add(lmRelatedpapers);
		lmRelatedWebsitesList.add(lmRelatedWebsites);
		
		ses.setSession_RelatedWebsites(lmRelatedWebsitesList);
		ses.setSession_Relatedpapers(lmRelatedpapersList);
		
		List<org.ucb.data.domain.Session> sesArr = new ArrayList<org.ucb.data.domain.Session>();
		sesArr.add(ses);
		lmRelatedpapers.setRelatedpapers_session(sesArr);
		lmRelatedWebsites.setRelatedWebsites_session(sesArr);
		
		// login info
		Login login = new Login();
		login.setPassword("1234");
		login.setUsername("jim");
		user.setRegHCP_login(login);
		login.setLogin_regHCP(user);
		
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
		
		//pref
		Preferences pref = new Preferences();
		pref.setCommunication_Channel("Emails");
		pref.setOptIn_OptOut(true);
		Category cat = new Category();
		cat.setCat_pref(pref);
		cat.setCategory("UCB Info");
		List<Category> catList = new ArrayList<Category>();
		catList.add(cat);
		pref.setPref_cat(catList);
		Domain_of_Contact domain_of_Contact = new Domain_of_Contact();
		domain_of_Contact.setDomain("eplipsy");
		domain_of_Contact.setDomain_preferences(pref);
		List<Domain_of_Contact> domain_of_ContactList = new ArrayList<Domain_of_Contact>();
		domain_of_ContactList.add(domain_of_Contact);
		pref.setPref_domain(domain_of_ContactList);
		pref.setPref_registeredHCP(user);
		
		user.setHCPID(0);
		user.setRegesteredStatus(true);
		user.setSpecialization("Eplipsy1");
		user.setSub_specialization("Eplipsy Surgury");
		user.setHCP_agenda(hCP_agenda);
		user.setAcademic_practitioner_value("Academic");
		user.setHCP_hcpInitialInterests(hCP_hcpInitialInterests);
		user.setProfession("doctor");
		user.setRegisteredHCP_preferences(pref);
		
    	//iAnonymousUserServiceStub.storeAnonymousUser(user);
		//iRegisteredUserService.storeUser(user);
		
		//iRegisteredUserService.storeRegisteredUser(registeredHCP);
    	/**/		
    	RegisteredHCP u = iRegisteredUserService.findUserById(0);
    	
    	//iRegisteredUserService.updateRegisteredUser(registeredHCP);
    	
    	//getiAnonymousUserServiceStub().update_invitationsSent(u.getHCPID(), 5);
    	
    	
    	//Greeting g = new Greeting(u.getHCPID(), u.getSpecialization());		
		 
    	
    	
		//iAnonymousUserServiceStub.deleteAnonymousUser(u);
		
		//return g;
		
		// adding mock up data for the survey part
		List<profession> profList = new ArrayList<profession>();
		profession prof = new profession();
		Specialization spec = new Specialization();
		List<SubSpecialzation> subSpecialList = new ArrayList<SubSpecialzation>();
		SubSpecialzation subSpecial = new SubSpecialzation();
		//
		List<InitialInterests> initInterestsForEpil = new ArrayList<InitialInterests>();
		
		InitialInterests init0 = new InitialInterests();
		init0.setInitialInterests("Epilepsy");
		initInterestsForEpil.add(init0);
		init0.setInital_Subspecial(subSpecial);
		
		InitialInterests init1 = new InitialInterests();
		init1.setInitialInterests("Eating Disorders");
		initInterestsForEpil.add(init1);
		init1.setInital_Subspecial(subSpecial);
		
		InitialInterests init2 = new InitialInterests();
		init2.setInitialInterests("Stop Smoking");
		initInterestsForEpil.add(init2);
		init2.setInital_Subspecial(subSpecial);

		subSpecial.setSubspec_IniInterests(initInterestsForEpil);
		subSpecial.setSubSpecialzation("Epilepsy");
		subSpecial.setSubSpec_Special(spec);
		//
		
		subSpecialList.add(subSpecial);
		spec.setSpecial_subSpec(subSpecialList);
		spec.setSpecializationType("Epilepsy");
		
		prof.setProfessionType("doctor");
		prof.setProf_special(spec);
		profList.add(prof);
		spec.setSpecial_prof(profList);
		
		//iMockInitialInterestService.storeProf(prof);
		//iMockInitialInterestService.storeSpecial(spec);
		
//		InitialInterestModel initialInterestModel = new InitialInterestModel();
//		initialInterestModel.setSpecialType("Epilepsy");
//		
//		List<SubSpecialzation> subList = iMockInitialInterestService.getSubSpecial(initialInterestModel);
	
		//String.valueOf(u.getHCP_hcpInitialInterests().get(0).getHCP_Initial_Interests_ID())
		
    	return new Greeting(counter.incrementAndGet(),
    			String.valueOf(u.getRegisteredHCP_preferences().getPref_cat().get(0).getCatID()));
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
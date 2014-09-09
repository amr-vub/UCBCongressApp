package org.ucb.service.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ucb.data.domain.HCPInitialInterests;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.data.domain.out.InitialInterests;
import org.ucb.data.domain.out.SubSpecialzation;
import org.ucb.service.model.InitialInterestModel;
import org.ucb.service.survey.IInitialInterestService;
import org.ucb.services.identification.IRegisteredUserService;

@RestController
public class SurveyController {

	@Autowired
	private IInitialInterestService iInitialInterestService;
	
	@Autowired
	private IRegisteredUserService iRegisteredUserService;
	
	@RequestMapping(value="/survey/getInitInteresets", method= RequestMethod.POST)
	public InitialInterestModel getInitInteresets(@RequestBody InitialInterestModel initM){
		
		InitialInterestModel initialInterestModel = new InitialInterestModel();
		
		List<InitialInterests> intiList =  iInitialInterestService.getInitailInterest(initM);
		
		// this part is a workaround for JSON mapping
		List<InitialInterests> intiListReturn = new ArrayList<InitialInterests>();
		
		for(InitialInterests initLs : intiList){
			InitialInterests initObj = new InitialInterests();
			initObj.setInitialInterests(initLs.getInitialInterests());
			intiListReturn.add(initObj);
		}
		
		initialInterestModel.setInitIntList(intiListReturn);
		
		return initialInterestModel;		
	}
	
	@RequestMapping(value="/survey/getSubSpecial", method= RequestMethod.POST)
	public InitialInterestModel getSubSpecial(@RequestBody InitialInterestModel initM){
		
		InitialInterestModel initialInterestModel = new InitialInterestModel();
		
		List<SubSpecialzation> subSpecialList = iInitialInterestService.getSubSpecial(initM);
		initialInterestModel.setSubSpecList(subSpecialList);
		
		return initialInterestModel;
	}
	
	@RequestMapping(value="/survey/saveNewAnonynousUser", method= RequestMethod.POST)
	public RegisteredHCP saveNewAnonynousUser(@RequestBody RegisteredHCP hcp){
		// loop through the initial interests to set it's hcp fields
		List<HCPInitialInterests> hcpInitialInterests = hcp.getHcp_hcpInitialInterests();
		for(HCPInitialInterests hi : hcpInitialInterests){
			hi.setHcpInitialInterests_hcp(hcp);
		}
		iRegisteredUserService.storeUser(hcp);
		
		for(HCPInitialInterests hi : hcpInitialInterests){
			hi.setHcpInitialInterests_hcp(null);
		}
		
		System.out.println("DONE DONE DONE");
		
		return hcp;
	}
}

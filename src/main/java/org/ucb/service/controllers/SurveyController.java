package org.ucb.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ucb.data.domain.out.InitialInterests;
import org.ucb.data.domain.out.SubSpecialzation;
import org.ucb.service.model.InitialInterestModel;
import org.ucb.service.survey.IInitialInterestService;

@RestController
public class SurveyController {

	@Autowired
	private IInitialInterestService iInitialInterestService;
	
	@RequestMapping(value="/survey/getInitInteresets", method= RequestMethod.POST)
	public InitialInterestModel getInitInteresets(@RequestBody InitialInterestModel initM){
		
		InitialInterestModel initialInterestModel = new InitialInterestModel();
		
		List<InitialInterests> intiList =  iInitialInterestService.getInitailInterest(initM);
		
		initialInterestModel.setInitIntList(intiList);
		
		return initialInterestModel;		
	}
	
	@RequestMapping(value="/survey/getSubSpecial", method= RequestMethod.POST)
	public InitialInterestModel getSubSpecial(@RequestBody InitialInterestModel initM){
		
		InitialInterestModel initialInterestModel = new InitialInterestModel();
		
		List<SubSpecialzation> subSpecialList = iInitialInterestService.getSubSpecial(initM);
		initialInterestModel.setSubSpecList(subSpecialList);
		
		return initialInterestModel;
	}
}

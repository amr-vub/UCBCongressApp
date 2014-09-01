package org.ucb.services.learnmore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ucb.service.model.Document;
import org.ucb.service.model.LearnMoreObject;

public class LearnMoreController {

	@Autowired 
	ILearnMoreService iLearnMoreService;
	
	@RequestMapping(value="/addLearnMorePaper" , method = RequestMethod.POST)
	public void addLearnMorePaper(@RequestBody LearnMoreObject lmPaper)
	{			
		iLearnMoreService.addLearnMorePaper(lmPaper);
	}
	
	@RequestMapping(value="/addLearnMoreWebinar" , method = RequestMethod.POST)
	public void addLearnMoreWebinar(@RequestBody LearnMoreObject lmWebinar)
	{			
		iLearnMoreService.addLearnMoreWebinar(lmWebinar);
	}
	
	@RequestMapping(value="/addLearnMoreWebsites" , method = RequestMethod.POST)
	public void addLearnMoreWebsite(@RequestBody LearnMoreObject lmWebsite)
	{			
		iLearnMoreService.addLearnMoreWebsite(lmWebsite);
	}
	
	@RequestMapping(value="/getLearnMorePaper" , method = RequestMethod.POST)
	public LearnMoreObject getLearnMorePaper(@RequestBody LearnMoreObject learnMoreObject)
	{			
		LearnMoreObject returnValue;
		
		returnValue = iLearnMoreService.getLearnMorePaper(learnMoreObject);
		
		return returnValue;		
	}
	
	@RequestMapping(value="/getLearnMoreWebsite" , method = RequestMethod.POST)
	public LearnMoreObject getLearnMoreWebsite(@RequestBody LearnMoreObject learnMoreObject)
	{			
		LearnMoreObject returnValue;
		
		returnValue = iLearnMoreService.getLearnMoreWebsite(learnMoreObject);
		
		return returnValue;		
	}
	
	@RequestMapping(value="/getLearnMoreWebinar" , method = RequestMethod.POST)
	public LearnMoreObject getLearnMoreWebinar(@RequestBody LearnMoreObject learnMoreObject)
	{			
		LearnMoreObject returnValue;
		
		returnValue = iLearnMoreService.getLearnMoreWebinar(learnMoreObject);
		
		return returnValue;		
	}
	
	@RequestMapping(value="/deleteLearnMorePaper" , method = RequestMethod.POST)
	public int deleteLearnMorePaper(@RequestBody LearnMoreObject lmPaper)
	{			
		int returnValue;
		
		returnValue = iLearnMoreService.deleteLearnMorePaper(lmPaper);
		
		return returnValue;		
	}
	
	@RequestMapping(value="/deleteLearnMoreWebsite" , method = RequestMethod.POST)
	public int deleteLearnMoreWebsite(@RequestBody LearnMoreObject lmWebsite)
	{			
		int returnValue;
		
		returnValue = iLearnMoreService.deleteLearnMoreWebsite(lmWebsite);
		
		return returnValue;		
	}
	
	@RequestMapping(value="/deleteLearnMoreWebinar" , method = RequestMethod.POST)
	public int deleteLearnMoreWebinar(@RequestBody LearnMoreObject lmWebinar)
	{			
		int returnValue;
		
		returnValue = iLearnMoreService.deleteLearnMoreWebinar(lmWebinar);
		
		return returnValue;		
	}	
}

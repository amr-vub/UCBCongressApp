package org.ucb.services.feedback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ucb.data.domain.FeedbackAnswer;
import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.service.model.FeedbackObject;

public class FeedbackController {

	@Autowired 
	IFeedbackService iFeedbackService;
	
	@RequestMapping(value="/getFeedbackQuestion" , method = RequestMethod.POST)
	public FeedbackObject getFeedbackQuestion(@RequestBody FeedbackObject feedback)
	{		
		FeedbackObject returnValue;
		
		returnValue = iFeedbackService.getFeedbackQuestion(feedback);
		
		// Workaround for JSON mapping
		List<FeedbackAnswer> tempValue = returnValue.getFeedbackResults();
				
		List<FeedbackAnswer> listFB_A = new ArrayList<FeedbackAnswer>();
		
		for(FeedbackAnswer fA : tempValue)
		{
			fA.setFbAnswer_fb(null);
			listFB_A.add(fA);
		}
		
		//End of workaround
		returnValue.setFeedbackResults(listFB_A);
		
		return returnValue;
	}
	
	@RequestMapping(value="/storeFeedbackQuestion" , method = RequestMethod.POST)
	public boolean storeFeedbackQuestion(@RequestBody FeedbackObject feedbackObject)
	{
		boolean returnValue;
		
		returnValue = iFeedbackService.storeFeedbackQuestion(feedbackObject);
		
		return returnValue;
	}
	
	@RequestMapping(value="/giveFeedbackResponse", method = RequestMethod.POST)
	public boolean giveFeedbackResponse(@RequestBody FeedbackObject feedbackObject)
	{
		boolean returnValue;
		
		returnValue = iFeedbackService.giveFeedbackResponse(feedbackObject);
		
		return returnValue;
	}
	
	@RequestMapping(value="/getFeedbackResults", method = RequestMethod.POST)
	public FeedbackObject getFeedbackResults(FeedbackObject feedbackObject)
	{
		FeedbackObject returnValue;
		
		returnValue = iFeedbackService.getFeedbackResults(feedbackObject);
		
		// Workaround for JSON mapping
		List<FeedbackAnswer> tempValue = returnValue.getFeedbackResults();
				
		List<FeedbackAnswer> listFB_A = new ArrayList<FeedbackAnswer>();
		
		for(FeedbackAnswer fA : tempValue)
		{
			fA.setFbAnswer_fb(null);
			listFB_A.add(fA);
		}
		
		//End of workaround
		returnValue.setFeedbackResults(listFB_A);
				
		return returnValue;
	}
}

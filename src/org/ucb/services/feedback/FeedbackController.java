package org.ucb.services.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ucb.service.model.FeedbackObject;

public class FeedbackController {

	@Autowired 
	IFeedbackService iFeedbackService;
	
	@RequestMapping(value="/getFeedbackQuestion" , method = RequestMethod.POST)
	public FeedbackObject getFeedbackQuestion(@RequestBody FeedbackObject feedback)
	{		
		FeedbackObject returnValue;
		
		returnValue = iFeedbackService.getFeedbackQuestion(feedback);
		
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
		
		return returnValue;
	}
}

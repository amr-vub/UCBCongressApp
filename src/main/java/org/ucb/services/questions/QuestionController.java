package org.ucb.services.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ucb.service.model.FeedbackObject;
import org.ucb.service.model.QuestionObject;

@RestController
public class QuestionController {

	@Autowired 
	IQuestionService iQuestionService;
	
	@RequestMapping(value="/askQuestion" , method = RequestMethod.POST)
	public boolean askQuestion(@RequestBody QuestionObject questionObject)
	{		
		boolean returnValue;
		
		returnValue = iQuestionService.askQuestion(questionObject);
		
		return returnValue;
	}
	
	@RequestMapping(value="/getAskedQuestions" , method = RequestMethod.POST)
	public QuestionObject getAskedQuestions(@RequestBody QuestionObject questionObject)
	{		
		QuestionObject returnValue;
		
		returnValue = iQuestionService.getAskedQuestions(questionObject);
		
		return returnValue;
	}
}

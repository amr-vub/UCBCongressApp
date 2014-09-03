package org.ucb.services.questions;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ucb.data.domain.Questions;
import org.ucb.data.domain.Session;
import org.ucb.service.model.QuestionObject;
import org.ucb.data.dao.ISessionManager;

@Service
public class QuestionService implements IQuestionService {
	
	@Autowired
	private ISessionManager sessionManager;
	
	@Transactional
	public boolean askQuestion(QuestionObject questionObject)
	{
		boolean returnValue = false;

		String askedQuestion = null;
		
		Date submissionDate;
		
		if(null == questionObject)
		{
			return false;
		}
		
		askedQuestion = questionObject.getAskedQuestion();
		
		int sessionID = questionObject.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);
		
		List<Questions> listQuestions;
		
		Questions newQuestion = new Questions();
		newQuestion.setQs_session(session);
		newQuestion.setQuestion(askedQuestion);
		
		
		if(null != session)
		{
			//Fetch the session's list of questions
			listQuestions = session.getSession_qs();
			
			submissionDate = Calendar.getInstance().getTime();
			newQuestion.setQsSubmissionTime(submissionDate);
			
			//Add the question to the list
			listQuestions.add(newQuestion);
			
			//Update the session's list of questions
			session.setSession_qs(listQuestions);
			
			sessionManager.updateSession(session);
			
			returnValue = true;
		}
		
		return returnValue;
	}
	
	@Transactional
	public QuestionObject getAskedQuestions(QuestionObject questionObject)
	{
		QuestionObject returnValue = questionObject;
		
		if(null == questionObject)
		{
			return null;
		}
		
		int sessionID = questionObject.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);
		
		List<Questions> listQuestions;
		
		if(null != session)
		{
			listQuestions = session.getSession_qs();
			
			returnValue.setStoredQuestions(listQuestions);			
		}		
		return returnValue;
	}
	
}

package org.ucb.services.feedback;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.hql.internal.ast.tree.ResultVariableRefNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ucb.data.domain.Feedback;
import org.ucb.data.domain.FeedbackAnswer;
import org.ucb.data.domain.Session;
import org.ucb.service.model.FeedbackObject;
import org.ucb.data.dao.ISessionManager;
import org.ucb.data.dao.IFeedbackManager;

@Service
public class FeedbackService implements IFeedbackService{
	
	@Autowired
	private ISessionManager sessionManager;
	
	@Autowired
	private IFeedbackManager feedbackManager;
	
	@Transactional
	public FeedbackObject getFeedbackQuestions(FeedbackObject feedbackObject)
	{		
		FeedbackObject returnObject = feedbackObject;
		
		if(null == feedbackObject)
		{
			return null;
		}
		
		int sessionID = feedbackObject.getSessionID();	
		
		Session session = sessionManager.getSessionById(sessionID);
		List<Feedback> listFB;
		List<String> listQuestions = new ArrayList<String>();
		String feedbackQuestion = null;
		
		if(null != session)
		{		
			//Retrieve the session's list of Feedbacks
			listFB = session.getSession_FB();
						
			for(Feedback f : listFB)
			{
				f.setfB_session(null);
				feedbackQuestion = f.getFbQuestion();
				listQuestions.add(feedbackQuestion);
			}
			returnObject.setQuestions(listQuestions);
		}		
		return returnObject;
	}
	
	@Transactional
	public boolean storeFeedbackQuestion(FeedbackObject feedbackObject)
	{
		boolean returnValue = false;
		
		if(null == feedbackObject)
		{
			return false;
		}
		
		Feedback feedback = new Feedback();
		
		String newFeedbackQuestion = feedbackObject.getFbQuestion();
		
		int sessionID = feedbackObject.getSessionID();
		
		Session session = sessionManager.getSessionById(sessionID);
		
		List<Feedback> listFB;
		
		if(null != session)
		{
			//Retrieve the session's list of Feedbacks
			listFB = session.getSession_FB();			
					
			feedback.setFbQuestion(newFeedbackQuestion);
			
			//Update the session's list of Feedbacks
			listFB.add(feedback);
			session.setSession_FB(listFB);
			
			sessionManager.updateSession(session);
			
			feedbackManager.storeFeedback(feedback);
			
			returnValue = true;
		}
		
		return returnValue;
	}
	
	@Transactional
	public boolean giveFeedbackResponse(FeedbackObject feedbackObject)
	{
		boolean returnValue = false;
		
		if(null == feedbackObject)
		{
			return false;
		}
		
		int sessionID = feedbackObject.getSessionID();
		int feedbackIndex = feedbackObject.getFeedbackIndex();
		
		Feedback feedback = new Feedback();
		FeedbackAnswer feedbackAnswer = feedbackObject.getFeedbackAnswer();
		
		Session session = sessionManager.getSessionById(sessionID);
		
		List<Feedback> listFB;
		List<FeedbackAnswer> listFB_A;
		
		if(null != session)
		{
			listFB = session.getSession_FB();
			
			//Check whether the index is a valid number
			if((feedbackIndex >= 0) && (feedbackIndex <= listFB.size()))
			{
				//Retrieve the session's list of Feedbacks
				feedback = listFB.get(feedbackIndex);
				
				listFB_A = feedback.getFb_fbAnswer();
				
				listFB_A.add(feedbackAnswer);
				
				//Update the Feedback's list of FeedbackAnswers
				feedback.setFb_fbAnswer(listFB_A);
				
				//Update the Session's list of Feedbacks
				listFB.set(feedbackIndex, feedback);
				
				//Update the Session
				session.setSession_FB(listFB);
				
				sessionManager.updateSession(session);
				
				//For the lazy fetch
				feedbackManager.updateFeedback(feedback);
				
				returnValue = true;
			}
		}		
		return returnValue;
	}
	
	@Transactional
	public FeedbackObject getFeedbackResults(FeedbackObject feedbackObject)
	{
		FeedbackObject returnValue = feedbackObject;
		
		if(null == feedbackObject)
		{
			return null;
		}
		
		int sessionID = feedbackObject.getSessionID();
		int feedbackIndex = feedbackObject.getFeedbackIndex();
		
		Feedback feedback = new Feedback();
		
		Session session = sessionManager.getSessionById(sessionID);
		
		List<Feedback> listFB;
		List<FeedbackAnswer> listFB_A;
		
		if(null != session)
		{
			//Retrieve the session's list of Feedbacks
			listFB = session.getSession_FB();
			
			//Check whether the index is a valid number
			if((feedbackIndex >= 0) && (feedbackIndex <= listFB.size()))
			{
				feedback = listFB.get(feedbackIndex);
				
				listFB_A = feedback.getFb_fbAnswer();
				
				returnValue.setFeedbackResults(listFB_A);
			}
		}		
		return returnValue;
	}
	
	
}

package org.ucb.services.feedback;

import org.springframework.stereotype.Service;
import org.ucb.data.domain.Feedback;
import org.ucb.data.domain.FeedbackAnswer;
import org.ucb.data.domain.Session;

@Service
public class FeedbackSystem {
	private Feedback feedback;
	private FeedbackAnswer feedbackAnswer;
	
	public void setfbSession(Session fbSession)
	{
		feedback.setfB_session(fbSession);
	}
	
	public Session getfbSession()
	{
		return feedback.getfB_session();
	}
	
	public void setfbQuestion(String fbQuestion)
	{
		feedback.setFbQuestion(fbQuestion);
	}
	
	public String getfbQuestion()
	{
		return feedback.getFbQuestion();
	}
	
	public void setFreeText(boolean freeText)
	{
		feedback.setFreeText(freeText);
	}
	
	public boolean isFreeText()
	{
		return feedback.isFreeText();
	}
	
	public void setFinalFBResult(int finalFBResult)
	{
		feedback.setFinalFBResult(finalFBResult);
	}
	
	public int getFinalFBResult()
	{
		return feedback.getFinalFBResult();
	}
	
	public void setFBAnswer(int fbAnswer)
	{
		feedbackAnswer.setFbAnswer(fbAnswer);
	}
	
	public int getFBAnswer()
	{
		return feedbackAnswer.getFbAnswer();
	}
	
	public void setFBTextAnswer(String fbTextAnswer)
	{
		feedbackAnswer.setFbTextAnswer(fbTextAnswer);
	}
	
	public String getFBTextAnswer()
	{
		return feedbackAnswer.getFbTextAnswer();
	}
}

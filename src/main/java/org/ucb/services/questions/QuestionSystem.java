package org.ucb.services.questions;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.ucb.data.domain.Questions;
import org.ucb.data.domain.Session;

@Service
public class QuestionSystem {
	
	private Questions questions;
	
	public void setQuestion(String question)
	{
		questions.setQuestion(question);
	}
	
	public String question()
	{
		return questions.getQuestion();
	}
	
	public void setQuestionSubmissionTime(Date submissionTime)
	{
		questions.setQsSubmissionTime(submissionTime);
	}
	
	public Date getSubmissionTime()
	{
		return questions.getQsSubmissionTime();
	}
	
	public void setQuestionSession(Session session)
	{
		questions.setQs_session(session);
	}
	
	public Session getQuestionSession()
	{
		return questions.getQs_session();
	}
}

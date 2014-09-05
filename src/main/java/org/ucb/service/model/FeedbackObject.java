package org.ucb.service.model;

import java.util.List;

import org.ucb.data.domain.FeedbackAnswer;
import org.ucb.data.domain.Feedback;

public class FeedbackObject {
	
	private int sessionID;
	
	// The Feedback's index within a session's list of Feedbacks
	private int feedbackIndex;
	
	//private Feedback feedbackOutput;
	private String fbQuestion;
	
	private FeedbackAnswer feedbackAnswer;
	
	private List<FeedbackAnswer> feedbackResults;
	

	public List<FeedbackAnswer> getFeedbackResults() {
		return feedbackResults;
	}

	public void setFeedbackResults(List<FeedbackAnswer> feedbackResults) {
		this.feedbackResults = feedbackResults;
	}

	public String getFbQuestion() {
		return fbQuestion;
	}

	public void setFbQuestion(String fbQuestion) {
		this.fbQuestion = fbQuestion;
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public FeedbackAnswer getFeedbackAnswer() {
		return feedbackAnswer;
	}

	public void setFeedbackAnswer(FeedbackAnswer feedbackAnswer) {
		this.feedbackAnswer = feedbackAnswer;
	}

	public int getFeedbackIndex() {
		return feedbackIndex;
	}

	public void setFeedbackIndex(int feedbackIndex) {
		this.feedbackIndex = feedbackIndex;
	}
	
	
}

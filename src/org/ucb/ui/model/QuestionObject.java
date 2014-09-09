package org.ucb.ui.model;

import java.util.List;

import org.ucb.data.domain.Questions;

public class QuestionObject {
	
	private int sessionID; 

	private String askedQuestion;
	
	private List<Questions> storedQuestions;

	public String getAskedQuestion() {
		return askedQuestion;
	}

	public void setAskedQuestion(String askedQuestion) {
		this.askedQuestion = askedQuestion;
	}

	public List<Questions> getStoredQuestions() {
		return storedQuestions;
	}

	public void setStoredQuestions(List<Questions> storedQuestions) {
		this.storedQuestions = storedQuestions;
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}
	
	
}

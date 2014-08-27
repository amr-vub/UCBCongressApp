package org.ucb.data.domain;



/** 
 * This class reflects a session's Feedback Answers
 */

public class FeedbackAnswer {

	private int fbAnswerID;
	
	// values from 1 --> 5
	private int fbAnswer;
	
	// if any
	private String fbTextAnswer;
	
	/*
	@OneToOne
	@JoinColumn(nullable=false)
	private HCP FBAnswer_HCP;
	*/


	public int getFbAnswerID() {
		return fbAnswerID;
	}

	public void setFbAnswerID(int fbAnswerID) {
		this.fbAnswerID = fbAnswerID;
	}

	public int getFbAnswer() {
		return fbAnswer;
	}

	public void setFbAnswer(int fbAnswer) {
		this.fbAnswer = fbAnswer;
	}

	public String getFbTextAnswer() {
		return fbTextAnswer;
	}

	public void setFbTextAnswer(String fbTextAnswer) {
		this.fbTextAnswer = fbTextAnswer;
	}
	
	
}

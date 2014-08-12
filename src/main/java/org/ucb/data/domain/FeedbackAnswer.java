package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/** 
 * This class reflects a session's Feedback Answers
 */

@Entity
public class FeedbackAnswer {

	@Id @GeneratedValue
	private int fbAnswerID;
	
	// values from 1 --> 5
	@Column
	private int fbAnswer;
	
	// if any
	@Column
	private String fbTextAnswer;
	
	@OneToOne
	@JoinColumn(nullable=false)
	private HCP FBAnswer_HCP;

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

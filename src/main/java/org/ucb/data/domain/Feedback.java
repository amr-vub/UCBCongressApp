package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/** 
 * This class reflects a session's Feedback Info
 */

@Entity
public class Feedback {

	@Id @GeneratedValue
	private int fbD;
	
	@Column
	private String fbQuestion;
	
	// Some questions are not choice based, they provide 
	// free text area for HCP.
	@Column
	private boolean isFreeText;
		
	@Column
	private int FinalFBResult;
	
	// each feedback is related to one session
	@ManyToOne
	@JoinColumn(nullable=false)
	private Session fB_session;

	public int getFbD() {
		return fbD;
	}

	public void setFbD(int fbD) {
		this.fbD = fbD;
	}

	public String getFbQuestion() {
		return fbQuestion;
	}

	public void setFbQuestion(String fbQuestion) {
		this.fbQuestion = fbQuestion;
	}

	public boolean isFreeText() {
		return isFreeText;
	}

	public void setFreeText(boolean isFreeText) {
		this.isFreeText = isFreeText;
	}

	public int getFinalFBResult() {
		return FinalFBResult;
	}

	public void setFinalFBResult(int finalFBResult) {
		FinalFBResult = finalFBResult;
	}
	
	
}

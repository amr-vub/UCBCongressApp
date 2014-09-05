package org.ucb.data.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="fbAnswer_fb")
	private List<FeedbackAnswer> fb_fbAnswer;
	
	// each feedback is related to one session
	@ManyToOne
	@JoinColumn(nullable=false)
	private Session fB_session;

	
	
	public List<FeedbackAnswer> getFb_fbAnswer() {
		return fb_fbAnswer;
	}

	public void setFb_fbAnswer(List<FeedbackAnswer> fb_fbAnswer) {
		this.fb_fbAnswer = fb_fbAnswer;
	}

	public Session getfB_session() {
		return fB_session;
	}

	public void setfB_session(Session fB_session) {
		this.fB_session = fB_session;
	}

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

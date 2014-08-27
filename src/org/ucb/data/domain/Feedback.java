package org.ucb.data.domain;


/** 
 * This class reflects a session's Feedback Info
 */

public class Feedback {


	private int fbD;
	
	private String fbQuestion;
	
	// Some questions are not choice based, they provide 
	// free text area for HCP.
	private boolean isFreeText;
		
	private int FinalFBResult;
	
	// each feedback is related to one session
	private Session fB_session;

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

package org.ucb.data.domain;


/** 
 * This class reflects a session's vote choices
 */

public class VoteChoices {

	private int choiceID;
	
	private String choices;
	
	private int voteValue;
	/*
	@OneToOne
	@JoinColumn(nullable=false)
	private HCP VChoice_HCP;
	*/


	public int getVoteValue() {
		return voteValue;
	}

	public void setVoteValue(int voteValue) {
		this.voteValue = voteValue;
	}

	public int getChoiceID() {
		return choiceID;
	}

	public void setChoiceID(int choiceID) {
		this.choiceID = choiceID;
	}

	public String getChoices() {
		return choices;
	}

	public void setChoices(String choices) {
		this.choices = choices;
	}
	
	
}

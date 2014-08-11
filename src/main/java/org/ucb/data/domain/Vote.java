package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** 
 * This class reflects a session's vote info
 */


@Entity
public class Vote {

	@Id @GeneratedValue
	private int voteID;
	
	@Column
	private String voteQuestion;
	
	@Column
	private int chosenVoteChoice;

	public int getVoteID() {
		return voteID;
	}

	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}

	public String getVoteQuestion() {
		return voteQuestion;
	}

	public void setVoteQuestion(String voteQuestion) {
		this.voteQuestion = voteQuestion;
	}

	public int getVoteResult() {
		return chosenVoteChoice;
	}

	public void setVoteResult(int chosenVoteChoice) {
		this.chosenVoteChoice = chosenVoteChoice;
	}
	
	
}

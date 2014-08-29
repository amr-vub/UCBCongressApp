package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/** 
 * This class reflects a session's vote choices
 */

@Entity
public class VoteChoices {

	@Id @GeneratedValue
	private int choiceID;
	
	@Column
	private String choices;

	@ManyToOne 
	@JoinColumn(nullable=false)
	private Vote choiceVote;
	
	/*
	@OneToOne
	@JoinColumn(nullable=false)
	private HCP VChoice_HCP;
	*/

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

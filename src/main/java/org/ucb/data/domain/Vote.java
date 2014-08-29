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
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Session vote_session;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="choiceVote")
	private List<VoteChoices> voteChoices;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="Vote_value_Vote")
	private List<Vote_value> vote_vValue;

	public int getChosenVoteChoice() {
		return chosenVoteChoice;
	}

	public void setChosenVoteChoice(int chosenVoteChoice) {
		this.chosenVoteChoice = chosenVoteChoice;
	}

	public Session getVote_session() {
		return vote_session;
	}

	public void setVote_session(Session vote_session) {
		this.vote_session = vote_session;
	}

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

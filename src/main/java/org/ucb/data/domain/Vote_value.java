package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote_value {

	@Id @GeneratedValue
	private int vote_value_ID;
	
	@Column
	private int voteValue;
	
	@ManyToOne 
	@JoinColumn(nullable=false)
	private Vote Vote_value_Vote;

	public int getVote_value_ID() {
		return vote_value_ID;
	}

	public void setVote_value_ID(int vote_value_ID) {
		this.vote_value_ID = vote_value_ID;
	}

	public int getVoteValue() {
		return voteValue;
	}

	public void setVoteValue(int voteValue) {
		this.voteValue = voteValue;
	}

	public Vote getVote_value_Vote() {
		return Vote_value_Vote;
	}

	public void setVote_value_Vote(Vote vote_value_Vote) {
		Vote_value_Vote = vote_value_Vote;
	}
	
}

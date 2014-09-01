package org.ucb.service.model;

import org.ucb.data.domain.Session;
import org.ucb.data.domain.VoteChoices;
import org.ucb.data.domain.Vote_value;

public class VotingSession {

	private Session votingSession;
	private int voteID;
	private Vote_value voteValue;
	private int votingAverage;
	
	
	public VotingSession(){
		
	}
	
	public Vote_value getVoteValue() {
		return voteValue;
	}
	public void setVoteValue(Vote_value voteValue) {
		this.voteValue = voteValue;
	}
	public Session getVotingSession() {
		return votingSession;
	}
	public void setVotingSession(Session votingSession) {
		this.votingSession = votingSession;
	}
	public int getVoteID() {
		return voteID;
	}
	public void setVoteID(int voteID) {
		this.voteID = voteID;
	}
	
	public int getVotingAverage() {
		return votingAverage;
	}
	public void setVotingAverage(int votingAverage) {
		this.votingAverage = votingAverage;
	}

	
}

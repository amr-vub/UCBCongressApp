package org.ucb.service.model;

import org.ucb.data.domain.Session;
import org.ucb.data.domain.VoteChoices;

public class VotingSession {

	private Session votingSession;
	private int voteID;
	private VoteChoices voteChoice;
	private int votingAverage;
	
	
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
	public VoteChoices getVoteChoice() {
		return voteChoice;
	}
	public void setVoteChoice(VoteChoices voteChoice) {
		this.voteChoice = voteChoice;
	}
	
}

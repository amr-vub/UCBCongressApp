package org.ucb.data.domain;


/** 
 * This class reflects a session's vote info
 */


public class Vote {

	private int voteID;
	
	private String voteQuestion;
	
	private int chosenVoteChoice;
	
	private Session vote_session;

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

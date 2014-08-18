package org.ucb.services.voting;

public class Election {
	
	
	private boolean done;
	
	private Voter voterID;	
	private VotingCandidate votingCandidateID;	
	private VotingContext votingContextID;
	
	/**
	 * Initialization constructor
	 * 
	 * */
	public Election()
	{
		done               = false;
		voterID            = null;
		votingCandidateID  = null;
		votingContextID    = null;
	}
	
	/**
	 * Copy constructor
	 * 
	 * @param done - a flag determining whether the user has voted or not.
	 * @param voterID - the user who votes.
	 * @param votingCandidateID - the participant at the voting process.
	 * @param votingContextID
	 */
	public Election(boolean done, Voter voterID,
			VotingCandidate votingCandidateID, VotingContext votingContextID) {
		
		this.done              = done;
		this.voterID           = voterID;
		this.votingCandidateID = votingCandidateID;
		this.votingContextID   = votingContextID;
		
		//TODO: Storing in the DB can happen at this point.
	}
	
	public void vote(Voter voterID, VotingContext votingContextID, VotingCandidate votingCandidate){
		
		this.voterID           = voterID;
		this.votingContextID   = votingContextID;
		this.votingCandidateID = votingCandidate;
		
		this.voterID.vote();
		this.votingCandidateID.vote();
		
		done                   = true;
		
		//TODO: Store all these fields in the DB
	}
	
	

}

package org.ucb.services.voting;

public class VotingCandidate {

	String choiceName;

	/* whether it is the case */
	private Object reference;
	private Integer voteCount;
	
	/**
	 * Initialization constructor
	 * */
	public VotingCandidate() {
		
		reference  = null;
		choiceName = null;
		voteCount  = 0;
	}
	
	/**
	 * Copy constructor
	 * */
	public VotingCandidate(String choiceName, Object reference,
			Integer voteCount) {
		super();
		this.choiceName = choiceName;
		this.reference = reference;
		this.voteCount = voteCount;
		
		//TODO: Store the fields in the DB
	}

	public String getChoiceName() {
		return choiceName;
	}

	public void setChoiceName(String choiceName) {
		this.choiceName = choiceName;
		
		//TODO: Update the field in the DB
	}

	public Object getReference() {
		return reference;
	}

	public void setReference(Object reference) {
		this.reference = reference;
		
		//TODO: Update the field in the DB
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void vote() {
		voteCount++;
	}
}

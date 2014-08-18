package org.ucb.services.voting;

import java.util.ArrayList;

public class VotingContext {
	
	private String question;
	private ArrayList<VotingCandidate> choices;
	private VotingCandidate chosen;
	
	public VotingContext()
	{
		question = null;
		choices  = null;
		chosen   = null; 
	}
	
	public VotingContext(String question, ArrayList<VotingCandidate> choices,
			VotingCandidate chosen) {
		this.question  = question;
		this.choices   = choices;
		this.chosen    = chosen;
	}
	
	public void setChoices(ArrayList<VotingCandidate> choices) {
		this.choices = choices;
	}
	
	// No setter yet. It will be added later if needed.

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
		
		//TODO: Store this field in the DB
	}
	
	
}

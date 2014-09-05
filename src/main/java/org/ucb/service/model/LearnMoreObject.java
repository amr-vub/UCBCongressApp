package org.ucb.service.model;

import java.util.ArrayList;
import java.util.List;

import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.data.domain.LearmMore;
import org.ucb.data.domain.Session;

public class LearnMoreObject {
	
	private LearmMore learnMore;
	//private Session session;
	private int sessionID;
	private int learnMoreID;
	private ArrayList<LMRelatedWebsites> learnMoreOutput;	
	
	public LearnMoreObject(){
		
	}
	
	public LearnMoreObject(LearmMore learnMore, int sessionID, int learnMoreID,
			ArrayList<LMRelatedWebsites> learnMoreOutput) {
		super();
		this.learnMore = learnMore;
		this.sessionID = sessionID;
		this.learnMoreID = learnMoreID;
		this.learnMoreOutput = learnMoreOutput;
	}

	public LearmMore getLearnMore() {
		return learnMore;
	}
	public void setLearnMore(LearmMore learnMore) {
		this.learnMore = learnMore;
	}
	public int getSessionID() {
		return sessionID;
	}
	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}
	public int getLearnMoreID() {
		return learnMoreID;
	}
	public void setLearnMoreID(int learnMoreID) {
		this.learnMoreID = learnMoreID;
	}

	public ArrayList<LMRelatedWebsites> getLearnMoreOutput() {
		return learnMoreOutput;
	}

	public void setLearnMoreOutput(ArrayList<LMRelatedWebsites> learnMoreOutput) {
		this.learnMoreOutput = learnMoreOutput;
	}
	

}

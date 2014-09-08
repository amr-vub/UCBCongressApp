package org.ucb.ui.model;

import java.util.ArrayList;
import java.util.List;

import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.data.domain.LearmMore;

public class LearnMoreObject {
	
	private LearmMore learnMore;
	//private Session session;
	private int sessionID;
	private int learnMoreID;
	private ArrayList<LMRelatedWebsites> learnMoreOutput;	
	
	public LearnMoreObject(){
		
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
	public List<LMRelatedWebsites> getLearnMoreOutput() {
		return learnMoreOutput;
	}
	public void setLearnMoreOutput(ArrayList<LMRelatedWebsites> learnMoreOutput) {
		this.learnMoreOutput = learnMoreOutput;
	}
	
}

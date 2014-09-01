package org.ucb.service.model;

import java.util.List;

import org.ucb.data.domain.LearmMore;
import org.ucb.data.domain.Session;

public class LearnMoreObject {
	
	private LearmMore learnMore;
	//private Session session;
	private int sessionID;
	private int learnMoreID;
	private List<LearmMore> learnMoreOutput;	
	
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
	
}

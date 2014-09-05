package org.ucb.service.model;

import java.util.List;


import org.ucb.data.domain.LearmMore;
import org.ucb.data.domain.Session;

import org.ucb.data.domain.LMRelatedpapers;
import org.ucb.data.domain.LMRelatedWebinars;
import org.ucb.data.domain.LMRelatedWebsites;

public class LearnMoreObject {
	
	private LearmMore learnMore;
	//private Session session;
	private int sessionID;
	private int learnMoreID;
	private List<LearmMore> learnMoreOutput;	
	
	private List<LMRelatedpapers> lmPapersOutput;
	private List<LMRelatedWebinars> lmWebinarsOutput;
	private List<LMRelatedWebsites> lmWebsitesOutput;
	
	
	public List<LMRelatedpapers> getLmPapersOutput() {
		return lmPapersOutput;
	}
	public void setLmPapersOutput(List<LMRelatedpapers> lmPapersOutput) {
		this.lmPapersOutput = lmPapersOutput;
	}
	public List<LMRelatedWebinars> getLmWebinarsOutput() {
		return lmWebinarsOutput;
	}
	public void setLmWebinarsOutput(List<LMRelatedWebinars> lmWebinarsOutput) {
		this.lmWebinarsOutput = lmWebinarsOutput;
	}
	public List<LMRelatedWebsites> getLmWebsitesOutput() {
		return lmWebsitesOutput;
	}
	public void setLmWebsitesOutput(List<LMRelatedWebsites> lmWebsitesOutput) {
		this.lmWebsitesOutput = lmWebsitesOutput;
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
	
}

package org.ucb.data.domain;

import java.util.Date;
import java.util.List;

/** 
 * 
 * This class contains the basic information about sessions in a congress
 * 
 */


public class Session {

	private int sessionID;
	
	private Date sessionDate;
	
	private Date startTime;
	
	private Date endTime;
	
	private String place;
	
	private String SessionAbstract;
	
	/*
	// each session can be attended by m to n users
	@ManyToMany(mappedBy="HCPSession")
	private List<HCP> sessionHCP;
	*/
	
	//each session can be given by one or many speakers
	private List<RegisteredHCP> session_RegisteredHCP;
	
	// each session can be mapped to one or many agenda
	private List<Agenda> session_agenda;
	
	// each session can have zero or more questions
	private List<Questions> session_qs;
	
	// each session can have one or many related websit
	private List<LMRelatedWebsites> session_RelatedWebsites;
	
	// each session can have one or more related papers
	private List<LMRelatedpapers> session_Relatedpapers;
	
	// each session can have zero or more related webinars
	private List<LMRelatedWebinars> session_RelatedWebinars;
	
	// each session can have one or more feedback question
	private List<Feedback> session_FB;
	
	// each session can have zero or more votes
	private List<Vote> session_vote;	
	
	// each session have one or more docs
	private List<Docs> session_docs;

	public List<RegisteredHCP> getSession_RegisteredHCP() {
		return session_RegisteredHCP;
	}

	public void setSession_RegisteredHCP(List<RegisteredHCP> session_RegisteredHCP) {
		this.session_RegisteredHCP = session_RegisteredHCP;
	}

	public List<Agenda> getSession_agenda() {
		return session_agenda;
	}

	public void setSession_agenda(List<Agenda> session_agenda) {
		this.session_agenda = session_agenda;
	}

	public List<Questions> getSession_qs() {
		return session_qs;
	}

	public void setSession_qs(List<Questions> session_qs) {
		this.session_qs = session_qs;
	}

	public List<LMRelatedWebsites> getSession_RelatedWebsites() {
		return session_RelatedWebsites;
	}

	public void setSession_RelatedWebsites(
			List<LMRelatedWebsites> session_RelatedWebsites) {
		this.session_RelatedWebsites = session_RelatedWebsites;
	}

	public List<LMRelatedpapers> getSession_Relatedpapers() {
		return session_Relatedpapers;
	}

	public void setSession_Relatedpapers(List<LMRelatedpapers> session_Relatedpapers) {
		this.session_Relatedpapers = session_Relatedpapers;
	}

	public List<LMRelatedWebinars> getSession_RelatedWebinars() {
		return session_RelatedWebinars;
	}

	public void setSession_RelatedWebinars(
			List<LMRelatedWebinars> session_RelatedWebinars) {
		this.session_RelatedWebinars = session_RelatedWebinars;
	}

	public List<Feedback> getSession_FB() {
		return session_FB;
	}

	public void setSession_FB(List<Feedback> session_FB) {
		this.session_FB = session_FB;
	}

	public List<Vote> getSession_vote() {
		return session_vote;
	}

	public void setSession_vote(List<Vote> session_vote) {
		this.session_vote = session_vote;
	}

	public List<Docs> getSession_docs() {
		return session_docs;
	}

	public void setSession_docs(List<Docs> session_docs) {
		this.session_docs = session_docs;
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public Date getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSessionAbstract() {
		return SessionAbstract;
	}

	public void setSessionAbstract(String sessionAbstract) {
		SessionAbstract = sessionAbstract;
	}
	
	
}

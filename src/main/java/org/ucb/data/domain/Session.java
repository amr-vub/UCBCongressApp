package org.ucb.data.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** 
 * 
 * This class contains the basic information about sessions in a congress
 * 
 */


@Entity(name="Congress_session")
public class Session {

	@Id @GeneratedValue
	private int sessionID;
	
	@Column @Temporal(TemporalType.DATE)
	private Date sessionDate;
	
	@Column @Temporal(TemporalType.TIME)
	private Date startTime;
	
	@Column @Temporal(TemporalType.TIME)
	private Date endTime;
	
	@Column
	private String place;
	
	@Column
	private String SessionAbstract;
	
	// each session can be attended by m to n users
	@ManyToMany(mappedBy="HCPSession")
	private List<HCP> sessionHCP;
	
	//each session can be given by one or many speakers
	@ManyToMany(mappedBy = "registeredHCP_Session")
	private List<RegisteredHCP> session_RegisteredHCP;
	
	// each session can be mapped to one or many agenda
	@ManyToMany(mappedBy="agenda_Session")
	private List<Agenda> session_agenda;
	
	// each session can have zero or more questions
	@OneToMany(cascade=CascadeType.ALL, mappedBy="")
	private List<Questions> session_qs;
	
	// each session can have one or many related websit
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="SESSION_RelatedWebsites")
	private List<LMRelatedWebsites> session_RelatedWebsites;
	
	// each session can have one or more related papers
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="SESSION_Relatedpapers")
	private List<LMRelatedpapers> session_Relatedpapers;
	
	// each session can have zero or more related webinars
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="SESSION_RelatedWebinars")
	private List<LMRelatedWebinars> session_RelatedWebinars;
	
	// each session can have one or more feedback question
	@OneToMany(cascade=CascadeType.ALL, mappedBy="fB_session")
	private List<Feedback> session_FB;
	
	// each session can have zero or more votes
	@OneToMany(cascade=CascadeType.ALL, mappedBy="vote_session")
	private List<Vote> session_vote;	
	
	// each session have one or more docs
	@OneToMany(cascade=CascadeType.ALL,mappedBy="docs_session")
	private List<Docs> session_docs;

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

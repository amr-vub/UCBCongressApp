package org.ucb.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

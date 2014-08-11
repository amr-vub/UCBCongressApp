package org.ucb.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** 
 * This class contains session that UCB offers to HCP through their MSLs
 */

@Entity
public class MSLSession {

	@Id @GeneratedValue
	private int MSLSessionID;
	
	@Column
	private String MSLSessionName;
	
	@Column @Temporal(TemporalType.TIMESTAMP)
	private Date MSLSessionDate;
	
	// Therapeutic area for this session
	@Column
	private String MSLSessionTopic;

	public int getMSLSessionID() {
		return MSLSessionID;
	}

	public void setMSLSessionID(int mSLSessionID) {
		MSLSessionID = mSLSessionID;
	}

	public String getMSLSessionName() {
		return MSLSessionName;
	}

	public void setMSLSessionName(String mSLSessionName) {
		MSLSessionName = mSLSessionName;
	}

	public Date getMSLSessionDate() {
		return MSLSessionDate;
	}

	public void setMSLSessionDate(Date mSLSessionDate) {
		MSLSessionDate = mSLSessionDate;
	}

	public String getMSLSessionTopic() {
		return MSLSessionTopic;
	}

	public void setMSLSessionTopic(String mSLSessionTopic) {
		MSLSessionTopic = mSLSessionTopic;
	}
	
	
}

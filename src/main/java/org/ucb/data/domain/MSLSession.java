package org.ucb.data.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	// each MSL session can be booked by one or more Registered HCP
	@ManyToMany(mappedBy = "registeredHCP_MSLSession")
	private List<RegisteredHCP> MSLSession_registeredHCP;
	
	// each MSL session is given by one o many MSL
	@ManyToMany(mappedBy="MSL_MSLSesssion")
	private List<MSL> MSLSession_MSL;

	public List<RegisteredHCP> getMSLSession_registeredHCP() {
		return MSLSession_registeredHCP;
	}

	public void setMSLSession_registeredHCP(
			List<RegisteredHCP> mSLSession_registeredHCP) {
		MSLSession_registeredHCP = mSLSession_registeredHCP;
	}

	public List<MSL> getMSLSession_MSL() {
		return MSLSession_MSL;
	}

	public void setMSLSession_MSL(List<MSL> mSLSession_MSL) {
		MSLSession_MSL = mSLSession_MSL;
	}

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

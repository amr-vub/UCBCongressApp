package org.ucb.data.domain;

import java.util.Date;
import java.util.List;


/** 
 * This class contains session that UCB offers to HCP through their MSLs
 */

public class MSLSession {

	private int MSLSessionID;
	
	private String MSLSessionName;
	
	private Date MSLSessionDate;
	
	// Therapeutic area for this session
	private String MSLSessionTopic;
	
	// each MSL session can be booked by one or more Registered HCP
	private List<RegisteredHCP> MSLSession_registeredHCP;
	
	// each MSL session is given by one o many MSL
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

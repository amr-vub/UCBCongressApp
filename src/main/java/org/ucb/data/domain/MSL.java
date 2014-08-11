package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/** 
 * This class contains MSL basic information
 */

@Entity
public class MSL {
	
	@Id
	private int MSLID;
	
	@Column
	private String MSLEmail;
	
	@Column
	private String MSLPhone;
	
	// MSL might be categorized by which disease they are specialized in
	@Column
	private String MSLtherapeuticArea;

	public int getMSLID() {
		return MSLID;
	}

	public void setMSLID(int mSLID) {
		MSLID = mSLID;
	}

	public String getMSLEmail() {
		return MSLEmail;
	}

	public void setMSLEmail(String mSLEmail) {
		MSLEmail = mSLEmail;
	}

	public String getMSLPhone() {
		return MSLPhone;
	}

	public void setMSLPhone(String mSLPhone) {
		MSLPhone = mSLPhone;
	}

	public String getMSLtherapeuticArea() {
		return MSLtherapeuticArea;
	}

	public void setMSLtherapeuticArea(String mSLtherapeuticArea) {
		MSLtherapeuticArea = mSLtherapeuticArea;
	}
	
	
	
}

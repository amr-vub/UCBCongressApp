package org.ucb.data.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="MSL_MSLSesssion")
	private List<MSLSession> MSL_MSLSesssion;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="MSL_LMRelatedWebinar")
	private List<LMRelatedWebinars> MSL_LMRelatedWebinars;

	public List<MSLSession> getMSL_MSLSesssion() {
		return MSL_MSLSesssion;
	}

	public void setMSL_MSLSesssion(List<MSLSession> mSL_MSLSesssion) {
		MSL_MSLSesssion = mSL_MSLSesssion;
	}

	public List<LMRelatedWebinars> getMSL_LMRelatedWebinars() {
		return MSL_LMRelatedWebinars;
	}

	public void setMSL_LMRelatedWebinars(
			List<LMRelatedWebinars> mSL_LMRelatedWebinars) {
		MSL_LMRelatedWebinars = mSL_LMRelatedWebinars;
	}

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

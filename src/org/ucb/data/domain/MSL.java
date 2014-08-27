package org.ucb.data.domain;

import java.util.List;

/** 
 * This class contains MSL basic information
 */

public class MSL {
	
	private int MSLID;
	
	private String MSLEmail;
	
	private String MSLPhone;
	
	// MSL might be categorized by which disease they are specialized in
	private String MSLtherapeuticArea;
	
	private List<MSLSession> MSL_MSLSesssion;
	
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

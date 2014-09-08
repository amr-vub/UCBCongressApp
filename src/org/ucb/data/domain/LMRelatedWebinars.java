package org.ucb.data.domain;

import java.util.Date;
import java.util.List;

/** 
 * Each session has a list of related webinars that the App can
 * suggest to HCPs
 * This class contains those webinars's info 
 */

public class LMRelatedWebinars extends LearmMore {

	private int LMRelatedWebinarsID;
	
	private Date LMRelatedWebinarsDate;
	
	private String LMRelatedWebinarsName;
	
	private String LMRelatedWebinarsTopic;
	
	private String LMRelatedWebinarsPrerequisits;
	
	private String LMRelatedWebinarsDuration;
	
	private List<MSL> LMRelatedWebinars_MSL;
	
	private List<Session> LMRelatedWebinars_Session;

	public List<MSL> getLMRelatedWebinars_MSL() {
		return LMRelatedWebinars_MSL;
	}

	public void setLMRelatedWebinars_MSL(List<MSL> lMRelatedWebinars_MSL) {
		LMRelatedWebinars_MSL = lMRelatedWebinars_MSL;
	}

	public List<Session> getLMRelatedWebinars_Session() {
		return LMRelatedWebinars_Session;
	}

	public void setLMRelatedWebinars_Session(List<Session> lMRelatedWebinars_Session) {
		LMRelatedWebinars_Session = lMRelatedWebinars_Session;
	}

	public int getLMRelatedWebinarsID() {
		return LMRelatedWebinarsID;
	}

	public void setLMRelatedWebinarsID(int lMRelatedWebinarsID) {
		LMRelatedWebinarsID = lMRelatedWebinarsID;
	}

	public Date getLMRelatedWebinarsDate() {
		return LMRelatedWebinarsDate;
	}

	public void setLMRelatedWebinarsDate(Date lMRelatedWebinarsDate) {
		LMRelatedWebinarsDate = lMRelatedWebinarsDate;
	}

	public String getLMRelatedWebinarsName() {
		return LMRelatedWebinarsName;
	}

	public void setLMRelatedWebinarsName(String lMRelatedWebinarsName) {
		LMRelatedWebinarsName = lMRelatedWebinarsName;
	}

	public String getLMRelatedWebinarsTopic() {
		return LMRelatedWebinarsTopic;
	}

	public void setLMRelatedWebinarsTopic(String lMRelatedWebinarsTopic) {
		LMRelatedWebinarsTopic = lMRelatedWebinarsTopic;
	}

	public String getLMRelatedWebinarsPrerequisits() {
		return LMRelatedWebinarsPrerequisits;
	}

	public void setLMRelatedWebinarsPrerequisits(
			String lMRelatedWebinarsPrerequisits) {
		LMRelatedWebinarsPrerequisits = lMRelatedWebinarsPrerequisits;
	}

	public String getLMRelatedWebinarsDuration() {
		return LMRelatedWebinarsDuration;
	}

	public void setLMRelatedWebinarsDuration(String lMRelatedWebinarsDuration) {
		LMRelatedWebinarsDuration = lMRelatedWebinarsDuration;
	}
	
	
}

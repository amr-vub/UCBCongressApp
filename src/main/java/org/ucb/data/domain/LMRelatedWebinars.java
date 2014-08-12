package org.ucb.data.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** 
 * Each session has a list of related webinars that the App can
 * suggest to HCPs
 * This class contains those webinars's info 
 */

@Entity
public class LMRelatedWebinars {

	@Id @GeneratedValue
	private int LMRelatedWebinarsID;
	
	@Column @Temporal(TemporalType.TIMESTAMP)
	private Date LMRelatedWebinarsDate;
	
	@Column
	private String LMRelatedWebinarsName;
	
	@Column
	private String LMRelatedWebinarsTopic;
	
	@Column
	private String LMRelatedWebinarsPrerequisits;
	
	@Column
	private String LMRelatedWebinarsDuration;
	
	@ManyToMany(mappedBy="MSL_LMRelatedWebinars")
	private List<MSL> LMRelatedWebinars_MSL;
	
	@ManyToMany(mappedBy="session_RelatedWebinars")
	private List<Session> LMRelatedWebinars_Session;

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

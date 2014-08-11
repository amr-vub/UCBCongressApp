package org.ucb.data.domain;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.mapping.List;

/** 
 * This class is the base class of HCP, it contains the details
 * that we collect anonymously from HCP
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class HCP {
	
	// anonymous HCP access code
	//@Id
	//private int anonymousID;
	/* TODO
	 * If that was a sponsored HCP, we should have his details already
	 * in our system (e.g. orbit), and he should have a unique Id, in
	 * which we can reuse it here nad link our App to UCB's
	 */
	@Id
	private int HCPID;
	
	// HCP area of specialization
	@Column
	private String specialization;
	
	// HCP sub_specialization
	@Column
	private String sub_specialization;
	
	// Determines if HCP is active in the field of academia of clinically engaged
	@Column
	private String academic_practitioner_value;
	
	//is this HCP registered or anonymous
	@Column
	private boolean regesteredStatus;
	
	// each HCP can have only one Agenda
	@OneToOne(mappedBy="agenda_hcp")
	private Agenda HCP_agenda;
	
	// each HCP have one or many interests
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "HCPInitialInterests_hcp")
	private java.util.List<HCPInitialInterests> HCP_hcpInitialInterests = new ArrayList<HCPInitialInterests>();	
	
	public int getHCPID() {
		return HCPID;
	}

	public void setHCPID(int hCPID) {
		HCPID = hCPID;
	}

	public Agenda getHCP_agenda() {
		return HCP_agenda;
	}

	public void setHCP_agenda(Agenda hCP_agenda) {
		HCP_agenda = hCP_agenda;
	}

	public java.util.List<HCPInitialInterests> getHCP_hcpInitialInterests() {
		return HCP_hcpInitialInterests;
	}

	public void setHCP_hcpInitialInterests(
			java.util.List<HCPInitialInterests> hCP_hcpInitialInterests) {
		HCP_hcpInitialInterests = hCP_hcpInitialInterests;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getSub_specialization() {
		return sub_specialization;
	}

	public void setSub_specialization(String sub_specialization) {
		this.sub_specialization = sub_specialization;
	}

	public String getAcademic_practitioner_value() {
		return academic_practitioner_value;
	}

	public void setAcademic_practitioner_value(String academic_practitioner_value) {
		this.academic_practitioner_value = academic_practitioner_value;
	}

	public boolean isRegesteredStatus() {
		return regesteredStatus;
	}

	public void setRegesteredStatus(boolean regesteredStatus) {
		this.regesteredStatus = regesteredStatus;
	}
	
	

}

package org.ucb.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

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
	protected int hcpID;
	
	
	@Column
	protected String profession;
	
	// HCP area of specialization
	@Column
	protected String specialization;
	
	// HCP sub_specialization
	@Column
	protected String sub_specialization;
	
	// Determines if HCP is active in the field of academia of clinically engaged
	@Column
	protected String academic_practitioner_value;
	
	//is this HCP registered or anonymous
	@Column
	protected boolean regesteredStatus;
	
	// how many times HCP invites other HCPs
	@Column
	protected int no_Sent_Invitation;
	
	// each HCP can have only one Agenda
	@OneToOne(cascade = CascadeType.ALL, mappedBy="agenda_hcp") 
	protected Agenda hcp_agenda;
	
	// each HCP have one or many interests
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "HCPInitialInterests_hcp")
	@Cascade({org.hibernate.annotations.CascadeType.ALL})
	protected List<HCPInitialInterests> hcp_hcpInitialInterests = new ArrayList<HCPInitialInterests>();
	
	/*
	//each HCP will attend m to n sessions
	@ManyToMany(cascade=CascadeType.ALL) 
	@JoinTable(name="HCP_SESSION")
	private List<Session> HCPSession;
	*/
	/*
	// each HCP can give one answer per feedback question
	@OneToOne(cascade=CascadeType.ALL, mappedBy="FBAnswer_HCP")
	private FeedbackAnswer HCP_FBAnswer;
	
	// each HCP can give one choice per vote
	@OneToOne(cascade=CascadeType.ALL, mappedBy="VChoice_HCP")
	private VoteChoices HCP_voteChoices;
	
	// each HCP can post zero or more questions
	@OneToMany(cascade=CascadeType.ALL, mappedBy="qs_HCP")
	private List<Questions> HCP_qs;
	*/
	
	public int getNo_Sent_Invitation() {
		return no_Sent_Invitation;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setNo_Sent_Invitation(int no_Sent_Invitation) {
		this.no_Sent_Invitation = no_Sent_Invitation;
	}


	public int getHcpID() {
		return hcpID;
	}

	public void setHcpID(int hcpID) {
		this.hcpID = hcpID;
	}



	public Agenda getHcp_agenda() {
		return hcp_agenda;
	}

	public void setHcp_agenda(Agenda hcp_agenda) {
		this.hcp_agenda = hcp_agenda;
	}

	public List<HCPInitialInterests> getHcp_hcpInitialInterests() {
		return hcp_hcpInitialInterests;
	}

	public void setHcp_hcpInitialInterests(
			List<HCPInitialInterests> hcp_hcpInitialInterests) {
		this.hcp_hcpInitialInterests = hcp_hcpInitialInterests;
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

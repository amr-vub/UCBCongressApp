package org.ucb.data.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/** 
 * This class contains the initial interests collected from HCP 
 * from the initial survey he fills after providing his acces code
 */

@Entity
public class HCPInitialInterests {

	@Id @GeneratedValue
	private int hcp_Initial_Interests_ID;
	
	// HCP initial interests
	@Column
	private String hcp_Initial_Interest;
	
	@ManyToOne @JoinColumn(nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private HCP hcpInitialInterests_hcp;

	public int getHcp_Initial_Interests_ID() {
		return hcp_Initial_Interests_ID;
	}

	public void setHcp_Initial_Interests_ID(int hcp_Initial_Interests_ID) {
		this.hcp_Initial_Interests_ID = hcp_Initial_Interests_ID;
	}

	public String getHcp_Initial_Interest() {
		return hcp_Initial_Interest;
	}

	public void setHcp_Initial_Interest(String hcp_Initial_Interest) {
		this.hcp_Initial_Interest = hcp_Initial_Interest;
	}

	public HCP getHcpInitialInterests_hcp() {
		return hcpInitialInterests_hcp;
	}

	public void setHcpInitialInterests_hcp(HCP hcpInitialInterests_hcp) {
		this.hcpInitialInterests_hcp = hcpInitialInterests_hcp;
	}
	
}

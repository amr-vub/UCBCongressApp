package org.ucb.data.domain;


/** 
 * This class contains the initial interests collected from HCP 
 * from the initial survey he fills after providing his acces code
 */
public class HCPInitialInterests {

	private int hcp_Initial_Interests_ID;
	
	// HCP initial interests
	private String hcp_Initial_Interest;
	
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

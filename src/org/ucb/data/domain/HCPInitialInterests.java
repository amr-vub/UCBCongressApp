package org.ucb.data.domain;


/** 
 * This class contains the initial interests collected from HCP 
 * from the initial survey he fills after providing his acces code
 */
public class HCPInitialInterests {

	private int HCP_Initial_Interests_ID;
	
	// HCP initial interests
	private String HCP_Initial_Interest;
	
	private HCP HCPInitialInterests_hcp;

	
	
	public HCP getHCPInitialInterests_hcp() {
		return HCPInitialInterests_hcp;
	}

	public void setHCPInitialInterests_hcp(HCP hCPInitialInterests_hcp) {
		HCPInitialInterests_hcp = hCPInitialInterests_hcp;
	}

	public int getHCP_Initial_Interests_ID() {
		return HCP_Initial_Interests_ID;
	}

	public void setHCP_Initial_Interests_ID(int hCP_Initial_Interests_ID) {
		HCP_Initial_Interests_ID = hCP_Initial_Interests_ID;
	}

	public String getHCP_Initial_Interest() {
		return HCP_Initial_Interest;
	}

	public void setHCP_Initial_Interest(String hCP_Initial_Interest) {
		HCP_Initial_Interest = hCP_Initial_Interest;
	}
	
	
}

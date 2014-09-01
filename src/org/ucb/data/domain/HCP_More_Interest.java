package org.ucb.data.domain;



/** 
 * This class contains the added HCP interests (if any) that 
 * he adds when registering
 */

public class HCP_More_Interest {


	private int MoreInterestID;
	
	private String MoreInterest;
	
	private RegisteredHCP more_Interest_registeredHCP;

	public HCP_More_Interest(){
		
	}
	
	public RegisteredHCP getMore_Interest_registeredHCP() {
		return more_Interest_registeredHCP;
	}

	public void setMore_Interest_registeredHCP(
			RegisteredHCP more_Interest_registeredHCP) {
		this.more_Interest_registeredHCP = more_Interest_registeredHCP;
	}

	public int getMoreInterestID() {
		return MoreInterestID;
	}

	public void setMoreInterestID(int moreInterestID) {
		MoreInterestID = moreInterestID;
	}

	public String getMoreInterest() {
		return MoreInterest;
	}

	public void setMoreInterest(String moreInterest) {
		MoreInterest = moreInterest;
	}
	
}

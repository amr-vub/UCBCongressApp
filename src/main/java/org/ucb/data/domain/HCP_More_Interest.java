package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/** 
 * This class contains the added HCP interests (if any) that 
 * he adds when registering
 */

@Entity
public class HCP_More_Interest {

	@Id @GeneratedValue
	private int MoreInterestID;
	
	@Column
	private String MoreInterest;
	
	@ManyToOne
	private RegisteredHCP more_Interest_registeredHCP;

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

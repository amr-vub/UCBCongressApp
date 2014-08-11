package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** 
 * This class determines which  therapeutic domain the HCP 
 * is interested in receiving more info about
 */

public class Domain_of_Contact {

	@Id @GeneratedValue
	private int ContactID;
	
	
	// Therapeutic domain (eg. epilepsy, Parkinson, etc.)
	@Column
	private String Domain;


	public int getContactID() {
		return ContactID;
	}


	public void setContactID(int contactID) {
		ContactID = contactID;
	}


	public String getDomain() {
		return Domain;
	}


	public void setDomain(String domain) {
		Domain = domain;
	}
}

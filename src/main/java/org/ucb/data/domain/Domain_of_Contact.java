package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/** 
 * This class determines which  therapeutic domain the HCP 
 * is interested in receiving more info about
 */
@Entity
public class Domain_of_Contact {

	@Id @GeneratedValue
	private int ContactID;
	
	
	// Therapeutic domain (eg. epilepsy, Parkinson, etc.)
	@Column
	private String Domain;

	@ManyToOne @JoinColumn(nullable=false)
	private Preferences domain_preferences;

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

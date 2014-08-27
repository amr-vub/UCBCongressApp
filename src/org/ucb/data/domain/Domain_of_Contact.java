package org.ucb.data.domain;


/** 
 * This class determines which  therapeutic domain the HCP 
 * is interested in receiving more info about
 */

public class Domain_of_Contact {

	private int ContactID;
	
	
	// Therapeutic domain (eg. epilepsy, Parkinson, etc.)
	private String Domain;

	private Preferences domain_preferences;

	public Preferences getDomain_preferences() {
		return domain_preferences;
	}


	public void setDomain_preferences(Preferences domain_preferences) {
		this.domain_preferences = domain_preferences;
	}


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

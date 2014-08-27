package org.ucb.data.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/** 
 * This class contains detail preferences for each HCP
 * What he wants to know about
 * How he wants to receive the info
 * How frequent can we contact him
 */

@Entity
public class Preferences {

	@Id @GeneratedValue
	private int PrefID;
	
	// How HCP wanted to be contacted, e.g. email, letter ...etc.
	@Column
	private String communication_Channel ;
	
	// opt in and opt out status
	@Column
	private boolean optIn_OptOut;
	
	// How frequent the HCP wanted to be contacted.
	// Value in days
	@Column
	private int timeRange;
	
	@OneToOne @JoinColumn(nullable=false)
	private RegisteredHCP pref_registeredHCP; 
	
	// each preferences has one or many domain of contact
	@OneToMany(cascade = CascadeType.ALL,mappedBy="domain_preferences")
	private List<Domain_of_Contact> pref_domain;
	
	// each preferences has one or many domain of contact
	@OneToMany(cascade = CascadeType.ALL,mappedBy="cat_pref")
	private List<Category> pref_cat;

	public List<Domain_of_Contact> getPref_domain() {
		return pref_domain;
	}

	public void setPref_domain(List<Domain_of_Contact> pref_domain) {
		this.pref_domain = pref_domain;
	}

	public List<Category> getPref_cat() {
		return pref_cat;
	}

	public void setPref_cat(List<Category> pref_cat) {
		this.pref_cat = pref_cat;
	}

	public RegisteredHCP getPref_registeredHCP() {
		return pref_registeredHCP;
	}

	public void setPref_registeredHCP(RegisteredHCP pref_registeredHCP) {
		this.pref_registeredHCP = pref_registeredHCP;
	}

	public int getPrefID() {
		return PrefID;
	}

	public void setPrefID(int prefID) {
		PrefID = prefID;
	}

	public String getCommunication_Channel() {
		return communication_Channel;
	}

	public void setCommunication_Channel(String communication_Channel) {
		this.communication_Channel = communication_Channel;
	}

	public boolean isOptIn_OptOut() {
		return optIn_OptOut;
	}

	public void setOptIn_OptOut(boolean optIn_OptOut) {
		this.optIn_OptOut = optIn_OptOut;
	}

	public int getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(int timeRange) {
		this.timeRange = timeRange;
	}
	
	// TODO --> Purpose of consent
	
	
}

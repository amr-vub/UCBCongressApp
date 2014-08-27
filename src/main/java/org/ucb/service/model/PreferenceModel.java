package org.ucb.service.model;

import java.util.List;

import org.ucb.data.domain.Category;
import org.ucb.data.domain.Domain_of_Contact;

public class PreferenceModel {

	private int HCPID;
	
	private String communication_Channel;

	private boolean optIn_OptOut;
	
	private int timeRange;
	
	private List<Domain_of_Contact> pref_domain;
	
	private List<Category> pref_cat;
	
	public PreferenceModel(){		
	}

	public int getHCPID() {
		return HCPID;
	}

	public void setHCPID(int hCPID) {
		HCPID = hCPID;
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
	
}

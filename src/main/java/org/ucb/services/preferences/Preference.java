package org.ucb.services.preferences;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.ucb.data.domain.Category;
import org.ucb.data.domain.Domain_of_Contact;
import org.ucb.data.domain.Preferences;
import org.ucb.data.domain.RegisteredHCP;

@Service
public class Preference {
	
	private Preferences preferences;
		
	public void setCommunicationChannel(String communicationChannel)
	{
		preferences.setCommunication_Channel(communicationChannel);
	}
	
	public String getCommunicationChannel()
	{
		return preferences.getCommunication_Channel();
	}
	
	public void setOptIn_OptOut(boolean optIn_optOut)
	{
		preferences.setOptIn_OptOut(optIn_optOut);
	}
	
	public boolean isOptinOut()
	{
		return preferences.isOptIn_OptOut();
	}
	
	public void setTimeRange(int timeRange)
	{
		preferences.setTimeRange(timeRange);
	}
	
	public int getTimeRange()
	{
		return preferences.getTimeRange();
	}
	
	public void setPref_registeredHCP(RegisteredHCP pref_registeredHCP)
	{
		preferences.setPref_registeredHCP(pref_registeredHCP);
	}
	
	public void setPref_domain(List<Domain_of_Contact> pref_domain) 
	{
		preferences.setPref_domain(pref_domain);
	}
	
	public List<Domain_of_Contact> getPref_domain()
	{
		return preferences.getPref_domain();
	}
	
	public void setPref_cat(List<Category> pref_cat) 
	{
		preferences.setPref_cat(pref_cat);
	}
	
	public List<Category> getPref_cat() 
	{
		return preferences.getPref_cat();
	}
}

package org.ucb.service.controllers;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ucb.data.domain.Preferences;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.service.model.PreferenceModel;
import org.ucb.services.identification.IRegisteredUserService;
import org.ucb.services.preferences.Preference;

@RestController
@RequestMapping(value = "/pref")
public class PreferenceController {

	@Autowired
	IRegisteredUserService iRegisteredUserService;
	
	@RequestMapping(value = "/updatePreferences", method = RequestMethod.POST)	
	public void setRegisteredHCP_preferences(@RequestBody 
							PreferenceModel preferenceModel){	
		Preferences preferences = new Preferences();
		
		// mapping the model object to domain object
		preferences.setCommunication_Channel(preferenceModel.getCommunication_Channel());
		preferences.setOptIn_OptOut(preferenceModel.isOptIn_OptOut());
		preferences.setPref_cat(preferenceModel.getPref_cat());
		preferences.setPref_domain(preferenceModel.getPref_domain());
		preferences.setTimeRange(preferenceModel.getTimeRange());
		
		// update the pref in the DB
		iRegisteredUserService.setRegisteredHCP_preferences(preferences, preferenceModel.getHCPID());
	}
	
	/**
	 *  Return the preferences for the given hcpid, null if user not found or
	 *  the user doesn't have any pref yet
	 *  
	 *  @return
	 *  	<p> PreferenceModel : </p>
	 *  	<p> null : if user not found or the user doesn't have any pref yet
	 */
	
	@RequestMapping(value="/getCurrentPreferences", method = RequestMethod.GET)
	public PreferenceModel getCurrentPreferences(@RequestParam(value="HCPID", required = true)
												int HCPID){
		
		PreferenceModel preferenceModel = null;
		
		
		RegisteredHCP hcp = iRegisteredUserService.findUserById(HCPID);
		
		if(hcp!=null ){
			if(hcp.getRegisteredHCP_preferences()!=null)
			{
				preferenceModel = new PreferenceModel();
				preferenceModel.setHCPID(HCPID);
				Preferences pref = hcp.getRegisteredHCP_preferences();
				preferenceModel.setHCPID(HCPID);			
				preferenceModel.setOptIn_OptOut(pref.isOptIn_OptOut());				
				//pref = iRegisteredUserService.loadPref(pref);				
				preferenceModel.setCommunication_Channel(pref.getCommunication_Channel());
				System.out.println(pref.getPref_domain().get(0));
				preferenceModel.setPref_cat(iRegisteredUserService.loadCat(pref));
				preferenceModel.setPref_domain(iRegisteredUserService.loadDomain(pref));
				preferenceModel.setTimeRange(pref.getTimeRange());
			}
		}		
		return preferenceModel;
	}
}

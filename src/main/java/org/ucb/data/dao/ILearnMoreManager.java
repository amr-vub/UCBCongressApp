package org.ucb.data.dao;

import org.ucb.data.domain.LMRelatedWebinars;
import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.data.domain.LMRelatedpapers;

public interface ILearnMoreManager {

	// LMRelatedpapers part
	public LMRelatedpapers getLMRelatedpapersByID(int LMPID);
	
	public LMRelatedpapers getLMRelatedpapersByName(String LMPName);
	
	public LMRelatedpapers getLMRelatedpapersByAuthor(String LMPAuthor);
	
	public void storeLMRelatedpapers(LMRelatedpapers LMP);
	
	public void updateLMRelatedpapers(LMRelatedpapers LMP);
	
	public void deleteLMRelatedpapers(LMRelatedpapers LMP);
	
	// LMRelatedWebsites part
	public LMRelatedWebsites getLMRelatedWebsitesById(int LMWID);
	
	public LMRelatedWebsites getLMRelatedWebsitesByName(String LMWName);
	
	public void storeLMRelatedWebsites(LMRelatedWebsites LMW);
	
	public void updateLMRelatedWebsites(LMRelatedWebsites LMW);
	
	public void deleteLMRelatedWebsites(LMRelatedWebsites LMW);
	
	// LMRelatedWebinars part
	public LMRelatedWebinars getLMRelatedWebinarsById(int LMRWID);
	
	public LMRelatedWebinars getLMRelatedWebinarsByTopic(String LMRWTopic);
	
	public void storeLMRelatedWebinars(LMRelatedWebinars LMRW);
	
	public void updateLMRelatedWebinars(LMRelatedWebinars LMRW);
	
	public void deleteLMRelatedWebinars(LMRelatedWebinars LMRW);
	
	
}

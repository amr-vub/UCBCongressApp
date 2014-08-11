package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** 
 * Each session has a list of related websites that the App can
 * suggest to HCPs
 * This class contains those website's info 
 */
@Entity
public class LMRelatedWebsites {

	@Id @GeneratedValue
	private int LMRelatedWebsitesID;
	
	@Column
	private String LMRelatedWebsitesName;
	
	@Column
	private String LMRelatedWebsitesAbstract;
	
	@Column
	private String LMRelatedWebsitesLink;

	public int getLMRelatedWebsitesID() {
		return LMRelatedWebsitesID;
	}

	public void setLMRelatedWebsitesID(int lMRelatedWebsitesID) {
		LMRelatedWebsitesID = lMRelatedWebsitesID;
	}

	public String getLMRelatedWebsitesName() {
		return LMRelatedWebsitesName;
	}

	public void setLMRelatedWebsitesName(String lMRelatedWebsitesName) {
		LMRelatedWebsitesName = lMRelatedWebsitesName;
	}

	public String getLMRelatedWebsitesAbstract() {
		return LMRelatedWebsitesAbstract;
	}

	public void setLMRelatedWebsitesAbstract(String lMRelatedWebsitesAbstract) {
		LMRelatedWebsitesAbstract = lMRelatedWebsitesAbstract;
	}

	public String getLMRelatedWebsitesLink() {
		return LMRelatedWebsitesLink;
	}

	public void setLMRelatedWebsitesLink(String lMRelatedWebsitesLink) {
		LMRelatedWebsitesLink = lMRelatedWebsitesLink;
	}
	
	
}

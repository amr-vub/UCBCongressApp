package org.ucb.data.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(mappedBy="session_RelatedWebsites")
	private List<Session> relatedWebsites_session;

	public List<Session> getRelatedWebsites_session() {
		return relatedWebsites_session;
	}

	public void setRelatedWebsites_session(List<Session> relatedWebsites_session) {
		this.relatedWebsites_session = relatedWebsites_session;
	}

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

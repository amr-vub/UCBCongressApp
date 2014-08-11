package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** 
 * Each session has a list of related papers that the App can
 * suggest to HCPs
 * This class contains those paper's info 
 */

@Entity
public class LMRelatedpapers {

	@Id @GeneratedValue
	private int LMRelatedpapersID;
	
	@Column
	private String LMRelatedpapersName;
	
	@Column
	private String LMRelatedpapersAuthors;
	
	@Column
	private String LMRelatedpapersAbstract;
	
	@Column
	private String LMRelatedpapersLinks;

	public int getLMRelatedpapersID() {
		return LMRelatedpapersID;
	}

	public void setLMRelatedpapersID(int lMRelatedpapersID) {
		LMRelatedpapersID = lMRelatedpapersID;
	}

	public String getLMRelatedpapersName() {
		return LMRelatedpapersName;
	}

	public void setLMRelatedpapersName(String lMRelatedpapersName) {
		LMRelatedpapersName = lMRelatedpapersName;
	}

	public String getLMRelatedpapersAuthors() {
		return LMRelatedpapersAuthors;
	}

	public void setLMRelatedpapersAuthors(String lMRelatedpapersAuthors) {
		LMRelatedpapersAuthors = lMRelatedpapersAuthors;
	}

	public String getLMRelatedpapersAbstract() {
		return LMRelatedpapersAbstract;
	}

	public void setLMRelatedpapersAbstract(String lMRelatedpapersAbstract) {
		LMRelatedpapersAbstract = lMRelatedpapersAbstract;
	}

	public String getLMRelatedpapersLinks() {
		return LMRelatedpapersLinks;
	}

	public void setLMRelatedpapersLinks(String lMRelatedpapersLinks) {
		LMRelatedpapersLinks = lMRelatedpapersLinks;
	}
	
	
}

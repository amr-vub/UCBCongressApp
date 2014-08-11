package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/** 
 * This class contains info about what HCP wants to receive from
 * UCB in terms of products info, publication, webinar .. etc 
 */
@Entity
public class Category {

	@Id @GeneratedValue
	private int catID;
	
	// e.g. products info, publications,webinars etc.
	@Column
	private String category;

	public int getCatID() {
		return catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}

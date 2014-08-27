package org.ucb.data.domain;


/** 
 * This class contains info about what HCP wants to receive from
 * UCB in terms of products info, publication, webinar .. etc 
 */
public class Category {


	private int catID;
	
	// e.g. products info, publications,webinars etc.
	private String category;
	
	private Preferences cat_pref;	
	
	public Preferences getCat_pref() {
		return cat_pref;
	}

	public void setCat_pref(Preferences cat_pref) {
		this.cat_pref = cat_pref;
	}

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

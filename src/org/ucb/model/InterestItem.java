package org.ucb.model;

public class InterestItem {
	String title;
	boolean state;

	public InterestItem(String title, boolean state) {
		super();
		this.title = title;
		this.state = state;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

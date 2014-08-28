package org.ucb.model;

public class InterestItem {
	String title;
	boolean checked;

	public InterestItem(String title, boolean checked) {
		super();
		this.title = title;
		this.checked = checked;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

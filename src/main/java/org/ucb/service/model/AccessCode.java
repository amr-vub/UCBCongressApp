package org.ucb.service.model;

public class AccessCode {

	String access_code;
	
	boolean checkin;
	
	public AccessCode(String access_code, boolean checkin) {
		super();
		this.access_code = access_code;
		this.checkin = checkin;
	}
	
	public boolean isCheckin() {
		return checkin;
	}

	public void setCheckin(boolean checkin) {
		this.checkin = checkin;
	}

	public AccessCode() {

	}

	public String getAccess_code() {
		return access_code;
	}

	public void setAccess_code(String access_code) {
		this.access_code = access_code;
	}
	
}

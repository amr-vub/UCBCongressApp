package org.ucb.service.model;



public class AccessCode {

	private String access_code;
	
	private int checkin;
	
	
	public AccessCode(String access_code, int checkin) {
		super();
		this.access_code = access_code;
		this.checkin = checkin;		
	}

	public int getCheckin() {
		return checkin;
	}

	public void setCheckin(int checkin) {
		this.checkin = checkin;
	}



	public AccessCode() {

	}

	public String getAccessCode() {
		return access_code;
	}

	public void setAccessCode(String access_code) {
		this.access_code = access_code;
	}

	public String getAccess_code() {
		return access_code;
	}

	public void setAccess_code(String access_code) {
		this.access_code = access_code;
	}
	
}

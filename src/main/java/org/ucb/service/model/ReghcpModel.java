package org.ucb.service.model;

import org.ucb.data.domain.Login;

public class ReghcpModel {

	private int hcpId;
	
	private String hcpname;
	
	private String email;
	
	private String country;
	
	private int phone;
	
	private Login login;

	
	public int getHcpId() {
		return hcpId;
	}


	public void setHcpId(int hcpId) {
		this.hcpId = hcpId;
	}


	public String getHcpname() {
		return hcpname;
	}


	public void setHcpname(String hcpname) {
		this.hcpname = hcpname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public ReghcpModel(){
		
	}
	
}

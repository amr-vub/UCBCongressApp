package org.ucb.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/** 
 * This class is a sub-class of HCP, it contains the specific details
 * about HCP when he apt to register
 */

public class RegisteredHCP extends HCP{
	
	/* TODO
	 * If that was a sponsored HCP, we should have his details already
	 * in our system (e.g. orbit), and he should have a unique Id, in
	 * which we can reuse it here nad link our App to UCB's
	 */
	//@Id
	//private int HCPID;
	
	private String HCPName;
	
	private String email;
	
	private String country;
	
	private int phone;
	
	private Preferences registeredHCP_preferences;
	
	private Date RegisteredAt;
	
	private List<HCP_More_Interest> more_Interest = new ArrayList<HCP_More_Interest>();

	// each registered HCP, who is a speaker, can give sessions
	private List<Session> registeredHCP_Session;
	
	// each registered HCP can book zero or more MSL sessions
	private List<MSLSession> registeredHCP_MSLSession;
	
	// each registered HCP can recommend up to 5 papers
	private List<RecommendedPapers> registeredHCP_RecPeper;
	
	// each registered HCP have a login info
	private Login regHCP_login;
	
	public List<Session> getRegisteredHCP_Session() {
		return registeredHCP_Session;
	}

	public void setRegisteredHCP_Session(List<Session> registeredHCP_Session) {
		this.registeredHCP_Session = registeredHCP_Session;
	}

	public List<MSLSession> getRegisteredHCP_MSLSession() {
		return registeredHCP_MSLSession;
	}

	public void setRegisteredHCP_MSLSession(
			List<MSLSession> registeredHCP_MSLSession) {
		this.registeredHCP_MSLSession = registeredHCP_MSLSession;
	}

	public List<RecommendedPapers> getRegisteredHCP_RecPeper() {
		return registeredHCP_RecPeper;
	}

	public void setRegisteredHCP_RecPeper(
			List<RecommendedPapers> registeredHCP_RecPeper) {
		this.registeredHCP_RecPeper = registeredHCP_RecPeper;
	}

	public Preferences getRegisteredHCP_preferences() {
		return registeredHCP_preferences;
	}

	public void setRegisteredHCP_preferences(Preferences registeredHCP_preferences) {
		this.registeredHCP_preferences = registeredHCP_preferences;
	}

	public List<HCP_More_Interest> getMore_Interest() {
		return more_Interest;
	}

	public void setMore_Interest(List<HCP_More_Interest> more_Interest) {
		this.more_Interest = more_Interest;
	}

	public String getHCPName() {
		return HCPName;
	}

	public void setHCPName(String hCPName) {
		HCPName = hCPName;
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

	public Date getRegisteredAt() {
		return RegisteredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		RegisteredAt = registeredAt;
	}
	
	

}

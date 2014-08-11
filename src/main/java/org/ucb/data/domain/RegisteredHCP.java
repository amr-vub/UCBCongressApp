package org.ucb.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/** 
 * This class is a sub-class of HCP, it contains the specific details
 * about HCP when he apt to register
 */

@Entity
public class RegisteredHCP extends HCP{
	
	/* TODO
	 * If that was a sponsored HCP, we should have his details already
	 * in our system (e.g. orbit), and he should have a unique Id, in
	 * which we can reuse it here nad link our App to UCB's
	 */
	//@Id
	//private int HCPID;
	
	@Column
	private String HCPName;
	
	@Column
	private String email;
	
	@Column
	private String country;
	
	@Column
	private int phone;
	
	@OneToOne(mappedBy="pref_registeredHCP")
	private Preferences registeredHCP_preferences;
	
	@Column  @Temporal(TemporalType.DATE)
	private Date RegisteredAt;
	
	@OneToMany(mappedBy="more_Interest_registeredHCP")
	private List<HCP_More_Interest> more_Interest = new ArrayList<HCP_More_Interest>();


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

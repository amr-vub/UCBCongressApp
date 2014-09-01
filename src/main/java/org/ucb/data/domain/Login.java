package org.ucb.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Login {

	@Id @GeneratedValue
	private int loginID;
	
	@Column
	private String username;
	
	// TODO: Maybe saved a hashed password
	@Column
	private String password;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date lastLogIn;
	
	@OneToOne @JoinColumn(nullable=false, unique=true)
	private RegisteredHCP Login_regHCP;

	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RegisteredHCP getLogin_regHCP() {
		return Login_regHCP;
	}

	public void setLogin_regHCP(RegisteredHCP login_regHCP) {
		Login_regHCP = login_regHCP;
	}

	public Date getLastLogIn() {
		return lastLogIn;
	}

	public void setLastLogIn(Date lastLogIn) {
		this.lastLogIn = lastLogIn;
	}
	
	
}

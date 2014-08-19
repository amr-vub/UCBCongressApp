package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Login {

	@Id @GeneratedValue
	private int loginID;
	
	@Column
	private String username;
	
	// TODO: Maybe saved a hashed password
	@Column
	private String password;
	
	@OneToOne @JoinColumn(nullable=false)
	private RegisteredHCP Login_regHCP;
}

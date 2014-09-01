package org.ucb.data.domain;


public class Login {

	private int loginID;
	
	private String username;
	
	// TODO: Maybe saved a hashed password
	private String password;
	
	private RegisteredHCP Login_regHCP;

	public Login(){
		
	}
	
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
	
	
}

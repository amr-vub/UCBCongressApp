package org.ucb.model;

public class LoginInfo {
	private String username;
	
	private String password;
	
	private boolean userExists;

	public LoginInfo() {
	}
	
	public LoginInfo(String username, String password, boolean userExists) {
		super();
		this.username = username;
		this.password = password;
		this.userExists = userExists;
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

	public boolean isUserExists() {
		return userExists;
	}

	public void setUserExists(boolean userExists) {
		this.userExists = userExists;
	}
}

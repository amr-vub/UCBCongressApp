package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Access_Code_Dir {

	@Id @GeneratedValue
	private int accessID;
	
	@Column
	private int accessCode;

	public int getAccessID() {
		return accessID;
	}

	public void setAccessID(int accessID) {
		this.accessID = accessID;
	}

	public int getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(int accessCode) {
		this.accessCode = accessCode;
	}
	
	
}

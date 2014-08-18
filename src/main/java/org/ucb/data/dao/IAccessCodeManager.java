package org.ucb.data.dao;

import org.ucb.data.domain.Access_Code_Dir;

public interface IAccessCodeManager {

	public boolean accessCodeExists(int access_Code);
	
	public void insertAccessCode(int access_Code);
}

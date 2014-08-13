package org.ucb.data.dao;

import org.ucb.data.domain.Access_Code_Dir;

public interface IAccessCodeManager {

	public boolean accessCodeExists(int access_Code);
	
	public void insertAccessCode(Access_Code_Dir access_Code_Dir);
}

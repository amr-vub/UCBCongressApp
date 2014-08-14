package org.ucb.data.dao;

import org.ucb.data.domain.RegisteredHCP;


public interface IRegisteredUserManager {

	public RegisteredHCP findRegisteredUserById(int HCPID);
	
	public RegisteredHCP findRegisteredUserByEmail(String email);
	
	public RegisteredHCP storeRegisteredUser(RegisteredHCP user);

	public boolean registeredUserExists(int registeredID);

	public RegisteredHCP updateRegisteredUser(RegisteredHCP registeredUser);
	
	public void deleteRegisteredsUser(RegisteredHCP registeredUser);
}

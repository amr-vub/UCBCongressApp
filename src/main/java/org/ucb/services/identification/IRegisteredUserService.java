package org.ucb.services.identification;

import java.util.List;

import org.ucb.data.domain.Category;
import org.ucb.data.domain.Preferences;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.service.model.LoginInfo;

public interface IRegisteredUserService {

	public LoginInfo login(LoginInfo loginInfo);
	
	public RegisteredHCP registerUser(RegisteredHCP hcp);
	
	public void storeUser(RegisteredHCP registeredHCP);
	
	public void setRegisteredHCP_preferences(
			Preferences registeredHCP_preferences, int HCPID);
	
	public RegisteredHCP findUserById(int HCPID);
	
	public Preferences loadPref(Preferences PrefId);
}

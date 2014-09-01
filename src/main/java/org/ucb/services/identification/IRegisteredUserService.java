package org.ucb.services.identification;

import java.util.List;

import org.ucb.data.domain.Category;
import org.ucb.data.domain.Domain_of_Contact;
import org.ucb.data.domain.Preferences;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.service.model.LoginInfo;

public interface IRegisteredUserService {

	public LoginInfo login(LoginInfo loginInfo);
	
	public RegisteredHCP registerUser(RegisteredHCP hcp);
	
	public void storeUser(RegisteredHCP registeredHCP);
	
	public void setRegisteredHCP_preferences(
			Preferences registeredHCP_preferences, int HCPID);
	
	public void deleteUser(RegisteredHCP hcp);
	
	public RegisteredHCP findUserById(int HCPID);
	
	public Preferences loadPref(Preferences Pref);	
	
	public List<Domain_of_Contact> loadDomain(Preferences Pref);
	
	public List<Category> loadCat(Preferences Pref);
	
}

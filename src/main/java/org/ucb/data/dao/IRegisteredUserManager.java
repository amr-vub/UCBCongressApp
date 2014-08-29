package org.ucb.data.dao;

import java.util.List;

import org.ucb.data.domain.Category;
import org.ucb.data.domain.Domain_of_Contact;
import org.ucb.data.domain.Preferences;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.service.model.LoginInfo;


public interface IRegisteredUserManager {

	public RegisteredHCP findUserById(int HCPID);
	
	public RegisteredHCP findRegisteredUserByEmail(String email);
	
	public RegisteredHCP storeUser(RegisteredHCP user);

	public int userExists(String username, String Password);
	
	public boolean isRegistered(int registeredID);

	public RegisteredHCP updateRegisteredUser(RegisteredHCP registeredUser);
	
	public void deleteRegisteredsUser(RegisteredHCP registeredUser);
	
	public Preferences loadPref(Preferences PrefId);
	
	public List<Domain_of_Contact> loadDomain(Preferences Pref);
	
	public List<Category> loadCat(Preferences Pref);
}

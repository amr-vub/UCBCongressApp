package org.ucb.services.identification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ucb.data.dao.IRegisteredUserManager;
import org.ucb.data.dao.RegisteredUserManager;
import org.ucb.data.domain.Category;
import org.ucb.data.domain.Domain_of_Contact;
import org.ucb.data.domain.HCP;
import org.ucb.data.domain.HCP_More_Interest;
import org.ucb.data.domain.Login;
import org.ucb.data.domain.MSLSession;
import org.ucb.data.domain.Preferences;
import org.ucb.data.domain.RecommendedPapers;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.data.domain.Session;
import org.ucb.service.model.LoginInfo;
import org.ucb.services.login.SLoginModule;
import org.ucb.services.preferences.Preference;

@Service
public class RegisteredUserService implements IRegisteredUserService {

	@Autowired
	private IRegisteredUserManager registeredUserManager;

	private boolean loggedIn = false;
	/**
	 * This method is meant to store the HCP's information in the database.
	 */
	@Transactional
	public void storeUser(RegisteredHCP registeredHCP) {
		/* Update the DB */
		registeredUserManager.storeUser(registeredHCP);
	}

	/**
	 * Set the HCP's name.
	 * @param HCPName - the name to be set.
	 */
	@Transactional
	public void setHCPName(String HCPName, int HCPID) {

		RegisteredHCP hcp = registeredUserManager
				.findUserById(HCPID);

		if (null != hcp) {
			hcp.setHCPName(HCPName);

			/* Update the DB */
			registeredUserManager.updateRegisteredUser(hcp);
		}
	}

	/**
	 * Sets the HCP's email address.
	 * @param email - the email address to be set.
	 */
	@Transactional
	public void setEmail(String email , int HCPID) {

		RegisteredHCP hcp = registeredUserManager
				.findUserById(HCPID);

		if (null != hcp) {
			hcp.setEmail(email);

			/* Update the DB */
			registeredUserManager.updateRegisteredUser(hcp);
		}
	}
	
	/**
	 * Returns the HCP's email address.
	 * @return a valid email address.
	 */
	@Transactional
	public String getEmail(int HCPID)
	{
		RegisteredHCP hcp = registeredUserManager
				.findUserById(HCPID);

		if (null != hcp) {
			return hcp.getEmail();
		}
		
		return null;
	}
	

	/**
	 * Sets the HCP's residing country.
	 * @param country - the country to be set.
	 */
	@Transactional
	public void setCountry(String country,int HCPID) {

		RegisteredHCP hcp = registeredUserManager
				.findUserById(HCPID);

		if (null != hcp) {
			hcp.setCountry(country);

			/* Update the DB */
			registeredUserManager.updateRegisteredUser(hcp);
		}
	}
	
	/**
	 * Returns the HCP's country of residence.
	 * @return a string representing the country of residence.
	 */
	@Transactional
	public String getCountry(int HCPID)
	{
		RegisteredHCP hcp = registeredUserManager
				.findUserById(HCPID);

		if (null != hcp) {
			return hcp.getCountry();
		}
		
		return null;
	}

	/**
	 * Sets the HCP's phone number.
	 * @param phone - the phone number to be set.
	 */
	@Transactional
	public void setPhone(int phone, int HCPID) {

		RegisteredHCP hcp = registeredUserManager
				.findUserById(HCPID);

		if (null != hcp) {
			hcp.setPhone(phone);

			/* Update the DB */
			registeredUserManager.updateRegisteredUser(hcp);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@Transactional
	public int getPhone(int HCPID)
	{
		RegisteredHCP hcp = registeredUserManager
				.findUserById(HCPID);

		if (null != hcp) {
			return hcp.getPhone();
		}
		
		return -1;
	}

	/**
	 * Sets the HCP's preferences.
	 * @param registeredHCP_preferences - the list of preferences to be set.
	 */
	@Transactional
	public void setRegisteredHCP_preferences(
			Preferences registeredHCP_preferences, int HCPID) {

		RegisteredHCP hcp = registeredUserManager
				.findUserById(HCPID);

		if (null != hcp) {
			hcp.setRegisteredHCP_preferences(registeredHCP_preferences);

			/* Update the DB */
			registeredUserManager.updateRegisteredUser(hcp);
		}
	}

	/**
	 * Sets the fields on which the HCP wants to learn more.
	 * @param more_Interest - the list with the fields of interest.
	 */
	@Transactional
	public void setMore_Interest(List<HCP_More_Interest> more_Interest
			,int HCPID) {

		RegisteredHCP hcp = registeredUserManager
				.findUserById(HCPID);

		if (null != hcp) {
			hcp.setMore_Interest(more_Interest);

			/* Update the DB */
			registeredUserManager.updateRegisteredUser(hcp);
		}
	}

	/**
	 * Sets the sessions with a MSL the HCP wants to attend.
	 * @param registeredHCP_MSLSession - the list of MSL sessions the HCP is interested in.
	 */
	@Transactional
	public void setRegisteredHCP_MSLSession(
			List<MSLSession> registeredHCP_MSLSession, int HCPID) {

		RegisteredHCP hcp = registeredUserManager
				.findUserById(HCPID);

		if (null != hcp) {
			hcp.setRegisteredHCP_MSLSession(registeredHCP_MSLSession);

			/* Update the DB */
			registeredUserManager.updateRegisteredUser(hcp);
		}
	}

	/**
	 * Sets the papers which the HCP recommends.
	 * @param registeredHCP_RecPeper - the list of papers.
	 */
	@Transactional
	public void setRegisteredHCP_RecPeper(
			List<RecommendedPapers> registeredHCP_RecPeper, int HCPID) {

		RegisteredHCP hcp = registeredUserManager
				.findUserById(HCPID);

		if (null != hcp) {
			hcp.setRegisteredHCP_RecPeper(registeredHCP_RecPeper);

			/* Update the DB */
			registeredUserManager.updateRegisteredUser(hcp);
		}
	}

	/**
	 * Performs the login for an user.
	 * @return true - the user has been successfully logged in
	 * @return false - the user's login has failed
	 */	
	@Transactional
	public LoginInfo login(LoginInfo loginInfo) {		

		int hcpid;		
		Login login = null;
		RegisteredHCP hcp = null;
		
		// check if these usrname and password exists
		hcpid = registeredUserManager.userExists(loginInfo.getUsername(), loginInfo.getPassword());

		// if the credential exists, Store in the DB the loggedIn value
		if(hcpid != -1)
		{
			loggedIn = true;
			
			// update the last login value
			hcp = registeredUserManager.findUserById(hcpid);
			login = hcp.getRegHCP_login();
			login.setLastLogIn(new Date());
			hcp.setRegHCP_login(login);
			registeredUserManager.updateRegisteredUser(hcp);
			// populate the return object with hcpid and userexists = true
			loginInfo.setHCPID(hcpid);	
			loginInfo.setUserExists(true);
		}

		return loginInfo;
	}

	@Override
	@Transactional
	public RegisteredHCP registerUser(RegisteredHCP hcp) {
		RegisteredHCP hcp2 =
				registeredUserManager.findUserById(hcp.getHCPID());
		// updating the queried hcp
		if(hcp2!=null){
			loggedIn = true;
			hcp2.setCountry(hcp.getCountry());
			hcp2.setEmail(hcp.getEmail());
			hcp2.setHCPName(hcp.getHCPName());
			hcp2.setPhone(hcp.getPhone());
			hcp2.setNo_Sent_Invitation(0);
			hcp2.setRegesteredStatus(true);
			hcp2.setRegisteredAt(new Date());
			hcp2.setRegHCP_login(hcp.getRegHCP_login());
			// ipdate the DB entry
			registeredUserManager.updateRegisteredUser(hcp2);
		}		
		
		return hcp2;
	}

	@Override
	@Transactional
	public RegisteredHCP findUserById(int HCPID) {
		return registeredUserManager.findUserById(HCPID);
	}
	
	@Transactional
	public Preferences loadPref(Preferences PrefId){
		return registeredUserManager.loadPref(PrefId);
	}

	@Override
	@Transactional
	public List<Domain_of_Contact> loadDomain(Preferences Pref) {
		
		return registeredUserManager.loadDomain(Pref);
	}

	@Override
	@Transactional
	public List<Category> loadCat(Preferences Pref) {
		
		return registeredUserManager.loadCat(Pref);
	}

}

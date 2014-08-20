package org.ucb.services.identification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ucb.data.dao.RegisteredUserManager;
import org.ucb.data.domain.HCP;
import org.ucb.data.domain.HCP_More_Interest;
import org.ucb.data.domain.MSLSession;
import org.ucb.data.domain.Preferences;
import org.ucb.data.domain.RecommendedPapers;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.data.domain.Session;
import org.ucb.services.login.SLoginModule;
import org.ucb.services.preferences.Preference;

public class RegisteredUser extends AnonymousUser {

	private RegisteredUserManager registeredUserManager;
	private RegisteredHCP registeredHCP;
	private SLoginModule loginModule;

	public RegisteredUser(){		
	}
	
	/**
	 * Implicit constructor which just calls the AnonymousUser's constructor
	 * 
	 * @param HCPID
	 *            - the HCP's unique ID
	 * @param specialization
	 *            - the HCP's specialization
	 * @param sub_specialization
	 *            - the HCP's sub-specialization
	 * @param academic_practitioner_value
	 *            - the HCP's academic position
	 * @param regesteredStatus
	 *            - whether the HCP is registered or not
	 * @param no_Sent_Invitation
	 *            - the number of sent invitations
	 */
	public RegisteredUser(int HCPID, String specialization,
			String sub_specialization, String academic_practitioner_value,
			boolean regesteredStatus, int no_Sent_Invitation) {

		super(HCPID, specialization, sub_specialization,
				academic_practitioner_value, regesteredStatus,
				no_Sent_Invitation);
	}

	/**
	 * Initialization constructor.
	 * 
	 * @param HCPName - A valid HCP name
	 * @param email - A valid HCP email address
	 * @param country - The country where the HCP lives in
	 * @param phone - A valid phone number of the HCP
	 * @param registeredHCP_preferences - The initial preferences the HCP gives
	 * @param more_Interest - The areas on which the HCP want to learn more
	 * @param registeredHCP_MSLSession - whether the HCP opted in for a session with a MSL.
	 * @param registeredHCP_RecPeper - recommended papers by the HCP.
	 */
	public RegisteredUser(String HCPName, String email, String country,
			int phone, Preferences registeredHCP_preferences,
			List<HCP_More_Interest> more_Interest,
			List<MSLSession> registeredHCP_MSLSession,
			List<RecommendedPapers> registeredHCP_RecPeper) {
		registeredHCP.setHCPName(HCPName);
		registeredHCP.setEmail(email);
		registeredHCP.setCountry(country);
		registeredHCP.setPhone(phone);
		registeredHCP.setRegisteredHCP_preferences(registeredHCP_preferences);
		registeredHCP.setMore_Interest(more_Interest);
		registeredHCP.setRegisteredHCP_MSLSession(registeredHCP_MSLSession);
		registeredHCP.setRegisteredHCP_RecPeper(registeredHCP_RecPeper);

		Date date = Calendar.getInstance().getTime();
		registeredHCP.setRegisteredAt(date);
	}

	/**
	 * This method is meant to store the HCP's information in the database.
	 */
	@Transactional
	public void storeRegisteredUser() {
		/* Update the DB */
		registeredUserManager.storeRegisteredUser(registeredHCP);
	}

	/**
	 * Set the HCP's name.
	 * @param HCPName - the name to be set.
	 */
	@Transactional
	public void setHCPName(String HCPName) {

		RegisteredHCP hcp = registeredUserManager
				.findRegisteredUserById(hcpUser.getHCPID());

		if (null != hcp) {
			hcp.setHCPName(HCPName);

			/* Update the DB */
			registeredUserManager.storeRegisteredUser(hcp);
		}
	}

	/**
	 * Sets the HCP's email address.
	 * @param email - the email address to be set.
	 */
	@Transactional
	public void setEmail(String email) {

		RegisteredHCP hcp = registeredUserManager
				.findRegisteredUserById(hcpUser.getHCPID());

		if (null != hcp) {
			hcp.setEmail(email);

			/* Update the DB */
			registeredUserManager.storeRegisteredUser(hcp);
		}
	}
	
	/**
	 * Returns the HCP's email address.
	 * @return a valid email address.
	 */
	@Transactional
	public String getEmail()
	{
		RegisteredHCP hcp = registeredUserManager
				.findRegisteredUserById(hcpUser.getHCPID());

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
	public void setCountry(String country) {

		RegisteredHCP hcp = registeredUserManager
				.findRegisteredUserById(hcpUser.getHCPID());

		if (null != hcp) {
			hcp.setCountry(country);

			/* Update the DB */
			registeredUserManager.storeRegisteredUser(hcp);
		}
	}
	
	/**
	 * Returns the HCP's country of residence.
	 * @return a string representing the country of residence.
	 */
	@Transactional
	public String getCountry()
	{
		RegisteredHCP hcp = registeredUserManager
				.findRegisteredUserById(hcpUser.getHCPID());

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
	public void setPhone(int phone) {

		RegisteredHCP hcp = registeredUserManager
				.findRegisteredUserById(hcpUser.getHCPID());

		if (null != hcp) {
			hcp.setPhone(phone);

			/* Update the DB */
			registeredUserManager.storeRegisteredUser(hcp);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@Transactional
	public int getPhone()
	{
		RegisteredHCP hcp = registeredUserManager
				.findRegisteredUserById(hcpUser.getHCPID());

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
			Preferences registeredHCP_preferences) {

		RegisteredHCP hcp = registeredUserManager
				.findRegisteredUserById(hcpUser.getHCPID());

		if (null != hcp) {
			hcp.setRegisteredHCP_preferences(registeredHCP_preferences);

			/* Update the DB */
			registeredUserManager.storeRegisteredUser(hcp);
		}
	}

	/**
	 * Sets the fields on which the HCP wants to learn more.
	 * @param more_Interest - the list with the fields of interest.
	 */
	@Transactional
	public void setMore_Interest(List<HCP_More_Interest> more_Interest) {

		RegisteredHCP hcp = registeredUserManager
				.findRegisteredUserById(hcpUser.getHCPID());

		if (null != hcp) {
			hcp.setMore_Interest(more_Interest);

			/* Update the DB */
			registeredUserManager.storeRegisteredUser(hcp);
		}
	}

	/**
	 * Sets the sessions with a MSL the HCP wants to attend.
	 * @param registeredHCP_MSLSession - the list of MSL sessions the HCP is interested in.
	 */
	@Transactional
	public void setRegisteredHCP_MSLSession(
			List<MSLSession> registeredHCP_MSLSession) {

		RegisteredHCP hcp = registeredUserManager
				.findRegisteredUserById(hcpUser.getHCPID());

		if (null != hcp) {
			hcp.setRegisteredHCP_MSLSession(registeredHCP_MSLSession);

			/* Update the DB */
			registeredUserManager.storeRegisteredUser(hcp);
		}
	}

	/**
	 * Sets the papers which the HCP recommends.
	 * @param registeredHCP_RecPeper - the list of papers.
	 */
	@Transactional
	public void setRegisteredHCP_RecPeper(
			List<RecommendedPapers> registeredHCP_RecPeper) {

		RegisteredHCP hcp = registeredUserManager
				.findRegisteredUserById(hcpUser.getHCPID());

		if (null != hcp) {
			hcp.setRegisteredHCP_RecPeper(registeredHCP_RecPeper);

			/* Update the DB */
			registeredUserManager.storeRegisteredUser(hcp);
		}
	}

	/**
	 * Performs the login for an user.
	 * @return true - the user has been successfully logged in
	 * @return false - the user's login has failed
	 * @throws LoginException
	 */	
	public boolean login() throws LoginException {
		boolean loggedIn = false;

		loggedIn = loginModule.login();

		// TODO: Store in the DB the loggedIn value

		return loggedIn;
	}

}

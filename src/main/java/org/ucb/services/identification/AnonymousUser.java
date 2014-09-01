package org.ucb.services.identification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ucb.data.dao.*;
import org.ucb.data.domain.Access_Code_Dir;
import org.ucb.data.domain.Agenda;
import org.ucb.data.domain.HCP;
import org.ucb.data.domain.HCPInitialInterests;

@Service
public class AnonymousUser implements IAnonymousUser{

	protected HCP hcpUser;
	protected SessionIdentifierGenerator sessionIdentifier;
	@Autowired
	protected IAccessCodeManager accessCodeManager;
	@Autowired
	protected IAnonymousUserManager anonymousUserManager;
	
	protected Access_Code_Dir accessCodeDir;
	
	private boolean checkedIn = false;

	/**
	 * Implicit constructor for derived classes
	 */
	public AnonymousUser() {

	}

	/**
	 * Initialization constructor. To be used for the initial survey.
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
	public AnonymousUser(int HCPID, String specialization,
			String sub_specialization, String academic_practitioner_value,
			boolean regesteredStatus, int no_Sent_Invitation) {
		hcpUser.setHcpID(HCPID);
		hcpUser.setSpecialization(specialization);
		hcpUser.setSub_specialization(sub_specialization);
		hcpUser.setAcademic_practitioner_value(academic_practitioner_value);
		hcpUser.setRegesteredStatus(regesteredStatus);
		hcpUser.setNo_Sent_Invitation(no_Sent_Invitation);
	}

	/**
	 * Stores a new HCP User into the DB
	 */
	@Transactional
	public void storeAnonymousUser() {
		anonymousUserManager.storeAnonymousUser(hcpUser);
	}

	/**
	 * Sets the HCP's Agenda
	 * 
	 * @param hCP_agenda
	 *            - an Agenda object to be set
	 */
	@Transactional
	public void setAgenda(Agenda hCP_agenda) {

		HCP hcp = anonymousUserManager
				.findAnonymousUserById(hcpUser.getHcpID());

		if (hcp != null) {

			hcp.setHcp_agenda(hCP_agenda);

			/* Update the DB */
			anonymousUserManager.updateAnonymousUser(hcp);
		}
	}

	/**
	 * Sets the HCP's initial interests
	 * 
	 * @param hCP_hcpInitialInterests
	 *            - list of interests
	 */
	@Transactional
	public void setInitialInterests(
			List<HCPInitialInterests> hCP_hcpInitialInterests) {

		HCP hcp = anonymousUserManager
				.findAnonymousUserById(hcpUser.getHcpID());

		if (hcp != null) {

			hcp.setHcp_hcpInitialInterests(hCP_hcpInitialInterests);

			/* Update the DB */
			anonymousUserManager.updateAnonymousUser(hcp);
		}
	}

	/**
	 * Generates a code which doesn't exist already as an user ID. For internal use only.
	 * 
	 * @return an unique code.
	 */
	@Transactional
	private int generateUniqueCode() {
		int uniqueCode = 0;
		boolean codeExistsAlready = true;
		// Access_Code_Dir accessCodeDir = null;

		/* Generate a unique invitation code */
		while (codeExistsAlready) {
			uniqueCode = Integer.valueOf(sessionIdentifier.generateCode());

			codeExistsAlready = accessCodeManager.accessCodeExists(uniqueCode);

			if (codeExistsAlready == false) {
				return uniqueCode;
			} else {
				continue;
			}
		}
		return uniqueCode;
	}

	/**
	 * Generates an invitation for another HCP to use the application.
	 * 
	 * @return the generated invitation code.
	 */
	@Transactional
	public int generateInvitation() {

		int invitationCode = 0;
		int no_Sent_Invitation = 0;

		/* Generate a unique invitation code */
		invitationCode = generateUniqueCode();

		HCP hcp = anonymousUserManager
				.findAnonymousUserById(hcpUser.getHcpID());

		if (hcp != null) {

			/* Store the invitation code in the DB */
			accessCodeDir.setAccessCode(invitationCode);
			accessCodeManager.insertAccessCode(accessCodeDir.getAccessID());

			/* Update the number of sent invitations */
			no_Sent_Invitation = hcp.getNo_Sent_Invitation();
			no_Sent_Invitation++;
			hcp.setNo_Sent_Invitation(no_Sent_Invitation);

			/* Update the DB */
			anonymousUserManager.updateAnonymousUser(hcp);
		}

		return invitationCode;
	}

	/**
	 * Sets the HCP's specialization
	 * 
	 * @param specialization
	 *            - the specialization to be set
	 */
	@Transactional
	public void setSpecialization(String specialization) {

		HCP hcp = anonymousUserManager
				.findAnonymousUserById(hcpUser.getHcpID());

		if (hcp != null) {
			hcp.setSpecialization(specialization);

			/* Update the DB */
			anonymousUserManager.updateAnonymousUser(hcp);
		}
	}

	/**
	 * Set the sub-specialization
	 * 
	 * @param subSpecialization
	 *            - the sub-specialization to be set
	 */
	@Transactional
	public void setSubSpecialization(String subSpecialization) {

		HCP hcp = anonymousUserManager
				.findAnonymousUserById(hcpUser.getHcpID());

		if (hcp != null) {
			hcp.setSub_specialization(subSpecialization);

			/* Update the DB */
			anonymousUserManager.updateAnonymousUser(hcp);
		}
	}

	/**
	 * Sets the registered status
	 * 
	 * @param regesteredStatus
	 *            - the current registration status to be set
	 */
	@Transactional
	public void setRegesteredStatus(boolean regesteredStatus) {

		HCP hcp = anonymousUserManager
				.findAnonymousUserById(hcpUser.getHcpID());

		if (hcp != null) {
			hcp.setRegesteredStatus(regesteredStatus);

			/* Update the DB */
			anonymousUserManager.updateAnonymousUser(hcp);
		}
	}

	/**
	 * Set the number of sent invitations
	 * @param no_Sent_Invitation
	 */
	@Transactional
	public void setNo_Sent_invitation(int no_Sent_Invitation) {
		
		HCP hcp = anonymousUserManager
				.findAnonymousUserById(hcpUser.getHcpID());
		
		if(hcp != null)
		{
			hcp.setNo_Sent_Invitation(no_Sent_Invitation);
	
			/* Update the DB */
			anonymousUserManager.updateAnonymousUser(hcp);
		}
	}

	/**
	 * This function checks an HCP in.
	 * 
	 * @param inputCode
	 *            - the access code
	 * @return 0 - if the user is already in the system
	 * @return -1 - if the inputCode is wrong
	 * @return 1 - if the user is a new-comer. The survey should follow in
	 *         this case.
	 */
	@Transactional
	public int checkIn(int inputCode) {
		if(checkedIn == false){
			boolean codeExists = true;
			Access_Code_Dir accessCodeDir = null;
			
			if(anonymousUserManager.anonymousUserExists(inputCode))
			{
				// The user already exists
				return 0;
			}
			
			else
			{
				codeExists = accessCodeManager.accessCodeExists(inputCode);
				
				if (true != codeExists) {
					//Error
					return -1;
				} 
				
				/* A new-comer */
	
				/* Redirect to survey. */
				return 1;
			}
		}
		return 0;
	}
}

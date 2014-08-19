package org.ucb.services.identification;

import java.util.List;

import org.ucb.data.dao.*;
import org.ucb.data.domain.Access_Code_Dir;
import org.ucb.data.domain.Agenda;
import org.ucb.data.domain.HCP;
import org.ucb.data.domain.HCPInitialInterests;

public class AnonymousUser {
	
	protected HCP hcpUser;
	protected SessionIdentifierGenerator sessionIdentifier;
	protected AccessCodeManager accessCodeManager;

	/**
	 * Initialization constructor. To be used for the initial survey.
	 * @param HCPID - the HCP's unique ID
	 * @param specialization - the HCP's specialization
	 * @param sub_specialization - the HCP's sub-specialization
	 * @param academic_practitioner_value - the HCP's academic position
	 * @param regesteredStatus - whether the HCP is registered or not
	 * @param no_Sent_Invitation - the number of sent invitations
	 */
	public AnonymousUser(int HCPID, String specialization, String sub_specialization, String academic_practitioner_value, boolean regesteredStatus, int no_Sent_Invitation)
	{
		hcpUser.setHCPID(HCPID);
		hcpUser.setSpecialization(specialization);
		hcpUser.setSub_specialization(sub_specialization);
		hcpUser.setAcademic_practitioner_value(academic_practitioner_value);
		hcpUser.setRegesteredStatus(regesteredStatus);
		hcpUser.setNo_Sent_Invitation(no_Sent_Invitation);
	}
	
	/**
	 * Sets the HCP's Agenda
	 * @param hCP_agenda - an Agenda object to be set
	 */
	public void setAgenda(Agenda hCP_agenda)
	{
		hcpUser.setHCP_agenda(hCP_agenda);
	}
	
	
	/**
	 * Sets the HCP's initial interests
	 * @param hCP_hcpInitialInterests - list of interests
	 */
	public void setInitialInterests(List<HCPInitialInterests> hCP_hcpInitialInterests)
	{
		hcpUser.setHCP_hcpInitialInterests(hCP_hcpInitialInterests);
	}
	
	/**
	 * Generates an invitation for another HCP to use the application.
	 * @return the generated invitation code.
	 */
	public int generateInvitation(){
		
		int invitationCode        = 0;
		int no_Sent_Invitation    = 0;
		boolean codeExistsAlready = true;	
		Access_Code_Dir accessCodeDir = null;
		
		/* Generate a unique invitation code*/
		while(codeExistsAlready)
		{
			invitationCode = sessionIdentifier.generateCode().intValue();
			
			codeExistsAlready = accessCodeManager.accessCodeExists(invitationCode);
			
			if(codeExistsAlready == false)
			{
				/* Store the invitation code in the DB*/
				accessCodeDir.setAccessCode(invitationCode);
				accessCodeManager.insertAccessCode(accessCodeDir);
				
				/* Update the number of sent invitations*/
				no_Sent_Invitation = hcpUser.getNo_Sent_Invitation();
				no_Sent_Invitation++;		
				hcpUser.setNo_Sent_Invitation(no_Sent_Invitation);
				
				return invitationCode;
			}
			else
			{
				continue;
			}
		}
		return invitationCode;	
	}
	
	/**
	 * Sets the HCP's specialization
	 * @param specialization - the specialization to be set
	 */
	public void setSpecialization(String specialization)
	{		
		hcpUser.setSpecialization(specialization);
	}
	
	/**
	 * Set the sub-specialization
	 * @param subSpecialization - the sub-specialization to be set
	 */
	public void setSubSpecialization(String subSpecialization)
	{		
		hcpUser.setSub_specialization(subSpecialization);
		
	}
	
	/**
	 * Sets the registered status
	 * @param regesteredStatus - the current registration status to be set
	 */
	public void setRegesteredStatus(boolean regesteredStatus)
	{		
		hcpUser.setRegesteredStatus(regesteredStatus);		
	}
	
	/**
	 * 
	 * @param no_Sent_Invitation
	 */
	public void setNo_Sent_invitation(int no_Sent_Invitation)
	{
		hcpUser.setNo_Sent_Invitation(no_Sent_Invitation);
	}
	
	/**
	 * This function checks an HCP in.
	 * @param inputCode - the access code
	 * @return 0 - if the user was in the system before
	 * @return HCP_ID - if the user is a new-comer. The survey should follow in this case.
	 */
	public int checkIn(int inputCode)
	{
		boolean codeExistsAlready     = true;
		Access_Code_Dir accessCodeDir = null;
		
		codeExistsAlready = accessCodeManager.accessCodeExists(inputCode);
		
		if(codeExistsAlready == true)
		{
			/* A returning user. */
			return 0;
		}
		else
		{
			/* A new-comer*/
			accessCodeDir.setAccessCode(inputCode);
			accessCodeManager.insertAccessCode(accessCodeDir);
			
			/* Redirect to survey.*/			
			return inputCode;
		}
	}
}

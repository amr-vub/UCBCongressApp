package org.ucb.services.identification;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.ucb.data.dao.IAccessCodeManager;
import org.ucb.service.IAnonymousUserServiceStub;
import org.ucb.services.login.SLoginModule;

public class AnonymousUser {

	/* Assuming everyone has one */
	protected Integer uniqueID;
	
	@Autowired
	private IAnonymousUserServiceStub iAnonymousUserServiceStub;
	
	@Autowired
	private IAccessCodeManager iAccessCodeManager;
	
	protected UserType userType;

	protected String country;

	protected ArrayList<String> professionalTitles;

	protected String academicTitle;

	protected SessionIdentifierGenerator sessionIdentifier;

	protected int checkInCode;
	protected int invitationCode;
	protected int invitationsSent;

	protected boolean checkedIn;

	public AnonymousUser() {
		userType = UserType.UNDEFINED;
		country = null;
		professionalTitles = null;
		academicTitle = null;
		sessionIdentifier = new SessionIdentifierGenerator();
		checkedIn = false;
		invitationsSent = 0;
	}

	public int generateRandomCode() {
		checkInCode = sessionIdentifier.generateCode();
		
		return checkInCode;
	}
	
	public int generateInvitation(){
		invitationCode = sessionIdentifier.generateCode();
		
		invitationsSent++;
		
		//Done: Store the invitationCode in the DB for this User
		iAccessCodeManager.insertAccessCode(invitationCode);
		//Done: Store the invitationsSent in the DB for this User
		iAnonymousUserServiceStub.update_invitationsSent(uniqueID, invitationsSent);
		
		return invitationCode;
	}

	public boolean checkIn(int inputCode) {
		if (checkedIn == false) { 
			if (iAnonymousUserServiceStub.anonymousUserExists(inputCode)) {
				// The User is checked in
				checkedIn = true;
				//TODO: update last login in DB
				
				return checkedIn;
			} 
			// his first check in
			else if(iAccessCodeManager.accessCodeExists(inputCode)){
				checkedIn = true;
				return checkedIn;
			}
		}
		return checkedIn;
	}
}

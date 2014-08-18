package org.ucb.services.identification;

import java.util.ArrayList;

import org.ucb.services.login.SLoginModule;

public class AnonymousUser {

	protected UserType userType;

	protected String country;

	protected ArrayList<String> professionalTitles;

	protected String academicTitle;

	protected SessionIdentifierGenerator sessionIdentifier;

	protected String checkInCode;
	protected String invitationCode;
	protected int invitationsSent;

	protected boolean checkedIn;

	public AnonymousUser() {
		userType = UserType.UNDEFINED;
		country = null;
		professionalTitles = null;
		academicTitle = null;
		checkInCode = null;
		sessionIdentifier = new SessionIdentifierGenerator();
		checkedIn = false;
		invitationsSent = 0;
	}

	public String generateRandomCode() {
		checkInCode = sessionIdentifier.generateCode();
		
		return checkInCode;
	}
	
	public String generateInvitation(){
		invitationCode = sessionIdentifier.generateCode();
		
		invitationsSent++;
		
		//TODO: Store the invitationCode in the DB for this User
		//TODO: Store the invitationsSent in the DB for this User
		
		return invitationCode;
	}

	public int checkIn(String inputCode) {
		if (checkedIn == false) {
			if (checkInCode.matches(inputCode)) {
				// The User is checked in
				checkedIn = true;
				//TODO: Store checkedIn in the DB
				return 0;
			} else {
				checkedIn = false;
				return 1;
			}
		}
		return 0;
	}
}

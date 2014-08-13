package org.ucb.services.identification;

import sampleLogin.SLoginModule;

import java.util.ArrayList;

import sampleLogin.SLoginModule;

public class AnonymousUser {

	protected UserType userType;

	protected String country;

	protected ArrayList<String> professionalTitles;

	protected String academicTitle;

	protected static SLoginModule loginModule;

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

		// Instantiate the Login Module if this hasn't be done previously
		if (!(loginModule instanceof SLoginModule)) {
			loginModule = new SLoginModule();
		}
	}

	public String generateRandomCode() {
		checkInCode = sessionIdentifier.generateCode();
		
		return checkInCode;
	}
	
	public String generateInvitation(){
		invitationCode = sessionIdentifier.generateCode();
		
		invitationsSent++;
		
		//Store the invitationCode in the DB
		
		return invitationCode;
	}

	public int checkIn(String inputCode) {
		if (checkedIn == false) {
			if (checkInCode.matches(inputCode)) {
				// The User is checked in
				checkedIn = true;
				return 0;
			} else {
				checkedIn = false;
				return 1;
			}
		}
		return 0;
	}
}

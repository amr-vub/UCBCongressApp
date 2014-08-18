package org.ucb.services.identification;

import java.security.SecureRandom;

public class SessionIdentifierGenerator {

	private SecureRandom randomCode = new SecureRandom();

	public int generateCode() {
		return randomCode.nextInt();
	}
}

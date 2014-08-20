package org.ucb.services.identification;

import java.math.BigInteger;
import java.security.SecureRandom;

public class SessionIdentifierGenerator {

	private SecureRandom randomCode = new SecureRandom();

	public String generateCode() {
		return new BigInteger(130, randomCode).toString(32);
	}
}

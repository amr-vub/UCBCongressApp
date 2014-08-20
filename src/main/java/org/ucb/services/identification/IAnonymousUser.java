package org.ucb.services.identification;

public interface IAnonymousUser {
	
	public int generateRandomCode() ;
	
	public int generateInvitation();
	
	public boolean checkIn(int inputCode) ;
}

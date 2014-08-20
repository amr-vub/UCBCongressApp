package org.ucb.services.identification;


public interface IAnonymousUser {
	
	public void storeAnonymousUser() ;	
	
	public int generateInvitation() ;
	
	public int checkIn(int inputCode) ;
}

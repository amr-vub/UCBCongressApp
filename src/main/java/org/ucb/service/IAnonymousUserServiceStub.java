package org.ucb.service;

import org.ucb.data.domain.HCP;

public interface IAnonymousUserServiceStub {

	public void deleteAnonymousUser(HCP anonymousUser);
	
	public HCP storeAnonymousUser(HCP anonymousUser);
	
	public boolean anonymousUserExists(int anonymousID);
	
	public HCP getHCPbyID(int ID);
	
	public void update_invitationsSent(int anonymousUser, int inv);
	
	//public void update_LastLogin(int )
}

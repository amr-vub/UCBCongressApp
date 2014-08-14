package org.ucb.service;

import org.ucb.data.domain.HCP;

public interface IAnonymousUserServiceStub {

	public void deleteAnonymousUser(HCP anonymousUser);
	
	public HCP storeAnonymousUser(HCP anonymousUser);
	
	public HCP getHCPbyID(int ID);
}

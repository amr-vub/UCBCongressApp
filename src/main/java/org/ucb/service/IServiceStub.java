package org.ucb.service;

import org.ucb.data.domain.HCP;

public interface IServiceStub {

	public void deleteAnonymousUser(HCP anonymousUser);
	
	public HCP storeAnonymousUser(HCP anonymousUser);
}

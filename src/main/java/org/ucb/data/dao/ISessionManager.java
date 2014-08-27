package org.ucb.data.dao;

import org.ucb.data.domain.Session;

public interface ISessionManager {

	public void storeSession(Session sess);
	
	public void updateSession(Session sess);
	
	public void deleteSession(Session sess);
}

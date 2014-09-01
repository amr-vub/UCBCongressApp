package org.ucb.data.dao;

import org.ucb.data.domain.Session;

public interface ISessionManager {

	public Session getSessionById(int sessID);
	
	public void storeSession(Session sess);
	
	public void updateSession(Session sess);
	
	public void deleteSession(Session sess);
}

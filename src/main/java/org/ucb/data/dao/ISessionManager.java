package org.ucb.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.data.domain.Session;

public interface ISessionManager {

	public Session getSessionById(int sessID);
	
	public void storeSession(Session sess);
	
	public void updateSession(Session sess);
	
	public void deleteSession(Session sess);
	
	public ArrayList<LMRelatedWebsites> loadLMRelatedWebsites(Session ses);
}

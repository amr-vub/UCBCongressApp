package org.ucb.data.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.Session;

@Repository
public class SessionManager implements ISessionManager{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void storeSession(Session sess){
		getSessionFactory().getCurrentSession().persist(sess);		
	}

	public void updateSession(Session sess){
		getSessionFactory().getCurrentSession().update(sess);
	}
	
	public void deleteSession(Session sess){
		getSessionFactory().getCurrentSession().delete(sess);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}

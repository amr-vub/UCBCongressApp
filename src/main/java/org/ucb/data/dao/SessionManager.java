package org.ucb.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.Feedback;
import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.data.domain.Session;
import org.ucb.data.domain.Vote;

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

	@Override
	public Session getSessionById(int sessID) {
		
		Session ses = (Session) getSessionFactory().getCurrentSession().get(Session.class, sessID);
		
		// loading session field list, cause of lazy fetching problems
		List<Feedback> listFB = loadFB(ses);
		
		ses.setSession_FB(listFB);
		
		List<Vote> listVote = loadVote(ses);
		ses.setSession_vote(listVote);
		
		return ses;
	}

	@Override
	public List<LMRelatedWebsites> loadLMRelatedWebsites(Session ses) {
		
		List<LMRelatedWebsites> list = getSessionFactory().getCurrentSession().
			createQuery("SELECT u FROM LMRelatedWebsites u join u.relatedWebsites_session pl where pl = :ses")
			.setParameter("ses", ses).list();		
		
		return list;
	}
	
	private List<Feedback> loadFB(Session ses) {
		
		List<Feedback> list =  getSessionFactory().getCurrentSession().
			createQuery("SELECT u FROM Feedback u join u.fB_session pl where pl = :ses")
			.setParameter("ses", ses).list();		
		
		return list;
	}
	
	private List<Vote> loadVote(Session ses) {
		
		List<Vote> list =  getSessionFactory().getCurrentSession().
			createQuery("SELECT u FROM Vote u join u.vote_session pl where pl = :ses")
			.setParameter("ses", ses).list();		
		
		return list;
	}
	
}

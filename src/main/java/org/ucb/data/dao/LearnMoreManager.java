package org.ucb.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.ucb.data.domain.LMRelatedWebinars;
import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.data.domain.LMRelatedpapers;

public class LearnMoreManager implements ILearnMoreManager{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public LMRelatedpapers getLMRelatedpapersByID(int LMPID) {
		
		return (LMRelatedpapers) getSessionFactory().getCurrentSession().get(LMRelatedpapers.class, LMPID);
	}

	@Override
	public LMRelatedpapers getLMRelatedpapersByName(String LMPName) {
		List<LMRelatedpapers> lMRelatedpapers = 
		getSessionFactory().getCurrentSession().createQuery("SELECT u FROM LMRelatedpapers u WHERE u.LMRelatedpapersName"
				+ " LIKE :name").setParameter("name", LMPName).list();
		if(!lMRelatedpapers.isEmpty())
			return lMRelatedpapers.get(0);
		return null;
	}

	@Override
	public LMRelatedpapers getLMRelatedpapersByAuthor(String LMPAuthor) {
		List<LMRelatedpapers> lMRelatedpapers = 
		getSessionFactory().getCurrentSession().createQuery("SELECT u FROM LMRelatedpapers u WHERE u.LMRelatedpapersAuthors"
				+ " LIKE :author").setParameter("author", LMPAuthor).list();
		if(!lMRelatedpapers.isEmpty())
			return lMRelatedpapers.get(0);
		return null;
	}

	@Override
	public void storeLMRelatedpapers(LMRelatedpapers LMP) {
		
		getSessionFactory().getCurrentSession().persist(LMP);
	}

	@Override
	public void updateLMRelatedpapers(LMRelatedpapers LMP) {
		
		getSessionFactory().getCurrentSession().update(LMP);
	}

	@Override
	public void deleteLMRelatedpapers(LMRelatedpapers LMP) {
		
		getSessionFactory().getCurrentSession().delete(LMP);
	}

	@Override
	public LMRelatedWebsites getLMRelatedWebsitesById(int LMWID) {
		
		return (LMRelatedWebsites) getSessionFactory().getCurrentSession().get(LMRelatedWebsites.class, LMWID);
	}

	@Override
	public LMRelatedWebsites getLMRelatedWebsitesByName(String LMWName) {
		List<LMRelatedWebsites> lMRelatedWebsites = 
		getSessionFactory().getCurrentSession().createQuery("SELECT u FROM LMRelatedWebsites u WHERE u.LMRelatedWebsitesName"
				+ " LIKE :LMWName").setParameter("LMWName", LMWName).list();
		if(!lMRelatedWebsites.isEmpty())
			return lMRelatedWebsites.get(0);
		return null;
	}

	@Override
	public void storeLMRelatedWebsites(LMRelatedWebsites LMW) {
		
		getSessionFactory().getCurrentSession().persist(LMW);
	}

	@Override
	public void updateLMRelatedWebsites(LMRelatedWebsites LMW) {
		
		getSessionFactory().getCurrentSession().update(LMW);
	}

	@Override
	public void deleteLMRelatedWebsites(LMRelatedWebsites LMW) {
		
		getSessionFactory().getCurrentSession().delete(LMW);
	}

	@Override
	public LMRelatedWebinars getLMRelatedWebinarsById(int LMRWID) {
		
		return (LMRelatedWebinars) getSessionFactory().getCurrentSession().get(LMRelatedWebinars.class, LMRWID);
	}

	@Override
	public LMRelatedWebinars getLMRelatedWebinarsByTopic(String LMRWTopic) {
		List<LMRelatedWebinars> lMRelatedWebinars = 
		getSessionFactory().getCurrentSession().createQuery("SELECT u FROM LMRelatedWebinars u WHERE u.LMRelatedWebinarsTopic"
				+ " LIKE :LMRWTopic").setParameter("LMRWTopic", LMRWTopic).list();
		if(!lMRelatedWebinars.isEmpty())
			return lMRelatedWebinars.get(0);
		return null;
	}

	@Override
	public void storeLMRelatedWebinars(LMRelatedWebinars LMRW) {
		
		getSessionFactory().getCurrentSession().persist(LMRW);
	}

	@Override
	public void updateLMRelatedWebinars(LMRelatedWebinars LMRW) {
		
		getSessionFactory().getCurrentSession().update(LMRW);
	}

	@Override
	public void deleteLMRelatedWebinars(LMRelatedWebinars LMRW) {
		
		getSessionFactory().getCurrentSession().delete(LMRW);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

package org.ucb.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.Category;
import org.ucb.data.domain.Domain_of_Contact;
import org.ucb.data.domain.Preferences;

@Repository
public class PreferenceManager implements IPreferenceManager{

	@Autowired
	SessionFactory sessionFactory;


	@Override
	public Preferences getPrefByID(int prefId) {
		
		Preferences pref = 
		(Preferences) getSessionFactory().getCurrentSession().get(Preferences.class, prefId);
		
		// loading the list fields casue of the lazy fetch
		pref.setPref_cat(loadCat(pref));
		pref.setPref_domain(loadDomain(pref));
		
		return pref;
	}

	@Override
	public void storePref(Preferences pref) {
		
		getSessionFactory().getCurrentSession().persist(pref);		
	}

	@Override
	public void updatePref(Preferences pref) {
		getSessionFactory().getCurrentSession().update(pref);
	}

	@Override
	public void deletePref(Preferences pref) {
		getSessionFactory().getCurrentSession().delete(pref);
	}	
	
	private List<Domain_of_Contact> loadDomain(Preferences Pref){

		return (List<Domain_of_Contact>) getSessionFactory().getCurrentSession().createQuery("SELECT u FROM Domain_of_Contact  u"
				+ " join u.domain_preferences pl where pl = :pref").setParameter("pref", Pref).list();
		// pref.getPref_domain();
	}
	
	private List<Category> loadCat(Preferences Pref){

		return (List<Category>) getSessionFactory().getCurrentSession().createQuery("SELECT u FROM Category u "
				+ " join u.cat_pref pl where pl = :pref").setParameter("pref", Pref).list();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}

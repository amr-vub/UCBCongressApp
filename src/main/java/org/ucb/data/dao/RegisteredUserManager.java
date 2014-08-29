package org.ucb.data.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.Category;
import org.ucb.data.domain.Domain_of_Contact;
import org.ucb.data.domain.HCP;
import org.ucb.data.domain.Login;
import org.ucb.data.domain.Preferences;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.services.identification.AnonymousUser;

@Repository("registeredUserManager")
public class RegisteredUserManager implements IRegisteredUserManager{

	@Autowired
	SessionFactory sessionFactory;
	
	public RegisteredHCP findUserById(int RegisteredHCP) {
		RegisteredHCP user = null;		
		List<RegisteredHCP> list = sessionFactory.getCurrentSession().createQuery("SELECT u FROM RegisteredHCP u WHERE u.HCPID = :HCPID").setParameter("HCPID", RegisteredHCP).list();
		if(!list.isEmpty())
			user =  (RegisteredHCP) list.get(0);
		
		return user;
	}

	public RegisteredHCP findRegisteredUserByEmail(String email) {
		RegisteredHCP user = null ;		
		List<HCP> list = sessionFactory.getCurrentSession().createQuery("SELECT u FROM RegisteredHCP u WHERE u.email = :email").setParameter("email", email).list();
		if(!list.isEmpty())
			user =  (RegisteredHCP) list.get(0);
		
		return user;
	}

	public RegisteredHCP storeUser(RegisteredHCP user) {

		getSessionFactory().getCurrentSession().persist(user);
		
		return user;
	}

	public int userExists(String username, String password) {
		
		List<Login> remp = sessionFactory.getCurrentSession().createQuery("SELECT u FROM Login u WHERE u.username LIKE :username AND u.password LIKE :password").setParameter("username", username).
				setParameter("password", password).list();
		if(remp != null){
			return remp.get(0).getLogin_regHCP().getHCPID();
		}

		return -1;
	}
	
	public boolean isRegistered(int registeredID) {
		
		List<RegisteredHCP> remp = sessionFactory.getCurrentSession().createQuery("SELECT u FROM RegisteredHCP u WHERE u.HCPID = :registeredID").setParameter("registeredID", registeredID).list();
		if(!remp.isEmpty())
			return remp.get(0).isRegesteredStatus();
		
		return false;
	}

	public RegisteredHCP updateRegisteredUser(RegisteredHCP registeredUser) {
		
		getSessionFactory().getCurrentSession().merge(registeredUser);
		
		return registeredUser;
	}

	public void deleteRegisteredsUser(RegisteredHCP registeredUser) {
		
		getSessionFactory().openSession().delete(registeredUser);
		
	}

	public Preferences loadPref(Preferences PrefId){
		Preferences pref = 
				(Preferences) getSessionFactory().getCurrentSession().createQuery("SELECT u FROM Preferences u "
		+ "WHERE u.PrefID = :PrefID").setParameter("PrefID", PrefId.getPrefID()).list().get(0);		
		return pref;
	}

	public List<Domain_of_Contact> loadDomain(Preferences Pref){

		return (List<Domain_of_Contact>) getSessionFactory().getCurrentSession().createQuery("SELECT u FROM Domain_of_Contact  u WHERE"
				+ " u.domain_preferences = :prefID").setParameter("prefID", Pref).list();
		// pref.getPref_domain();
	}
	
	public List<Category> loadCat(Preferences Pref){

		return (List<Category>) getSessionFactory().getCurrentSession().createQuery("SELECT u FROM Category u WHERE"
				+ " u.cat_pref = :prefID").setParameter("prefID", Pref).list();
		//return pref.getPref_cat();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
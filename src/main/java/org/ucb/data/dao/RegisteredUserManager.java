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
		RegisteredHCP user = 
				(RegisteredHCP) sessionFactory.getCurrentSession().get(RegisteredHCP.class, RegisteredHCP);
		
		return user;
	}

	public RegisteredHCP findRegisteredUserByEmail(String email) {
		RegisteredHCP user = null ;		
		List<HCP> list = sessionFactory.getCurrentSession().createQuery("SELECT u FROM RegisteredHCP u WHERE u.email LIKE :email").setParameter("email", email).list();
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
			return remp.get(0).getLogin_regHCP().getHcpID();
		}

		return -1;
	}
	
	public boolean isRegistered(int registeredID) {
		
		List<RegisteredHCP> remp = sessionFactory.getCurrentSession().createQuery("SELECT u FROM RegisteredHCP u WHERE u.hcpID = :registeredID").setParameter("registeredID", registeredID).list();
		if(!remp.isEmpty())
			return remp.get(0).isRegesteredStatus();
		
		return false;
	}

	public RegisteredHCP updateRegisteredUser(RegisteredHCP registeredUser) {
		
		getSessionFactory().getCurrentSession().merge(registeredUser);
		
		return registeredUser;
	}

	public void deleteRegisteredsUser(RegisteredHCP registeredUser) {
		
		getSessionFactory().getCurrentSession().delete(registeredUser);
		
	}

	public Preferences loadPref(Preferences PrefId){
		Preferences pref = 
				(Preferences) getSessionFactory().getCurrentSession().createQuery("SELECT u FROM Preferences u "
		+ "WHERE u.PrefID = :PrefID").setParameter("PrefID", PrefId.getPrefID()).list().get(0);		
		return pref;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
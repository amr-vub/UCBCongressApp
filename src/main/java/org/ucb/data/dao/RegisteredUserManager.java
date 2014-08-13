package org.ucb.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.HCP;
import org.ucb.data.domain.RegisteredHCP;

@Repository("registeredUserManager")
public class RegisteredUserManager implements IRegisteredUserManager{

	@Autowired
	SessionFactory sessionFactory;
	
	public RegisteredHCP findRegisteredUserById(int HCPID) {
		RegisteredHCP user = null ;		
		List<HCP> list = sessionFactory.getCurrentSession().createQuery("SELECT u FROM RegisteredHCP u WHERE u.HCPID = :HCPID").setParameter("HCPID", HCPID).list();
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

	public RegisteredHCP storeRegisteredUser(RegisteredHCP user) {

		getSessionFactory().getCurrentSession().persist(user);
		
		return user;
	}

	public boolean registeredUserExists(int registeredID) {
		boolean isUser ;
		List remp = sessionFactory.getCurrentSession().createQuery("SELECT u FROM HCP u WHERE u.registeredID = :registeredID").setParameter("registeredID", registeredID).list();
		isUser = remp.isEmpty() ? false:true ;
		return isUser;
	}

	public RegisteredHCP updateRegisteredUser(RegisteredHCP registeredUser) {
		
		getSessionFactory().getCurrentSession().merge(registeredUser);
		
		return registeredUser;
	}

	public void deleteRegisteredsUser(RegisteredHCP registeredUser) {
		
		getSessionFactory().openSession().delete(registeredUser);
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}

package org.ucb.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.HCP;

@Repository("anonymousUserManager")
public class AnonymousUserManager implements IAnonymousUserManager {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public HCP findAnonymousUserById(int anonymousID) {
		HCP user = null ;		
		List<HCP> list = sessionFactory.getCurrentSession().createQuery("SELECT u FROM HCP u WHERE u.HCPID = :anonymousID").setParameter("anonymousID", anonymousID).list();
		if(!list.isEmpty())
			user =  (HCP) list.get(0);		
		return user;
	}
	
	public HCP storeAnonymousUser(HCP user) {
		
		getSessionFactory().getCurrentSession().save(user);
		
		return user;
	}

	public boolean anonymousUserExists(int anonymousID) {
		boolean isUser ;
		List remp = sessionFactory.getCurrentSession().createQuery("SELECT u FROM HCP u WHERE u.HCPID = :anonymousID").setParameter("anonymousID", anonymousID).list();
		isUser = remp.isEmpty() ? false:true ;
		return isUser;
	}
	

	public HCP updateAnonymousUser(HCP anonymousUser) {
		
		getSessionFactory().getCurrentSession().update(anonymousUser);
		
		return anonymousUser;
	}

	public void deleteAnonymousUser(HCP anonymousUser) {
		
		//HCP utemp = findAnonymousUserById(anonymousUser.getHCPID());
		
		getSessionFactory().getCurrentSession().delete(anonymousUser);

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

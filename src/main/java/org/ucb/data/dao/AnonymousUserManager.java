package org.ucb.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.HCP;

@Repository("anonymousUserManager")
public class AnonymousUserManager implements IAnonymousUserManager {
	
	@Autowired
	SessionFactory sessionFactory;
	
	//@PersistenceContext
	//EntityManager em;
	
	public HCP findAnonymousUserById(int anonymousID) {
		HCP user = null ;		
		List<HCP> list = sessionFactory.getCurrentSession().createQuery("SELECT u FROM HCP u WHERE u.hcpID = :anonymousID").setParameter("anonymousID", anonymousID).list();
				//em.createQuery("SELECT u FROM HCP u WHERE u.HCPID = :anonymousID").setParameter("anonymousID", anonymousID).getResultList();
		if(!list.isEmpty())
			user =  (HCP) list.get(0);		
		return user;
	}
	
	public HCP storeAnonymousUser(HCP user) {
		
		//em.persist(user);
		getSessionFactory().getCurrentSession().save(user);
		
		return user;
	}

	public boolean anonymousUserExists(int anonymousID) {
		boolean isUser ;
		List remp = sessionFactory.getCurrentSession().createQuery("SELECT u FROM HCP u WHERE u.hcpID = :anonymousID").setParameter("anonymousID", anonymousID).list();
		isUser = remp.isEmpty() ? false:true ;
		return isUser;
	}
	

	public HCP updateAnonymousUser(HCP anonymousUser) {
		
		getSessionFactory().getCurrentSession().update(anonymousUser);
		
		return anonymousUser;
	}

	public void deleteAnonymousUser(HCP anonymousUser) {
		
		//HCP utemp = findAnonymousUserById(anonymousUser.getHCPID());
		//anonymousUser = em.merge(anonymousUser);
		//em.remove(anonymousUser);
		
		getSessionFactory().getCurrentSession().delete(anonymousUser);

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void update_No_Sent_Invitation(int anonymousUserID, int inv) {
		HCP user = null;
		
		Session s = getSessionFactory().getCurrentSession();
		
		List<HCP> list = s.createQuery("SELECT u FROM HCP u WHERE u.hcpID = :anonymousID")
		.setParameter("anonymousID", anonymousUserID).list();
		
		if(!list.isEmpty())
		{
			user =  (HCP) list.get(0);	
			user.setNo_Sent_Invitation(inv);
			s.merge(user);
		}		
		
	}

}

package org.ucb.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.Access_Code_Dir;

@Repository("accessCodeManager")
public class AccessCodeManager implements IAccessCodeManager{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean accessCodeExists(int AccessCode) {
		
		List<Access_Code_Dir> accessCodeList = sessionFactory.getCurrentSession().createQuery("SELECT u FROM Access_Code_Dir u WHERE u.accessCode = :accessCode").setParameter("accessCode", AccessCode).list();
		if(!accessCodeList.isEmpty())
			return true;
		return false;
	}

	public void insertAccessCode(Access_Code_Dir access_Code_Dir) {

		sessionFactory.getCurrentSession().persist(access_Code_Dir);
	}
	
	

}

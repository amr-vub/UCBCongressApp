package org.ucb.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
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

	public void insertAccessCode(int access_Code) {

		Access_Code_Dir tmp = new Access_Code_Dir();
		tmp.setAccessCode(access_Code);
		sessionFactory.getCurrentSession().persist(tmp);
	}
	
	

}

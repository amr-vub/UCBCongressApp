package org.ucb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ucb.data.dao.IAnonymousUserManager;
import org.ucb.data.domain.HCP;

@Service("anonymousUserServiceStub")
@Transactional(propagation=Propagation.REQUIRED)
@ComponentScan
public class AnonymousUserServiceStub implements IAnonymousUserServiceStub {

	@Autowired
	IAnonymousUserManager iAnonymousUserManager;
	
	@Transactional
	public void deleteAnonymousUser(HCP anonymousUser) {
		// TODO Auto-generated method stub
		iAnonymousUserManager.deleteAnonymousUser(anonymousUser);
	}
   @Transactional
	public HCP storeAnonymousUser(HCP anonymousUser) {
		// TODO Auto-generated method stub
		return iAnonymousUserManager.storeAnonymousUser(anonymousUser);
	}
	@Transactional
	public HCP getHCPbyID(int ID) {
		// TODO Auto-generated method stub
		
		return iAnonymousUserManager.findAnonymousUserById(ID);
	}

}

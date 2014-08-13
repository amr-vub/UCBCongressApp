package org.ucb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ucb.data.dao.IAnonymousUserManager;
import org.ucb.data.domain.HCP;

@Service("serviceStub")
@Transactional(propagation=Propagation.REQUIRED)
public class ServiceStub implements IServiceStub {

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

}

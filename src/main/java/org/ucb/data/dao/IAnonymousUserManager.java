package org.ucb.data.dao;

import org.ucb.data.domain.HCP;


public interface IAnonymousUserManager {

	public HCP findAnonymousUserById(int anonymousID);
	
	public HCP storeAnonymousUser(HCP user);

	public boolean anonymousUserExists(int anonymousID);

	public HCP updateAnonymousUser(HCP anonymousUser);
	
	public void deleteAnonymousUser(HCP anonymousUser);
	
	public void update_No_Sent_Invitation(int anonymousUserID, int inv);
	
}

package org.ucb.data.dao;

import org.ucb.data.domain.Feedback;


public interface IFeedbackManager {

	public Feedback getFBById(int FBId);
	
	public void updateFB(Feedback FB);
	
	public void storeFB(Feedback FB);
	
	public void deleteFB(Feedback FB);
}

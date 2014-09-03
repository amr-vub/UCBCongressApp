package org.ucb.data.dao;

import org.ucb.data.domain.*;

public interface IFeedbackManager {

	public Feedback getFeedbackById(int feedbackID);

	public void updateFeedback(Feedback feedback);
	
	public void storeFeedback(Feedback feedback);

	public void deleteFeedback(Feedback feedback);
}

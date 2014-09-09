package org.ucb.services.feedback;

import org.ucb.service.model.FeedbackObject;

public interface IFeedbackService {

	/**
	 * Gets a feedback question within a session based on its index.
	 * @param feedback - an object of type FeedbackObject. Set the 'feedbackIndex' attribute 
	 *                   in order to fetch a question from the list.
	 * @return an object of type FeedbackObject. The retrieved question can be found in the 
	 *         'feedbackQuestion' attribute.
	 */
	public FeedbackObject getFeedbackQuestions(FeedbackObject feedback);
	
	/**
	 * [Back-end] Inserts a question within a session's feedback list.
	 * @param feedbackObject - an object of type FeedbackObject. Set the 'fbQuestion' attribute
	 *                         with the question to be inserted.
	 * @return true - if the question has been successfully inserted.
	 * @return false - if the question insertion has failed.
	 */
	public boolean storeFeedbackQuestion(FeedbackObject feedbackObject);
	
	/**
	 * Inserts a response for a particular question.
	 * @param feedbackObject - an object of type FeedbackObject. Set the 'feedbackIndex' attribute
	 *                         and the 'feedbackAnswer' with the desired response.
	 * @return true - whether the response has been successfully inserted.
	 * @return false - whether the response insertion has failed.
	 */
	public boolean giveFeedbackResponse(FeedbackObject feedbackObject);
	
	/**
	 * [Back-end] Retrieves all the saved results for a specific feedback question.
	 * @param feedbackObject - an object of type FeedbackObject. Set the 'feedbackIndex' attribute
	 *                         for the question from which the responses should be fetched.
	 * @return an object of type FeedbackObject. The retrieved results can be found in the 
	 *         'feedbackResults' attribute.
	 */
	public FeedbackObject getFeedbackResults(FeedbackObject feedbackObject);
}

package org.ucb.services.questions;

import org.ucb.service.model.QuestionObject;

public interface IQuestionService {

	/**
	 * Inserts a question into the session's list of questions.
	 * @param questionObject - a QuestionObject instance. Set the 'askedQuestion' attribute
	 *                         with the new question.
	 * @return true - if the question has been successfully inserted.
	 * @return false - if the question insertion failed.
	 */
	public boolean askQuestion(QuestionObject questionObject);
	
	/**
	 * [Back-end] Retrieves the list of questions which have been asked during a specific session.
	 * @param questionObject - a QuestionObject instance. Set only the 'sessionID' attribute 
	 *                         in order to be able to get the list of questions.
	 * @return a QuestionObject instance. The list of questions can be found in the 'storedQuestions'
	 *         attribute.
	 */
	public QuestionObject getAskedQuestions(QuestionObject questionObject);
}

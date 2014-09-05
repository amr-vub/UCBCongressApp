package org.ucb.data.dao;

import org.ucb.data.domain.Questions;


public interface IQuestionManger {

	public Questions getQsById(int QsId);	
	
	public void storeQs(Questions Qs);
	
	public void updateQs(Questions Qs);
	
	public void deleteQs(Questions Qs);
}

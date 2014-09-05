package org.ucb.data.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.Questions;

@Repository
public class QuestionManger implements IQuestionManger{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Questions getQsById(int QsId) {
		
		getSessionFactory().getCurrentSession().get(Questions.class, QsId);
		
		return null;
	}

	@Override
	public void storeQs(Questions Qs) {
		getSessionFactory().getCurrentSession().persist(Qs);		
	}

	@Override
	public void updateQs(Questions Qs) {
		getSessionFactory().getCurrentSession().update(Qs);				
	}

	@Override
	public void deleteQs(Questions Qs) {
		getSessionFactory().getCurrentSession().delete(Qs);		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}

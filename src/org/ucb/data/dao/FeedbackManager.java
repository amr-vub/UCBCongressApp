package org.ucb.data.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.Feedback;

public class FeedbackManager implements IFeedbackManager {

		@Autowired
		SessionFactory sessionFactory;
		
		@Override
		public Feedback getFeedbackById(int feedbackId) {
			
			return (Feedback) getSessionFactory().getCurrentSession().get(Feedback.class, feedbackId);
		}

		@Override
		public void updateFeedback(Feedback feedback) {
			
			getSessionFactory().getCurrentSession().update(feedback);
		}

		@Override
		public void storeFeedback(Feedback feedback) {
			
			getSessionFactory().getCurrentSession().persist(feedback);
		}

		@Override
		public void deleteFeedback(Feedback feedback){
			
			getSessionFactory().getCurrentSession().delete(feedback);
		}

		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

}

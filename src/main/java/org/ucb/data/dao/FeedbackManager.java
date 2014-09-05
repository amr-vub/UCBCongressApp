package org.ucb.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.Feedback;
import org.ucb.data.domain.FeedbackAnswer;
import org.ucb.data.domain.Vote;
import org.ucb.data.domain.VoteChoices;

@Repository
public class FeedbackManager implements IFeedbackManager{

	@Autowired	
	SessionFactory sessionFactory;
	
	@Override
	public Feedback getFBById(int FBId) {
		Feedback fb = (Feedback) getSessionFactory().getCurrentSession().get(Feedback.class, FBId);
		
		fb.setFb_fbAnswer(loadFb(fb));
		
		return fb;
	}

	@Override
	public void updateFB(Feedback FB) {
		
		getSessionFactory().getCurrentSession().update(FB);
		
	}

	@Override
	public void storeFB(Feedback FB) {
		
		getSessionFactory().getCurrentSession().persist(FB);
	}

	@Override
	public void deleteFB(Feedback FB) {
		
		getSessionFactory().getCurrentSession().delete(FB);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private List<FeedbackAnswer> loadFb(Feedback fb) {
		
		List<FeedbackAnswer> list = getSessionFactory().getCurrentSession().
			createQuery("SELECT u FROM FeedbackAnswer u join u.fbAnswer_fb pl where pl = :fb")
			.setParameter("fb", fb).list();		
		
		return list;
	}
}

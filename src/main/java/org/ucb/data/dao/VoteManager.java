package org.ucb.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.Vote;
import org.ucb.data.domain.VoteChoices;

@Repository
public class VoteManager implements IVoteManager{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Vote getVoteById(int voteId) {
		
		Vote vote =  (Vote) getSessionFactory().getCurrentSession().get(Vote.class, voteId);
		
		vote.setVoteChoices(loadVote(vote));
		
		return vote;
	}

	@Override
	public void updateVote(Vote vote) {
		
		getSessionFactory().getCurrentSession().update(vote);
	}

	@Override
	public void storeVote(Vote vote) {
		
		getSessionFactory().getCurrentSession().persist(vote);
	}

	@Override
	public void deleteVote(Vote vote) {
		
		getSessionFactory().getCurrentSession().delete(vote);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private List<VoteChoices> loadVote(Vote vote) {
		
		List<VoteChoices> list = getSessionFactory().getCurrentSession().
			createQuery("SELECT u FROM VoteChoices u join u.choiceVote pl where pl = :vote")
			.setParameter("vote", vote).list();		
		
		return list;
	}
}

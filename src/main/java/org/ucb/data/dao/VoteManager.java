package org.ucb.data.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucb.data.domain.Vote;

@Repository
public class VoteManager implements IVoteManager{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Vote getVoteById(int voteId) {
		
		return (Vote) getSessionFactory().getCurrentSession().get(Vote.class, voteId);
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

}

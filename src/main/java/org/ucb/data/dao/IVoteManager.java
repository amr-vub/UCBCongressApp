package org.ucb.data.dao;

import org.ucb.data.domain.Vote;

public interface IVoteManager {

	public Vote getVoteById(int voteId);
	
	public void updateVote(Vote vote);
	
	public void storeVote(Vote vote);
	
	public void deleteVote(Vote vote);
}

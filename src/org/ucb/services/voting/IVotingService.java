package org.ucb.services.voting;

import org.ucb.data.domain.Session;
import org.ucb.service.model.VotingSession;

public interface IVotingService {
	
	public boolean vote(VotingSession votingSession);
	
	public int getVoteAverage(VotingSession votingSession);
}

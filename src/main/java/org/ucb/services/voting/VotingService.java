package org.ucb.services.voting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ucb.data.dao.IRegisteredUserManager;
import org.ucb.data.dao.ISessionManager;
import org.ucb.data.dao.IVoteManager;
import org.ucb.data.domain.Session;
import org.ucb.data.domain.Vote;
import org.ucb.data.domain.VoteChoices;
import org.ucb.data.domain.Vote_value;
import org.ucb.service.model.VotingSession;

@Service
public class VotingService implements IVotingService {

	@Autowired
	private ISessionManager sessionManager;
	
	@Autowired 
	IVoteManager voteManager;
	
	/**
	 * This method is used by the front-end to perform the vote of one user within a session.
	 * @param votingSession - an object containing the session, the vote and the vote choice
	 * 
	 * @return true - whether the session really exists and the vote has been registered
	 * @return false - whether the session ID is invalid
	 */
	@Transactional
	public boolean vote(VotingSession votingSession)
	{
		Session currentSession = null;
		int voteID = votingSession.getVoteID();
		Vote vote = null;
		Vote_value voteValue = null;
		
		
		List<Vote> voteList = null;
		
		currentSession = sessionManager.getSessionById(votingSession.getVotingSession().getSessionID());
		
		if(null != currentSession)
		{			
			vote = voteManager.getVoteById(voteID);
			voteValue = votingSession.getVoteValue();
			
			// Add the vote value to the list of choices within the vote
			vote.getVote_vValue().add(voteValue);
			
			// Get the list of votes and modify one vote
			voteList = currentSession.getSession_vote();
			voteList.add(vote);
			
			// Update the list of votes within the session
			currentSession.setSession_vote(voteList);
			
			// Update the DB
			//voteManager.updateVote(vote);
			sessionManager.updateSession(currentSession);
			
			return true;
		}		
		return false;
	}
	
	/**
	 * This method is used by the back-end to fetch the average of votes from a session.
	 * 
	 * @param votingSession - an object containing the session, the vote and the vote choice
	 * 
	 * @return an integer value representing the average of votes.
	 */
	@Transactional
	public int getVoteAverage(VotingSession votingSession)
	{
		Session currentSession = null;
		int voteID = votingSession.getVoteID();
		int average = 0;
		int voteCount = 0;
		Vote vote = null;
		
		currentSession = sessionManager.getSessionById(votingSession.getVotingSession().getSessionID());
		
		if(null != currentSession)
		{			
			vote = voteManager.getVoteById(voteID);
						
			for(Vote_value voteValue : vote.getVote_vValue())
			{
				average += voteValue.getVoteValue();
				voteCount++;
			}
			
			average /= voteCount;
			
			return average;
		}
		
		return 0;
	}
}

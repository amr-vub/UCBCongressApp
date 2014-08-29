package org.ucb.services.voting;

import org.springframework.stereotype.Service;
import org.ucb.data.domain.Session;
import org.ucb.data.domain.Vote;
import org.ucb.data.domain.VoteChoices;

@Service
public class Election {
	
	private Vote vote;
	private VoteChoices votechoices;
	private Session session;
	
	private String voteQuestion;
	
	public void setVoteQuestion(String voteQuestion)
	{
		vote.setVoteQuestion(voteQuestion);
	}
	
	public String getVoteQuestion()
	{
		return vote.getVoteQuestion();
	}
	
	public void setVoteSession(Session session)
	{
		vote.setVote_session(session);
	}
	
	public Session getVoteSession()
	{
		return vote.getVote_session();
	}
	
	public void setVoteResult(int chosenVoteChoice)
	{
		vote.setVoteResult(chosenVoteChoice);
	}
	
	public int getVoteResult()
	{
		return vote.getVoteResult();
	}

	
	public void setVoteChoices(String choices)
	{
		votechoices.setChoices(choices);
	}
	
	public String getVoteChoices()
	{
		return votechoices.getChoices();
	}
}

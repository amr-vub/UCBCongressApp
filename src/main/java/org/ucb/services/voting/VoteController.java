package org.ucb.services.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ucb.data.domain.Session;
import org.ucb.service.model.VotingSession;

@RestController
public class VoteController {

	@Autowired
	IVotingService iVotingService;
	
	@RequestMapping(value="/vote" , method = RequestMethod.POST)
	public boolean vote(@RequestBody VotingSession votingSession)
	{
			
			boolean returnValue;
			
			// Call the voting service 
			returnValue = iVotingService.vote(votingSession);
			
			return returnValue;
	}
	
	@RequestMapping(value="/getVoteAverage", method = RequestMethod.POST)
	public int getVoteAverage(VotingSession votingSession)
	{
		int returnValue;
		
		//Call the voting service
		returnValue = iVotingService.getVoteAverage(votingSession);
		
		return returnValue;
	}
}

package org.ucb.services.learnmore;

import java.util.List;

import org.hibernate.loader.plan.exec.spi.LockModeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ucb.data.dao.ILearnMoreManager;
import org.ucb.data.dao.ISessionManager;
import org.ucb.data.domain.LMRelatedWebinars;
import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.data.domain.LMRelatedpapers;
import org.ucb.data.domain.LearmMore;
import org.ucb.data.domain.Session;
import org.ucb.service.model.LearnMoreObject;

@Service
public class LearnMoreService implements ILearnMoreService {

	@Autowired
	private ILearnMoreManager learnMoreManager;
	
	@Autowired
	private ISessionManager sessionManager;
	
	public void addLearnMorePaper(LearnMoreObject lmPaper)
	{
		LMRelatedpapers lmRelatedPaper = (LMRelatedpapers) lmPaper.getLearnMore();
		int sessionID = 0;
		
		sessionID = lmPaper.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);
		
		List<LMRelatedpapers> listPapers;
		
		if(null != session)
		{
			listPapers = session.getSession_Relatedpapers();
			
			if(!listPapers.contains(lmRelatedPaper))
			{
				listPapers.add(lmRelatedPaper);
							
				session.setSession_Relatedpapers(listPapers);
				
				learnMoreManager.storeLMRelatedpapers(lmRelatedPaper);
			}
			else
			{
				learnMoreManager.updateLMRelatedpapers(lmRelatedPaper);
			}
		}
	}
	
	public void addLearnMoreWebinar(LearnMoreObject lmWebinar)
	{
		LMRelatedWebinars lmRelatedWebinar = (LMRelatedWebinars) lmWebinar.getLearnMore();
		int sessionID = 0;
		
		sessionID = lmWebinar.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);
		
		List<LMRelatedWebinars> listWebinars;
		
		if(null != session)
		{
			listWebinars = session.getSession_RelatedWebinars();
			
			if(!listWebinars.contains(lmRelatedWebinar))
			{
				listWebinars.add(lmRelatedWebinar);
							
				session.setSession_RelatedWebinars(listWebinars);
				
				learnMoreManager.storeLMRelatedWebinars(lmRelatedWebinar);
			}
			else
			{
				learnMoreManager.updateLMRelatedWebinars(lmRelatedWebinar);
			}
		}
	}
	
	public void addLearnMoreWebsite(LearnMoreObject lmWebsite)
	{
		LMRelatedWebsites lmRelatedWebsite = (LMRelatedWebsites) lmWebsite.getLearnMore();
		int sessionID = 0;
		
		sessionID = lmWebsite.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);
		
		List<LMRelatedWebsites> listWebsites;
		
		if(null != session)
		{
			listWebsites = session.getSession_RelatedWebsites();
			
			if(!listWebsites.contains(lmRelatedWebsite))
			{
				listWebsites.add(lmRelatedWebsite);
							
				session.setSession_RelatedWebsites(listWebsites);
				
				learnMoreManager.storeLMRelatedWebsites(lmRelatedWebsite);
			}
			else
			{
				learnMoreManager.updateLMRelatedWebsites(lmRelatedWebsite);
			}
		}
	}
	
	public LearnMoreObject getLearnMorePaper(LearnMoreObject lmObject)
	{
		LearnMoreObject learnMoreObject = new LearnMoreObject();
		
		LMRelatedpapers learnMorePaper = null;
		
		int lmID = ((LMRelatedpapers)lmObject.getLearnMore()).getLMRelatedpapersID();
		
		String lmName = ((LMRelatedpapers)lmObject.getLearnMore()).getLMRelatedpapersName();
		
		String lmAuthor = ((LMRelatedpapers)lmObject.getLearnMore()).getLMRelatedpapersAuthors();
		
		if(0 != lmID)
		{
			learnMorePaper = learnMoreManager.getLMRelatedpapersByID(lmID);
		}
		else
		{
			if(null != lmName)
			{
				learnMorePaper = learnMoreManager.getLMRelatedpapersByName(lmName);
			}
			else
			{
				if(null != lmAuthor)
				{
					learnMorePaper = learnMoreManager.getLMRelatedpapersByAuthor(lmAuthor);
				}
			}
		}
		
		learnMoreObject.setLearnMore(learnMorePaper);
		
		return learnMoreObject;
	}
	
	public LearnMoreObject getLearnMoreWebsite(LearnMoreObject lmObject)
	{
		LearnMoreObject learnMoreObject = new LearnMoreObject();
		
		LMRelatedWebsites learnMoreWebsite = null;
		
		int lmID = ((LMRelatedWebsites)lmObject.getLearnMore()).getLMRelatedWebsitesID();
		
		String lmName = ((LMRelatedWebsites)lmObject.getLearnMore()).getLMRelatedWebsitesName();
		
		if(0 != lmID)
		{
			learnMoreWebsite = learnMoreManager.getLMRelatedWebsitesById(lmID);
		}
		else
		{
			if(null != lmName)
			{
				learnMoreWebsite = learnMoreManager.getLMRelatedWebsitesByName(lmName);
			}			
		}
		
		learnMoreObject.setLearnMore(learnMoreWebsite);
		
		return learnMoreObject;
	}
	
	public LearnMoreObject getLearnMoreWebinar(LearnMoreObject lmObject)
	{
		LearnMoreObject learnMoreObject = new LearnMoreObject();
		
		LMRelatedWebinars learnMoreWebinar = null;
		
		int lmID = ((LMRelatedWebinars)lmObject.getLearnMore()).getLMRelatedWebinarsID();
		
		String lmTopic = ((LMRelatedWebinars)lmObject.getLearnMore()).getLMRelatedWebinarsTopic();
		
		if(0 != lmID)
		{
			learnMoreWebinar = learnMoreManager.getLMRelatedWebinarsById(lmID);
		}
		else
		{
			if(null != lmTopic)
			{
				learnMoreWebinar = learnMoreManager.getLMRelatedWebinarsByTopic(lmTopic);
			}			
		}
		
		learnMoreObject.setLearnMore(learnMoreWebinar);
		
		return learnMoreObject;
	}
	
	public int deleteLearnMorePaper(LearnMoreObject lmPaper)
	{
		int returnValue = -1;
		
		LMRelatedpapers learnMorePaper = null;
		
		learnMorePaper = (LMRelatedpapers)lmPaper.getLearnMore();
		
		if(null != learnMorePaper)
		{
			learnMoreManager.deleteLMRelatedpapers(learnMorePaper);
			returnValue = 0;
		}
		
		return returnValue;
	}
	
	public int deleteLearnMoreWebsite(LearnMoreObject lmWebsite)
	{
		int returnValue = -1;
		
		LMRelatedWebsites learnMoreWebsite = null;
		
		learnMoreWebsite = (LMRelatedWebsites)lmWebsite.getLearnMore();
		
		if(null != learnMoreWebsite)
		{
			learnMoreManager.deleteLMRelatedWebsites(learnMoreWebsite);
			returnValue = 0;
		}
		
		return returnValue;
	}
	
	public int deleteLearnMoreWebinar(LearnMoreObject lmWebinar)
	{
		int returnValue = -1;
		
		LMRelatedWebinars learnMoreWebinar = null;
		
		learnMoreWebinar = (LMRelatedWebinars)lmWebinar.getLearnMore();
		
		if(null != learnMoreWebinar)
		{
			learnMoreManager.deleteLMRelatedWebinars(learnMoreWebinar);
			returnValue = 0;
		}
		
		return returnValue;
	}
}

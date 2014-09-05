package org.ucb.services.learnmore;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.loader.plan.exec.spi.LockModeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

	@Transactional
	public void addLearnMorePaper(LearnMoreObject lmPaper) {
		LMRelatedpapers lmRelatedPaper = (LMRelatedpapers) lmPaper
				.getLearnMore();
		int sessionID = 0;

		sessionID = lmPaper.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);

		List<LMRelatedpapers> listPapers;

		if (null != session) {
			listPapers = session.getSession_Relatedpapers();

			if (!listPapers.contains(lmRelatedPaper)) {
				listPapers.add(lmRelatedPaper);

				session.setSession_Relatedpapers(listPapers);

				// learnMoreManager.storeLMRelatedpapers(lmRelatedPaper);
			}
			sessionManager.updateSession(session);
		}
	}

	@Transactional
	public void addLearnMoreWebinar(LearnMoreObject lmWebinar) {
		LMRelatedWebinars lmRelatedWebinar = (LMRelatedWebinars) lmWebinar
				.getLearnMore();
		int sessionID = 0;

		sessionID = lmWebinar.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);

		List<LMRelatedWebinars> listWebinars;

		if (null != session) {
			listWebinars = session.getSession_RelatedWebinars();

			if (!listWebinars.contains(lmRelatedWebinar)) {
				listWebinars.add(lmRelatedWebinar);

				session.setSession_RelatedWebinars(listWebinars);

				// learnMoreManager.storeLMRelatedWebinars(lmRelatedWebinar);
			}
			sessionManager.updateSession(session);
		}
	}

	@Transactional
	public void addLearnMoreWebsite(LearnMoreObject lmWebsite) {
		LMRelatedWebsites lmRelatedWebsite = (LMRelatedWebsites) lmWebsite
				.getLearnMore();
		int sessionID = 0;

		sessionID = lmWebsite.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);

		List<LMRelatedWebsites> listWebsites;

		if (null != session) {
			listWebsites = session.getSession_RelatedWebsites();

			if (!listWebsites.contains(lmRelatedWebsite)) {
				listWebsites.add(lmRelatedWebsite);

				session.setSession_RelatedWebsites(listWebsites);

				// learnMoreManager.storeLMRelatedWebsites(lmRelatedWebsite);
			}
			sessionManager.updateSession(session);
		}
	}

	@Transactional
	public LearnMoreObject getLearnMorePaper(LearnMoreObject lmObject) {
		LearnMoreObject learnMoreObject = new LearnMoreObject();

		LMRelatedpapers learnMorePaper = null;

		int lmID = ((LMRelatedpapers) lmObject.getLearnMore())
				.getLMRelatedpapersID();

		String lmName = ((LMRelatedpapers) lmObject.getLearnMore())
				.getLMRelatedpapersName();

		String lmAuthor = ((LMRelatedpapers) lmObject.getLearnMore())
				.getLMRelatedpapersAuthors();

		int sessionID = lmObject.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);
		List<LMRelatedpapers> listPapers;

		if (null != session) {
			
			listPapers = session.getSession_Relatedpapers();
			
				for(LMRelatedpapers lmPaper : listPapers)
				{
					if(lmPaper.getLMRelatedpapersID() == lmID)
					{
						learnMorePaper = lmPaper;
						break;
					}
					else
					{
						if(lmPaper.getLMRelatedpapersName() == lmName)
						{
							learnMorePaper = lmPaper;
							break;
						}
						else
						{
							if(lmPaper.getLMRelatedpapersAuthors() == lmAuthor)
							{
								learnMorePaper = lmPaper;
								break;
							}
						}
					}
				}			
			}

		learnMoreObject.setLearnMore(learnMorePaper);		
		return learnMoreObject;
	}

	@Transactional
	public LearnMoreObject getLearnMoreWebsite(LearnMoreObject lmObject) {
		LearnMoreObject learnMoreObject = new LearnMoreObject();

		LMRelatedWebsites learnMoreWebsite = null;

//		int lmID = ((LMRelatedWebsites) lmObject.getLearnMore())
//				.getLMRelatedWebsitesID();
//
//		String lmName = ((LMRelatedWebsites) lmObject.getLearnMore())
//				.getLMRelatedWebsitesName();
		
		int sessionID = lmObject.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);
		ArrayList<LMRelatedWebsites> listWebsites;
		
		if(null != session)
		{
			listWebsites = sessionManager.loadLMRelatedWebsites(session);//session.getSession_RelatedWebsites();
			
//			for(LMRelatedWebsites lmWebsite : listWebsites)
//			{
//				if(lmWebsite.getLMRelatedWebsitesID() == lmID)
//				{
//					learnMoreWebsite = lmWebsite;
//					break;
//				}
//				else
//				{
//					if(lmWebsite.getLMRelatedWebsitesName() == lmName)
//					{
//						learnMoreWebsite = lmWebsite;
//						break;
//					}
//				}
//			}
			learnMoreObject.setLearnMoreOutput(listWebsites);
		}

		

		return learnMoreObject;
	}

	@Transactional
	public LearnMoreObject getLearnMoreWebinar(LearnMoreObject lmObject) {
		LearnMoreObject learnMoreObject = new LearnMoreObject();

		LMRelatedWebinars learnMoreWebinar = null;

		int lmID = ((LMRelatedWebinars) lmObject.getLearnMore())
				.getLMRelatedWebinarsID();

		String lmTopic = ((LMRelatedWebinars) lmObject.getLearnMore())
				.getLMRelatedWebinarsTopic();
		
		int sessionID = lmObject.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);
		List<LMRelatedWebinars> listWebinars;
		
		if(null != session)
		{
			listWebinars = session.getSession_RelatedWebinars();
			
			for(LMRelatedWebinars lmWebinar:listWebinars)
			{
				if(lmWebinar.getLMRelatedWebinarsID() == lmID)
				{
					learnMoreWebinar = lmWebinar;
					break;
				}
				else
				{
					if(lmWebinar.getLMRelatedWebinarsTopic() == lmTopic)
					{
						learnMoreWebinar = lmWebinar;
						break;
					}
				}
			}
		}
		learnMoreObject.setLearnMore(learnMoreWebinar);

		return learnMoreObject;
	}

	@Transactional
	public boolean deleteLearnMorePaper(LearnMoreObject lmPaper) {
		boolean returnValue = false;

		LMRelatedpapers learnMorePaper = null;

		learnMorePaper = (LMRelatedpapers) lmPaper.getLearnMore();
		
		int sessionID = lmPaper.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);
		List<LMRelatedpapers> listPapers;
		
		if(null != session)
		{
			listPapers = session.getSession_Relatedpapers();
			
			for(LMRelatedpapers paper : listPapers)
			{
				if(paper == learnMorePaper)
				{
					returnValue = listPapers.remove(paper);
					break;
				}
			}
			
			session.setSession_Relatedpapers(listPapers);
			sessionManager.updateSession(session);
		}

		return returnValue;
	}

	@Transactional
	public boolean deleteLearnMoreWebsite(LearnMoreObject lmWebsite) {
		boolean returnValue = false;

		LMRelatedWebsites learnMoreWebsite = null;

		learnMoreWebsite = (LMRelatedWebsites) lmWebsite.getLearnMore();
		
		int sessionID = lmWebsite.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);
		List<LMRelatedWebsites> listWebsites;
		
		if(null != session)
		{
			listWebsites = session.getSession_RelatedWebsites();
			
			for(LMRelatedWebsites website : listWebsites)
			{
				if(website == learnMoreWebsite)
				{
					returnValue = listWebsites.remove(website);
					break;
				}
			}
			session.setSession_RelatedWebsites(listWebsites);
			sessionManager.updateSession(session);
		}
		
		return returnValue;
	}

	@Transactional
	public boolean deleteLearnMoreWebinar(LearnMoreObject lmWebinar) {
		boolean returnValue = false;

		LMRelatedWebinars learnMoreWebinar = null;

		learnMoreWebinar = (LMRelatedWebinars) lmWebinar.getLearnMore();
		
		int sessionID = lmWebinar.getSessionID();
		Session session = sessionManager.getSessionById(sessionID);
		List<LMRelatedWebinars> listWebinars;
		
		if(null != session)
		{
			listWebinars = session.getSession_RelatedWebinars();
			
			for(LMRelatedWebinars webinar:listWebinars)
			{
				if(webinar == learnMoreWebinar)
				{
					returnValue = listWebinars.remove(webinar);
					break;
				}
			}
			session.setSession_RelatedWebinars(listWebinars);
			sessionManager.updateSession(session);
		}
		return returnValue;
	}
}

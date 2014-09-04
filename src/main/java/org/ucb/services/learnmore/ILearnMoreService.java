package org.ucb.services.learnmore;

import org.ucb.data.domain.LearmMore;
import org.ucb.service.model.LearnMoreObject;

public interface ILearnMoreService{

	public void addLearnMorePaper(LearnMoreObject lmPaper);
	
	public void addLearnMoreWebinar(LearnMoreObject lmWebinar);
	
	public void addLearnMoreWebsite(LearnMoreObject lmWebsite);
	
	public LearnMoreObject getLearnMorePaper(LearnMoreObject learnMoreObject);
	
	public LearnMoreObject getLearnMoreWebsite(LearnMoreObject learnMoreObject);
	
	public LearnMoreObject getLearnMoreWebinar(LearnMoreObject learnMoreObject);
	
	/**
	 * Deletes a related paper.
	 * @param lmPaper - a LearnMoreObject instance
	 * @return true - if the object has been successfully deleted.
	 * @return false - if deleting the object failed.
	 */
	public boolean deleteLearnMorePaper(LearnMoreObject lmPaper);
	
	/**
	 * Deletes a related website.
	 * @param lmPaper - a LearnMoreObject instance
	 * @return true - if the object has been successfully deleted.
	 * @return false - if deleting the object failed.
	 */
	public boolean deleteLearnMoreWebsite(LearnMoreObject lmWebsite);
	
	/**
	 * Deletes a related webinar.
	 * @param lmPaper - a LearnMoreObject instance
	 * @return true - if the object has been successfully deleted.
	 * @return false- if deleting the object failed.
	 */
	public boolean deleteLearnMoreWebinar(LearnMoreObject lmWebinar);
}

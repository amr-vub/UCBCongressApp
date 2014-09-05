package org.ucb.services.learnmore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.service.model.Document;
import org.ucb.service.model.LearnMoreObject;

import org.ucb.data.domain.LMRelatedWebinars;
import org.ucb.data.domain.LMRelatedpapers;

public class LearnMoreController {

	@Autowired
	ILearnMoreService iLearnMoreService;

	@RequestMapping(value = "/addLearnMorePaper", method = RequestMethod.POST)
	public void addLearnMorePaper(@RequestBody LearnMoreObject lmPaper) {
		iLearnMoreService.addLearnMorePaper(lmPaper);
	}

	@RequestMapping(value = "/addLearnMoreWebinar", method = RequestMethod.POST)
	public void addLearnMoreWebinar(@RequestBody LearnMoreObject lmWebinar) {
		iLearnMoreService.addLearnMoreWebinar(lmWebinar);
	}

	@RequestMapping(value = "/addLearnMoreWebsites", method = RequestMethod.POST)
	public void addLearnMoreWebsite(@RequestBody LearnMoreObject lmWebsite) {
		iLearnMoreService.addLearnMoreWebsite(lmWebsite);
	}

	@RequestMapping(value = "/getLearnMorePaper", method = RequestMethod.POST)
	public LearnMoreObject getLearnMorePaper(
			@RequestBody LearnMoreObject learnMoreObject) {
		List<LMRelatedpapers> tempValue = iLearnMoreService.getLearnMorePaper(
				learnMoreObject).getLmPapersOutput();

		// Workaround for JSON mapping
		List<LMRelatedpapers> lmRelatedPapers = new ArrayList<LMRelatedpapers>();

		for (LMRelatedpapers l : tempValue) {
			l.setRelatedpapers_session(null);
			lmRelatedPapers.add(l);
		}

		// End of workaround
		learnMoreObject.setLmPapersOutput(lmRelatedPapers);

		return learnMoreObject;
	}

	@RequestMapping(value = "/getLearnMoreWebsite", method = RequestMethod.POST)
	public LearnMoreObject getLearnMoreWebsite(
			@RequestBody LearnMoreObject learnMoreObject) {
		List<LMRelatedWebsites> tempValue = iLearnMoreService
				.getLearnMoreWebsite(learnMoreObject).getLmWebsitesOutput();

		// Workaround for JSON mapping
		List<LMRelatedWebsites> lmRelatedWebsites = new ArrayList<LMRelatedWebsites>();

		for (LMRelatedWebsites l : tempValue) {
			l.setRelatedWebsites_session(null);
			lmRelatedWebsites.add(l);
		}
		// End of workaround
		learnMoreObject.setLmWebsitesOutput(lmRelatedWebsites);

		return learnMoreObject;
	}

	@RequestMapping(value = "/getLearnMoreWebinar", method = RequestMethod.POST)
	public LearnMoreObject getLearnMoreWebinar(
			@RequestBody LearnMoreObject learnMoreObject) {
		List<LMRelatedWebinars> tempValue = iLearnMoreService
				.getLearnMoreWebinar(learnMoreObject).getLmWebinarsOutput();

		// Workaround for JSON mapping
		List<LMRelatedWebinars> lmRelatedWebinars = new ArrayList<LMRelatedWebinars>();

		for (LMRelatedWebinars l : tempValue) {
			l.setLMRelatedWebinars_Session(null);
			lmRelatedWebinars.add(l);
		}
		// End of workaround
		learnMoreObject.setLmWebinarsOutput(lmRelatedWebinars);

		return learnMoreObject;
	}

	@RequestMapping(value = "/deleteLearnMorePaper", method = RequestMethod.POST)
	public boolean deleteLearnMorePaper(@RequestBody LearnMoreObject lmPaper) {
		boolean returnValue;

		returnValue = iLearnMoreService.deleteLearnMorePaper(lmPaper);

		// Workaround for JSON mapping
		List<LMRelatedpapers> lmRelatedPapers = new ArrayList<LMRelatedpapers>();

		lmRelatedPapers = lmPaper.getLmPapersOutput();

		for (LMRelatedpapers l : lmRelatedPapers) {
			l.setRelatedpapers_session(null);
			lmRelatedPapers.add(l);
		}

		// End of workaround
		lmPaper.setLmPapersOutput(lmRelatedPapers);
		// At this point the LearnMoreManager should update lmPaper
		// ...

		return returnValue;
	}

	@RequestMapping(value = "/deleteLearnMoreWebsite", method = RequestMethod.POST)
	public boolean deleteLearnMoreWebsite(@RequestBody LearnMoreObject lmWebsite) {
		boolean returnValue;

		returnValue = iLearnMoreService.deleteLearnMoreWebsite(lmWebsite);

		// Workaround for JSON mapping
		List<LMRelatedWebsites> lmRelatedWebsites = new ArrayList<LMRelatedWebsites>();

		lmRelatedWebsites = lmWebsite.getLmWebsitesOutput();

		for (LMRelatedWebsites l : lmRelatedWebsites) {
			l.setRelatedWebsites_session(null);
			lmRelatedWebsites.add(l);
		}
		
		// End of workaround
		lmWebsite.setLmWebsitesOutput(lmRelatedWebsites);
		// At this point the LearnMoreManager should update lmWebsite
		// ...

		return returnValue;
	}

	@RequestMapping(value = "/deleteLearnMoreWebinar", method = RequestMethod.POST)
	public boolean deleteLearnMoreWebinar(@RequestBody LearnMoreObject lmWebinar) {
		boolean returnValue;

		returnValue = iLearnMoreService.deleteLearnMoreWebinar(lmWebinar);
		
		// Workaround for JSON mapping
		List<LMRelatedWebinars> lmRelatedWebinars = new ArrayList<LMRelatedWebinars>();
		
		lmRelatedWebinars = lmWebinar.getLmWebinarsOutput();

		for (LMRelatedWebinars l : lmRelatedWebinars) {
			l.setLMRelatedWebinars_Session(null);
			lmRelatedWebinars.add(l);
		}
		
		// End of workaround
		lmWebinar.setLmWebinarsOutput(lmRelatedWebinars);
		// At this point the LearnMoreManager should update lmWebsite
		// ...		

		return returnValue;
	}
}

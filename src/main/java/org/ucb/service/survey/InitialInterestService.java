package org.ucb.service.survey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ucb.data.dao.IInitialInterestsManager;
import org.ucb.data.domain.out.InitialInterests;
import org.ucb.data.domain.out.Specialization;
import org.ucb.data.domain.out.SubSpecialzation;
import org.ucb.data.domain.out.profession;
import org.ucb.service.model.InitialInterestModel;

@Service
public class InitialInterestService implements IInitialInterestService{

	@Autowired
	private IInitialInterestsManager iInitialInterestsManager; 
	
	@Override
	@Transactional
	public List<InitialInterests> getInitailInterest(
			InitialInterestModel initialInterestModel) {
		
		List<InitialInterests> initialInterestsList = 
				iInitialInterestsManager.getInitialInterests(initialInterestModel.getSubspecialType());
		
		return initialInterestsList;
	}
	
	@Override
	@Transactional
	public List<SubSpecialzation> getSubSpecial(InitialInterestModel initialInterestModel){
		
		List<SubSpecialzation> subSpecialList = iInitialInterestsManager.getInitialSubSpecial(initialInterestModel.getSpecialType());
		
		return subSpecialList;
		
	}	

	@Transactional
	public void storeProf(profession prof){
		iInitialInterestsManager.storeProf(prof);
	}


	@Transactional
	public void storeSpecial(Specialization special){
		iInitialInterestsManager.storeSpecial(special);
	}

}

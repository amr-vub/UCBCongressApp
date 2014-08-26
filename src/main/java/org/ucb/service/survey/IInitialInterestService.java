package org.ucb.service.survey;

import java.util.List;

import org.ucb.data.domain.out.InitialInterests;
import org.ucb.data.domain.out.Specialization;
import org.ucb.data.domain.out.SubSpecialzation;
import org.ucb.data.domain.out.profession;
import org.ucb.service.model.InitialInterestModel;

public interface IInitialInterestService {

	public List<InitialInterests> getInitailInterest(InitialInterestModel initialInterestModel);
	
	public List<SubSpecialzation> getSubSpecial(InitialInterestModel initialInterestModel);
	
	public void storeProf(profession prof);
	
	public void storeSpecial(Specialization special);
}

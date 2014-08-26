package org.ucb.data.dao;

import java.util.List;

import org.ucb.data.domain.out.InitialInterests;
import org.ucb.data.domain.out.Specialization;
import org.ucb.data.domain.out.SubSpecialzation;
import org.ucb.data.domain.out.profession;

public interface IInitialInterestsManager {

	public List<InitialInterests> getInitialInterests(String subSpecialType);
	
	public List<SubSpecialzation> getInitialSubSpecial(String specialType);
	
	public void storeProf(profession prof);
	
	public void storeSpecial(Specialization special);
	
}

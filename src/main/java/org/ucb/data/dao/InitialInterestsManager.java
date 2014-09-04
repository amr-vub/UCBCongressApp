package org.ucb.data.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ucb.data.domain.out.InitialInterests;
import org.ucb.data.domain.out.Specialization;
import org.ucb.data.domain.out.SubSpecialzation;
import org.ucb.data.domain.out.profession;

@Repository
public class InitialInterestsManager implements IInitialInterestsManager{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<SubSpecialzation> getInitialSubSpecial(String specialType) {		
		
		Specialization spec =  (Specialization) getSessionFactory().getCurrentSession().createQuery("SELECT u FROM Specialization u WHERE u.SpecializationType LIKE :specialType").
		setParameter("specialType", specialType).list().get(0);

		List<SubSpecialzation> subSubSpecialzationList = spec.getSpecial_subSpec();
		
		return subSubSpecialzationList;
	}
	public List<InitialInterests> getInitialInterests(String subSpecialType) {		
		
		SubSpecialzation subspec =  (SubSpecialzation) getSessionFactory().getCurrentSession().createQuery("SELECT u FROM SubSpecialzation u WHERE u.SubSpecialzation LIKE :subSpecialType").
				setParameter("subSpecialType", subSpecialType).list().get(0);			
		
	    List<InitialInterests> initialInterestsList = loadInitList(subspec); // subspec.getSubspec_IniInterests();
				

		return initialInterestsList;
	}	
	
	public void storeProf(profession prof){
		getSessionFactory().getCurrentSession().persist(prof);
	}
	
	public void storeSpecial(Specialization special){
		getSessionFactory().getCurrentSession().persist(special);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private List<InitialInterests> loadInitList(SubSpecialzation subSpecial){
		List<InitialInterests> initialInterestsList = getSessionFactory().getCurrentSession().
			createQuery("SELECT u FROM InitialInterests u WHERE u.inital_Subspecial = :subSpecial").
				setParameter("subSpecial", subSpecial).list();
		return initialInterestsList;
	}
}

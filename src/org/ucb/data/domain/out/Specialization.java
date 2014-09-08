package org.ucb.data.domain.out;

import java.util.List;


public class Specialization {

	
	private int specializationID;
	
	
	private String specializationType;
	
	
	private List<profession> special_prof;
	
	
	private List<SubSpecialzation> Special_subSpec;

	public int getSpecializationID() {
		return specializationID;
	}

	public void setSpecializationID(int specializationID) {
		this.specializationID = specializationID;
	}

	

	public String getSpecializationType() {
		return specializationType;
	}

	public void setSpecializationType(String specializationType) {
		this.specializationType = specializationType;
	}

	public List<profession> getSpecial_prof() {
		return special_prof;
	}

	public void setSpecial_prof(List<profession> special_prof) {
		this.special_prof = special_prof;
	}

	public List<SubSpecialzation> getSpecial_subSpec() {
		return Special_subSpec;
	}

	public void setSpecial_subSpec(List<SubSpecialzation> special_subSpec) {
		Special_subSpec = special_subSpec;
	}	
	
}

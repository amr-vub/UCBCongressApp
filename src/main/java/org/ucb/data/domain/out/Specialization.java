package org.ucb.data.domain.out;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Specialization {

	@Id @GeneratedValue
	private int specializationID;
	
	@Column
	private String SpecializationType;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="prof_special")
	private List<profession> special_prof;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="subSpec_Special")
	private List<SubSpecialzation> Special_subSpec;

	public int getSpecializationID() {
		return specializationID;
	}

	public void setSpecializationID(int specializationID) {
		this.specializationID = specializationID;
	}

	public String getSpecializationType() {
		return SpecializationType;
	}

	public void setSpecializationType(String specializationType) {
		SpecializationType = specializationType;
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

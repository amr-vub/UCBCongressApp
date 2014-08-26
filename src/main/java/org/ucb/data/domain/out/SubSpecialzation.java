package org.ucb.data.domain.out;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SubSpecialzation {

	@Id @GeneratedValue
	private int SubSpecialzationID;
	
	@Column
	private String SubSpecialzation;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Specialization subSpec_Special;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy ="inital_Subspecial")
	private List<InitialInterests> subspec_IniInterests;

	public int getSubSpecialzationID() {
		return SubSpecialzationID;
	}

	public void setSubSpecialzationID(int subSpecialzationID) {
		SubSpecialzationID = subSpecialzationID;
	}

	public String getSubSpecialzation() {
		return SubSpecialzation;
	}

	public void setSubSpecialzation(String subSpecialzation) {
		SubSpecialzation = subSpecialzation;
	}

	public Specialization getSubSpec_Special() {
		return subSpec_Special;
	}

	public void setSubSpec_Special(Specialization subSpec_Special) {
		this.subSpec_Special = subSpec_Special;
	}

	public List<InitialInterests> getSubspec_IniInterests() {
		return subspec_IniInterests;
	}

	public void setSubspec_IniInterests(List<InitialInterests> subspec_IniInterests) {
		this.subspec_IniInterests = subspec_IniInterests;
	}
	
	
}

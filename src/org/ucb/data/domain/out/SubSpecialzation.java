package org.ucb.data.domain.out;

import java.util.List;

public class SubSpecialzation {

	
	private int SubSpecialzationID;
		
	private String SubSpecialzation;

	private Specialization subSpec_Special;
	
	
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

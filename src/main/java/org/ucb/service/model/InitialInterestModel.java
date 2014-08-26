package org.ucb.service.model;

import java.util.List;

import org.ucb.data.domain.out.InitialInterests;
import org.ucb.data.domain.out.SubSpecialzation;

public class InitialInterestModel {

	private String profType;
	
	private String SpecialType;
	
	private String subspecialType;
	
	private List<SubSpecialzation> subSpecList;
	
	private List<InitialInterests> initIntList;

	public InitialInterestModel(){
		
	}
	
	public List<SubSpecialzation> getSubSpecList() {
		return subSpecList;
	}

	public void setSubSpecList(List<SubSpecialzation> subSpecList) {
		this.subSpecList = subSpecList;
	}

	public List<InitialInterests> getInitIntList() {
		return initIntList;
	}

	public void setInitIntList(List<InitialInterests> initIntList) {
		this.initIntList = initIntList;
	}

	public String getProfType() {
		return profType;
	}

	public void setProfType(String profType) {
		this.profType = profType;
	}

	public String getSpecialType() {
		return SpecialType;
	}

	public void setSpecialType(String specialType) {
		SpecialType = specialType;
	}

	public String getSubspecialType() {
		return subspecialType;
	}

	public void setSubspecialType(String subspecialType) {
		this.subspecialType = subspecialType;
	}
	
	
}

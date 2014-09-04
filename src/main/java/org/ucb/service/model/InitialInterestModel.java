package org.ucb.service.model;

import java.util.List;

import org.ucb.data.domain.out.InitialInterests;
import org.ucb.data.domain.out.SubSpecialzation;

public class InitialInterestModel {

	// input para
	private String profType;
	
	// input para
	private String specialType;
	
	// input para
	private String subspecialType;
	
	// output para
	private List<SubSpecialzation> subSpecList;
	// output para
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
		return specialType;
	}

	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}

	public String getSubspecialType() {
		return subspecialType;
	}

	public void setSubspecialType(String subspecialType) {
		this.subspecialType = subspecialType;
	}
	
	
}

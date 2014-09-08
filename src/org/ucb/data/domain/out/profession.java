package org.ucb.data.domain.out;



public class profession {

	
	private int professionID;
	
	
	private String professionType;	
	
	
	
	private Specialization prof_special;

	public int getProfessionID() {
		return professionID;
	}

	public void setProfessionID(int professionID) {
		this.professionID = professionID;
	}

	public String getProfessionType() {
		return professionType;
	}

	public void setProfessionType(String professionType) {
		this.professionType = professionType;
	}

	public Specialization getProf_special() {
		return prof_special;
	}

	public void setProf_special(Specialization prof_special) {
		this.prof_special = prof_special;
	}
	
	
}

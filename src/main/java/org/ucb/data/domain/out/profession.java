package org.ucb.data.domain.out;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class profession {

	@Id @GeneratedValue
	private int professionID;
	
	@Column
	private String professionType;	
	
	@ManyToOne
	@JoinColumn(nullable=false)
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

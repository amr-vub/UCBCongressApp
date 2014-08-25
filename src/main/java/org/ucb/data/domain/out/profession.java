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
	
}

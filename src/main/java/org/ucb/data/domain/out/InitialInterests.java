package org.ucb.data.domain.out;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class InitialInterests {

	@Id @GeneratedValue
	private int InitialInterestsID;
	
	@Column
	private String InitialInterests;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private SubSpecialzation inital_Subspecial;
}

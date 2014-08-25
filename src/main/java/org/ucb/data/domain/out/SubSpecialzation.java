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
	
}

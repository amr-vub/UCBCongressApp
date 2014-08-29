package org.ucb.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote_value {

	@Id @GeneratedValue
	private int vote_value_ID;
	
	@Column
	private int voteValue;
	
	@ManyToOne 
	@JoinColumn(nullable=false)
	private Vote Vote_value_Vote;
	
}

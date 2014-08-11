package org.ucb.data.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/** 
 * This class contains the personalized agenda details per HCP
 */

@Entity
public class Agenda {

	@Id
	private int agendaID;
	
	// each Agenda is associated with only one HCP
	@OneToOne @JoinColumn(nullable=false)
	private HCP agenda_hcp;

	
	
	public HCP getAgenda_hcp() {
		return agenda_hcp;
	}

	public void setAgenda_hcp(HCP agenda_hcp) {
		this.agenda_hcp = agenda_hcp;
	}

	public int getAgendaID() {
		return agendaID;
	}

	public void setAgendaID(int agendaID) {
		this.agendaID = agendaID;
	}
	
	
}

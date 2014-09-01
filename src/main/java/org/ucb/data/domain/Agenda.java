package org.ucb.data.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/** 
 * This class contains the personalized agenda details per HCP
 */

@Entity
public class Agenda {

	@Id
	private int agendaID;
	
	// each Agenda is associated with only one HCP
	@OneToOne @JoinColumn(nullable=false, unique=true)
	private HCP agenda_hcp;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="AGENDA_SESSION")
	private List<Session> agenda_Session;	
	
	
	public List<Session> getAgenda_Session() {
		return agenda_Session;
	}

	public void setAgenda_Session(List<Session> agenda_Session) {
		this.agenda_Session = agenda_Session;
	}

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

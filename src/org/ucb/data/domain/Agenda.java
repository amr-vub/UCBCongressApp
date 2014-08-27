package org.ucb.data.domain;

import java.util.List;



/** 
 * This class contains the personalized agenda details per HCP
 */


public class Agenda {


	private int agendaID;
	
	// each Agenda is associated with only one HCP
	private HCP agenda_hcp;

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

package org.ucb.data.domain;

import java.util.Date;


/** 
 * This class contains question info that HCPs submit during sessions
 */

public class Questions {

	private int QsID;
	
	private String Question;
	
	private Date QsSubmissionTime;
	
	/*
	// each qestion can be asked by one hcp
	@ManyToOne
	@JoinColumn(nullable=false)
	private HCP qs_HCP;
	*/
	
	// each question can be related to one and only one session
	private Session qs_session;

	public Session getQs_session() {
		return qs_session;
	}

	public void setQs_session(Session qs_session) {
		this.qs_session = qs_session;
	}

	public int getQsID() {
		return QsID;
	}

	public void setQsID(int qsID) {
		QsID = qsID;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public Date getQsSubmissionTime() {
		return QsSubmissionTime;
	}

	public void setQsSubmissionTime(Date qsSubmissionTime) {
		QsSubmissionTime = qsSubmissionTime;
	}
	
	
}

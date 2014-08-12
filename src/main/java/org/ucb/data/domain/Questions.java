package org.ucb.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** 
 * This class contains question info that HCPs submit during sessions
 */

@Entity
public class Questions {

	@Id @GeneratedValue
	private int QsID;
	
	@Column
	private String Question;
	
	@Column @Temporal(TemporalType.TIME)
	private Date QsSubmissionTime;
	
	// each qestion can be asked by one hcp
	@ManyToOne
	@JoinColumn(nullable=false)
	private HCP qs_HCP;
	
	// each question can be related to one and only one session
	@ManyToOne
	@JoinColumn(nullable=false)
	private Session qs_session;

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

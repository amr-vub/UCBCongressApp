package org.ucb.data.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

package org.ucb.data.domain;



/** 
 * This class reflects a session's Content
 */
public class Docs {


	private int docID;
	
	private String docName;
	
	private String docAbstract;
	
	private String docLink;
	
	private Session docs_session;
	
	public Session getDocs_session() {
		return docs_session;
	}

	public void setDocs_session(Session docs_session) {
		this.docs_session = docs_session;
	}

	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocAbstract() {
		return docAbstract;
	}

	public void setDocAbstract(String docAbstract) {
		this.docAbstract = docAbstract;
	}

	public String getDocLink() {
		return docLink;
	}

	public void setDocLink(String docLink) {
		this.docLink = docLink;
	}
	
	
}

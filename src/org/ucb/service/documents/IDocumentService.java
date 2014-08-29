package org.ucb.service.documents;

import java.io.File;

import org.ucb.service.model.Document;

public interface IDocumentService {
	
	public int uploadDocument(Document modelDoc);
	
	public int downloadDocument(Document modelDoc);
	
	public void setAbstract(Document modelDoc);
	
	public String getAbstract(Document modelDoc);
}

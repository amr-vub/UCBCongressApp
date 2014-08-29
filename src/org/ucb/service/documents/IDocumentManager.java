package org.ucb.service.documents;

import java.io.File;

public interface IDocumentManager {
	
	public void uploadDocument(String url, String parameters, File fileToUpload);
	
	public void downloadDocument(String url);
	
	public void rateDocument(int rating);
	
	//public void setAbstract(String _abstract);
	
	//public String getAbstract();
}

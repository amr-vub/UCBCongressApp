package org.ucb.service.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ucb.service.model.Document;

public class DocumentController {

	@Autowired
	IDocumentService iDocumentService;
	
	@RequestMapping(value="/downloadDocument" , method = RequestMethod.POST)
	public int downloadDocument(@RequestBody Document document)
	{
			
			int returnValue;
			
			returnValue = iDocumentService.downloadDocument(document);
			
			return returnValue;
	}
	
	@RequestMapping(value="/uploadDocument" , method = RequestMethod.POST)
	public int uploadDocument(@RequestBody Document document)
	{
			
			int returnValue;			
			
			returnValue = iDocumentService.uploadDocument(document);
			
			return returnValue;
	}
	
	@RequestMapping(value="/getAbstract" , method = RequestMethod.POST)
	public String getAbstract(@RequestBody Document document)
	{
			
			String returnValue;		
			
			returnValue = iDocumentService.getAbstract(document);
			
			return returnValue;
	}
	
	@RequestMapping(value="/setAbstract" , method = RequestMethod.POST)
	public void setAbstract(@RequestBody Document document)
	{
			iDocumentService.setAbstract(document);
	}
}

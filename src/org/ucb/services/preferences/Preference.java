package org.ucb.services.preferences;

import java.util.ArrayList;
import java.util.Date;

public class Preference {
	
	private static final int FIELDS_OF_INTEREST_COUNT = 3;
	private static final int MATERIALS_COUNT          = 6;
	
	private Integer preferenceID;
	
	private ArrayList<String> communicationChannels;
	
	private Date lastTimeUpdate;
	
	private Frequency updateFrequency;
	
	/* In order to adjust the granularity of preferences*/
	private boolean optinout[][];
	
	/* Initializing the optinout matrix*/
	public Preference()
	{
		optinout = new boolean[FIELDS_OF_INTEREST_COUNT][MATERIALS_COUNT];		
	}
	
	/* Copy constructor*/
	public Preference(Integer preferenceID,
			ArrayList<String> communicationChannels,
			ArrayList<FieldOfInterest> fieldsOfInterest, Date lastTimeUpdate,
			Frequency updateFrequency, ArrayList<ArrayList<Material>> optinout) {
	
		this.preferenceID = preferenceID;
		this.communicationChannels = communicationChannels;
		//this.fieldsOfInterest = fieldsOfInterest;
		this.lastTimeUpdate = lastTimeUpdate;
		this.updateFrequency = updateFrequency;		
	}
	
	public void setOptinout(FieldOfInterest fieldOfInterest)
	{
		int materialIterator     = 0;
		int fieldOfInterestIndex = 0;
		
		switch(fieldOfInterest)
		{
		case PARKINSON:
			fieldOfInterestIndex = 0;
			break;
		case EPILEPSY:
			fieldOfInterestIndex = 1;
			break;
		case RHEUMATOID_ARTHRITIS:
			fieldOfInterestIndex = 2;
			break;
		}
		
		/* Setting all the material types for the desired Field of Interest.*/
		for(materialIterator = 0; materialIterator < MATERIALS_COUNT ; materialIterator++)
		{
			optinout[fieldOfInterestIndex][materialIterator] = true;
		}		
	}
	
	public void modifyOptinout(FieldOfInterest fieldOfInterest, Material materialType, boolean value)
	{
		int fieldOfInterestIndex = 0;
		int materialTypeIndex    = 0;
		
		switch(fieldOfInterest)
		{
		case PARKINSON:
			fieldOfInterestIndex = 0;
			break;
		case EPILEPSY:
			fieldOfInterestIndex = 1;
			break;
		case RHEUMATOID_ARTHRITIS:
			fieldOfInterestIndex = 2;
			break;
		}
		
		switch(materialType)
		{
		case WEBINARS:
			materialTypeIndex = 0;
			break;
		case CONFERENCES:
			materialTypeIndex = 1;
			break;
		case PAPERS:
			materialTypeIndex = 2;
			break;
		case BOOKS:
			materialTypeIndex = 3;
			break;
		case ARTICLES:
			materialTypeIndex = 4;
			break;
		case MAGAZINES:
			materialTypeIndex = 5;
			break;
		
		}		
		optinout[fieldOfInterestIndex][materialTypeIndex] = value;
	}	
	
}

package org.ucb.services.preferences;

import java.util.ArrayList;
import java.util.Date;

public class Preference {
	
	// Equivalent to "#define ..." in C
	private static final int FIELDS_OF_INTEREST_COUNT = 3;
	private static final int MATERIALS_COUNT          = 6;
	
	private Integer preferenceID;
	
	private ArrayList<String> communicationChannels;
	
	private Date lastTimeUpdate;
	
	private Frequency updateFrequency;
	
	/* In order to adjust the granularity of preferences*/
	private Opt optinout[][];
	
	/** Initializing the optinout matrix
	 * 
	 * This should reflect the fields of interest and more exact which types of information
	 * related to that field.
	 * 
	 * */
	public Preference()
	{
		optinout = new Opt[FIELDS_OF_INTEREST_COUNT][MATERIALS_COUNT];		
	}
	
	/**
	 *  Copy constructor
	 *  
	 *  */
	public Preference(Integer preferenceID,
			ArrayList<String> communicationChannels,
			ArrayList<FieldOfInterest> fieldsOfInterest, Date lastTimeUpdate,
			Frequency updateFrequency, ArrayList<ArrayList<MaterialType>> optinout) {
	
		this.preferenceID = preferenceID;
		this.communicationChannels = communicationChannels;
		//this.fieldsOfInterest = fieldsOfInterest;
		this.lastTimeUpdate = lastTimeUpdate;
		this.updateFrequency = updateFrequency;
		
		//TODO: Store the fields in the DB
	}
	
	/**
	 * This function opts in for all materials related to a given Field of Interest.
	 * 
	 * @param fieldOfInterest - the fieldOfInterest for which the user opts in.
	 * 
	 * @return None.
	 */
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
			optinout[fieldOfInterestIndex][materialIterator] = Opt.OPT_IN;
			//TODO: Update the Entry in the DB
		}		
	}
	
	/**
	 * This function modifies the opt-in-out status of the preference center.
	 * 
	 * @param fieldOfInterest - the fieldOfInterest for which the modification must be made.
	 * @param materialType - the material type for which the user wants to opt in or opt out.
	 * @param option - user's choice, whether to opt in or opt out for a given material type.
	 * 
	 * @return None.
	 */
	public void modifyOptinout(FieldOfInterest fieldOfInterest, MaterialType materialType, Opt option)
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
		optinout[fieldOfInterestIndex][materialTypeIndex] = option;
		//TODO: Update the Entry in the DB
	}	
	
}

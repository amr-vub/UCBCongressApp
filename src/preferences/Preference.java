package preferences;

import java.util.ArrayList;
import java.util.Date;

public class Preference {
	
	private Integer preferenceID;
	
	private ArrayList<String> communicationChannels;
	
	private ArrayList<FieldOfInterest> fieldsOfInterest;
	
	private Date lastTimeUpdate;
	
	private Frequency updateFrequency;
	
	private ArrayList<FieldOfInterest> optinout;
}

package Identification;

import Preferences.Preference;
import sampleLogin.SLoginModule;

import java.util.ArrayList;
import java.util.Date;
import java.security.SecureRandom;

public class User {
	
	private UserType userType;
	
	/* Assuming everyone has one*/
	private Integer uniqueID;
	
	/* Mr. / Ms. / Mrs.*/
	private Title personalTitle; 
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private Integer zipCode;
	
	private String city;
	
	private String country;
	
	private String email;
	
	private Integer phoneNumber;
	
	private ArrayList<String> professionalTitles;
	
	private String academicTitle;
	
	private ArrayList<String> specializations;
	
	private ArrayList<String> subSpecializations;
	
	private ArrayList<String> therapeuticAreas;
	
	private Preference Preferences;	
	
	private static SLoginModule loginModule;
	
	private ArrivalStatus arrivalStatus = ArrivalStatus.ABSENT;
	
	private Date registrationDate;
	
	private Date lastLoginDate;
	
	public User()
	{
		userType 				= UserType.UNDEFINED;
		uniqueID 				= 0;
		personalTitle 			= Title.UNDEFINED;		
		firstName 				= null;
		lastName				= null;
		address 				= null;
		zipCode 				= 0;
		city 					= null;
		country 				= null;
		email 					= null;
		phoneNumber 			= 0;		
		professionalTitles 		= null;		
		academicTitle 			= null;		
		specializations 		= null;		
		subSpecializations 		= null;		
		therapeuticAreas 		= null;		
		Preferences 			= null;
		arrivalStatus 			= ArrivalStatus.ABSENT;		
		lastLoginDate           = null;
		
		if(!(loginModule instanceof SLoginModule))
		{
			loginModule 		= new SLoginModule();
		}	
	}
	
	public int check_IN()
	{
		arrivalStatus = ArrivalStatus.CHECKED_IN;
		
		return 0;
	}
	
	public int check_OUT()
	{
		//arrivalStatus = ArrivalStatus.CHECKED_OUT;
		
		return 0;
	}
	
}

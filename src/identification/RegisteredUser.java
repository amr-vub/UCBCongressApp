package identification;

import java.util.ArrayList;
import java.util.Date;




import preferences.Preference;

public class RegisteredUser extends AnonymousUser {
	
	/* Assuming everyone has one*/
	private Integer uniqueID;
	
	/* Mr. / Ms. / Mrs.*/
	private Title personalTitle; 
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private Integer zipCode;
	
	private String city;
	
	// country is known from AnonymousUser
	
	private String email;
	
	private Integer phoneNumber;
	
	private ArrayList<String> specializations;
	
	private ArrayList<String> subSpecializations;
	
	private ArrayList<String> therapeuticAreas;
	
	private Preference Preferences;		
	
	private Date registrationDate;
	
	private Date lastLoginDate;
	
	/** 
	 * Initialization constructor
	 * */
	public RegisteredUser()
	{
		uniqueID 				= 0;
		personalTitle 			= Title.UNDEFINED;		
		firstName 				= null;
		lastName				= null;
		address 				= null;
		zipCode 				= 0;
		city 					= null;
		
		email 					= null;
		phoneNumber 			= 0;		
		
		specializations 		= null;		
		subSpecializations 		= null;		
		therapeuticAreas 		= null;		
		Preferences 			= null;
		lastLoginDate           = null;		
	}
	
	/**
	 * Copy Constructor
	 * */
	public RegisteredUser(Integer uniqueID, Title personalTitle,
			String firstName, String lastName, String address, Integer zipCode,
			String city, String email, Integer phoneNumber,
			ArrayList<String> specializations,
			ArrayList<String> subSpecializations,
			ArrayList<String> therapeuticAreas, Preference preferences,
			Date registrationDate, Date lastLoginDate) {
		super();
		this.uniqueID = uniqueID;
		this.personalTitle = personalTitle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.specializations = specializations;
		this.subSpecializations = subSpecializations;
		this.therapeuticAreas = therapeuticAreas;
		Preferences = preferences;
		this.registrationDate = registrationDate;
		this.lastLoginDate = lastLoginDate;
	}
}

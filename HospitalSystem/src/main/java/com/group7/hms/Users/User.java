package com.group7.hms.Users;

import java.util.Date;

/**
 * public class User - will hold and handle the all of the general information
 * of all the users
 * 
 * @author Jacob Christensen
 *
 */
public abstract class User {

	/**
	 * private field username - The username will also be the email that the
	 * user will recieve email notifications
	 */
	private String username="";
	/**
	 * private field password - The password for the user
	 */
	// TODO The password need to be hashed.
	private String password="";
	/**
	 * private field firstname - The first name of the user
	 */
	private String Name="";
	/**
	 * private field middleName - The middle name of the user
	 */
	private String middleName="";
	/**
	 * private field lastName - The last name of the user
	 */
	private String lastName="";
	/**
	 * private field dateOfBirth - The date of birth of the user
	 */
	private Date dateOfBirth=new Date();
	/**
	 * private field age - The calculated age of the user.
	 */
	private int age=0;
	/**
	 * private field maritalStatus - The marital status of the user
	 */
	private String maritialStatus="";
	/**
	 * private field userAddress - The address for the user
	 */
	private MailingAddress userAddress = new MailingAddress();
	/**
	 * private field primaryPhone - the primary phone number for the user
	 */
	private int primaryPhone=0;
	/**
	 * private field secondaryPhone - the secondary phone number for the user
	 */
	private int secondaryPhone=0;
	/**
	 * private field primaryEmail - The primary email address for the user. The
	 * default will be the username.
	 */
	private String primaryEmail="";
	/**
	 * private field secondaryEmail - The secondary email address for the user.
	 */
	private String secondaryEmail="";
	/**
	 * private field ecFirstName - The first name of the emergency contact
	 */
	private String ecFirstName="";
	/**
	 * private field ecLastname - The last name of the emergenecy contact.
	 */
	private String ecLastName="";
	/**
	 * private field ecPhoneNumber - The phone number of the emergenry contact.
	 */
	private int ecPhoneNumber=0;
	/**
	 * private field ecEmailAddress - The email address of the Emergency
	 * contact.
	 */
	private String ecEmailAddress="";
	/**
	 * private field jobTitle - stores the job title of the Provider
	 */
	private String jobTitle="";
	private String status = "";
	public int getEcPhoneNumber() {
		return ecPhoneNumber;
	}
	public void setEcPhoneNumber(int ecPhoneNumber) {
		this.ecPhoneNumber = ecPhoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAge() {
		return age;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * public constructor - will create a new instance of the class User and
	 * store the username, primary email and the password.
	 */
	public User(){
		
	}
	public User(String applicantEmail, String applicantPassword,String role,String name) {
		// set the username. This should be the only time that the username is
		// ever set.
		setUsername(applicantEmail);
		// set the Primary Email for the user
		setPrimaryEmail(applicantEmail);
		// Set the password for the user
		setPassword(applicantPassword);
		setName(name);
		setJobTitle(role);
	}

	/**
	 * public method getUserName - returns the Username of the user
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * private setUsername - sets the username of the user. It is set private
	 * because the username will only be set once during the initial application
	 * for the user role.
	 * 
	 * @param username
	 *            the username to set
	 */
	private void setUsername(String username) {
		this.username = username;
	}

	// TODO Implement the hashing to protect the Password.
	/**
	 * public method getPassword - gets and returns the password of the user
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	// TODO Do we want to implement the Verification for the password here
	// return a boolean?
	/**
	 * Public method setPassword - Set the user password to log onto the tool.
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * public method getFirstName - returns the first name of the user
	 * 
	 * @return the firstName of the user
	 */
	public String getName() {
		return Name;
	}

	/**
	 * public method setFirstName - sets the first name of the user. Will be
	 * used when the user enters their personal information and demographics
	 * 
	 * @param Name
	 *            the firstName to set
	 */
	public void setName(String Name) {
		this.Name = Name;
	}

	/**
	 * public method getMiddleName - returns the middle name of the user.
	 * 
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * public method setMiddleName - Sets the middle name of the user. Will be
	 * used when the user enters their personal information and demographics.
	 * 
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * public method getLastName - returns the last name of the user.
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * public method setLastName - Sets the last name of the user. Will be used
	 * when the user enters their personal information and demographics.
	 * 
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * public method getDateOfBirth - returns the date of birth of the user.
	 * 
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * public method setDateofBirth - Sets the Date of Birth of the user. Will
	 * be used when the user enters their personal information and demographics.
	 * 
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(int year, int month, int day) {
		//this.dateOfBirth = DateFormat.(year, month, day);
		setAge(calculateAge(this.dateOfBirth));
	}

	/**
	 * public method getMaritalStatus - returns the martial status of the user
	 * 
	 * @return the maritialStatus
	 */
	public String getMaritialStatus() {
		return maritialStatus;
	}

	/**
	 * public method setMaritialStatus - Sets the martial status of the user.
	 * will be used when the user enters their personal information and
	 * demographics.
	 * 
	 * @param maritialStatus
	 *            the maritialStatus to set
	 */
	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}

	// TODO figure out how the userAddress needs to be displayed and represented
	/**
	 * public method getUserAddress - will return the address of the user
	 * 
	 * @return the userAddress
	 */
	public MailingAddress getUserAddress() {
		return userAddress;
	}

	// TODO need to decide to how to handle the user address
	/**
	 * public method setUserAddress - sets the user address. Will be used when
	 * the user enters their personal information and demographics.
	 * 
	 * @param userAddress
	 *            the userAddress to set
	 */
	public void setUserAddress(String street, String city, String state, int zip) {
		this.userAddress = new MailingAddress(street, city, state, zip);
	}

	/**
	 * public method getPrimaryPhone - will return the primary phone number for
	 * the user.
	 * 
	 * @return the primaryPhone
	 */
	public int getPrimaryPhone() {
		return primaryPhone;
	}

	/**
	 * public method setPrimaryPhone - Sets the primary phone number of the
	 * user. Will be used when the user enters their personal information and
	 * demographics.
	 * 
	 * @param primaryPhone
	 *            the primaryPhone to set
	 */
	public void setPrimaryPhone(int primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	/**
	 * public method getSecondaryPhone - Will return the secondary phone number
	 * for the user.
	 * 
	 * @return the secondaryPhone
	 */
	public int getSecondaryPhone() {
		return secondaryPhone;
	}

	/**
	 * public method setSecondryPhone - Sets the secondary phone number of the
	 * user. Will be used when the user enters their personal information and
	 * demographics.
	 * 
	 * @param secondaryPhone
	 *            the secondaryPhone to set
	 */
	public void setSecondaryPhone(int secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	/**
	 * public method getPrimaryEmail - Will return the primary email address of
	 * the user. The primary email address will be the email that the user will
	 * receive email notifications.
	 * 
	 * @return the primaryEmail
	 */
	public String getPrimaryEmail() {
		return primaryEmail;
	}

	/**
	 * public method setPrimaryEmail - Sets the primary email address of the
	 * user. Will be used when the user enters their personal information and
	 * demographics.
	 * 
	 * @param primaryEmail
	 *            the primaryEmail to set
	 */
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	/**
	 * public method getSecondayEmail - Will return the secondary email address
	 * of the user.
	 * 
	 * @return the secondaryEmail
	 */
	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	/**
	 * public method setSecondaryEmail - Sets the secondary email address of the
	 * user. Will be used when the user enters their personal information and
	 * demographics.
	 * 
	 * @param secondaryEmail
	 *            the secondaryEmail to set
	 */
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	/**
	 * public method getEcirstName - will return the first name of the emergency
	 * contact.
	 * 
	 * @return the Emergency contact FirstName
	 */
	public String getEcFirstName() {
		return ecFirstName;
	}

	/**
	 * public method setEcFirstName - sets the first name of the emergency
	 * contact. Will be used when the user enters their personal information and
	 * demographics.
	 * 
	 * @param ecFirstName
	 *            the ecFirstName to set
	 */
	public void setEcFirstName(String ecFirstName) {
		this.ecFirstName = ecFirstName;
	}

	/**
	 * public method getEcLastName - Will return the last name of the emergency
	 * contact.
	 * 
	 * @return the ecLastName
	 */
	public String getEcLastName() {
		return ecLastName;
	}

	/**
	 * public method setEcLastName - Sets the last name of the emergency
	 * contact. Will be used when the user enters their personal information and
	 * demographics.
	 * 
	 * @param ecLastName
	 *            the ecLastName to set
	 */
	public void setEcLastName(String ecLastName) {
		this.ecLastName = ecLastName;
	}

	/**
	 * public method getEcPhoneNumber - Will return the phone number of the
	 * emergency contact.
	 * 
	 * @return the ecPhoneNuber
	 */
	public int getEcPhoneNuber() {
		return ecPhoneNumber;
	}

	/**
	 * public method setEcPhoneNumber - Sets the phone number of the emergency
	 * contact. Will be used when the user enters their personal information and
	 * demographics.
	 * 
	 * @param ecPhoneNuber
	 *            the ecPhoneNuber to set
	 */
	public void setEcPhoneNuber(int ecPhoneNuber) {
		this.ecPhoneNumber = ecPhoneNuber;
	}

	/**
	 * public method getEcEmailAddress - Will return the email address of the
	 * emergency contact.
	 * 
	 * @return the ecEmailAddress
	 */
	public String getEcEmailAddress() {
		return ecEmailAddress;
	}

	/**
	 * public method setEcEmailAddress - sets the email address of the emergency
	 * contact. Will be used when the user enters their personal information and
	 * demographics.
	 * 
	 * @param ecEmailAddress
	 *            the ecEmailAddress to set
	 */
	public void setEcEmailAddress(String ecEmailAddress) {
		this.ecEmailAddress = ecEmailAddress;
	}

	/**
	 * public method setAge - sets the age of the user
	 * 
	 * @param age
	 *            of the user
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * private method calculateAge - calculates age of the user
	 * 
	 * @param dob
	 * @return The calculated age
	 */
	private int calculateAge(Date dob) {
		Date currentDate = new Date();
		int calcAge = currentDate.getYear() - dob.getYear();
		if (currentDate.getMonth() < dob.getMonth())
			calcAge--;
		else if ((currentDate.getMonth() == dob.getMonth())
				&& (currentDate.getDay() < dob.getDay()))
			calcAge--;

		return calcAge;
	}
	public class MailingAddress {

		/**
		 * private field street - will hold the street portion of the user address
		 */
		private String street="";

		/**
		 * private field city - will hold the city portion of the user address
		 */
		private String city="";
		/**
		 * private field state - will hold the state portion of the user address
		 */
		private String state="";
		/**
		 * private field zipCode - will hold the zip code portion of the user
		 * address
		 */
		private int zipCode=0;

		/**
		 * public constructor - creates a blank address
		 */
		public MailingAddress() {
			setStreet("");
			setCity("");
			setState("");
			setZipCode(-1);
		}

		/**
		 * public constructor - will create an address with the following
		 * information:
		 * 
		 * @param street
		 *            The street address of the user
		 * @param city
		 *            The city the user lives in
		 * @param zipcode
		 *            The zip code of the user.
		 */
		public MailingAddress(String street, String city, String state, int zipcode) {
			setStreet(street);
			setCity(city);
			setState(state);
			setZipCode(zipcode);
		}

		/**
		 * public method getStreet - will return the street portion of the user
		 * address.
		 * 
		 * @return the street
		 */
		public String getStreet() {
			return street;
		}

		/**
		 * public method setStreet - Sets the street portion of the user address.
		 * 
		 * @param street
		 *            the street portion of the use address to set
		 */
		public void setStreet(String street) {
			this.street = street;
		}

		/**
		 * private method toString - will generate a string representation of the
		 * the date.
		 */
		@Override
		public String toString() {
			return getStreet() + "\n" + getCity() + ", " + getState() + " "
					+ getZipCode();
		}

		/**
		 * public method getCity - Will return the city portion of the user address.
		 * 
		 * @return the city
		 */
		public String getCity() {
			return city;
		}

		/**
		 * public method setCity - sets the city portion of the user address.
		 * 
		 * @param city
		 *            the city portion of the user address to set
		 */
		public void setCity(String city) {
			this.city = city;
		}

		/**
		 * private method get state - will return the state portion of the user
		 * address.
		 * 
		 * @return the state
		 */
		public String getState() {
			return state;
		}

		/**
		 * private method setState - sets the state portion of the user address.
		 * 
		 * @param state
		 *            the state to set
		 */
		public void setState(String state) {
			this.state = state;
		}

		/**
		 * public method getZipCode - Will return the zip code portion of the user
		 * address.
		 * 
		 * @return the zipCode
		 */
		public int getZipCode() {
			return zipCode;
		}

		/**
		 * public method setZipCode - Sets the zipcode portion of the user address.
		 * 
		 * @param zipCode
		 *            the zipCode portion of user address to set
		 */
		public void setZipCode(int zipCode) {
			this.zipCode = zipCode;
		}
		
	}
	/**
	 * public method getJobTitle - will return the job title of the provider
	 * 
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * public method setJobTitle - sets the job title of the provider
	 * 
	 * @param jobTitle
	 *            the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getName()=" + getName()
				+ ", getMiddleName()=" + getMiddleName() + ", getLastName()="
				+ getLastName() + ", getDateOfBirth()=" + getDateOfBirth()
				+ ", getMaritialStatus()=" + getMaritialStatus()
				+ ", getUserAddress()=" + getUserAddress()
				+ ", getPrimaryPhone()=" + getPrimaryPhone()
				+ ", getSecondaryPhone()=" + getSecondaryPhone()
				+ ", getPrimaryEmail()=" + getPrimaryEmail()
				+ ", getSecondaryEmail()=" + getSecondaryEmail()
				+ ", getEcFirstName()=" + getEcFirstName()
				+ ", getEcLastName()=" + getEcLastName()
				+ ", getEcPhoneNuber()=" + getEcPhoneNuber()
				+ ", getEcEmailAddress()=" + getEcEmailAddress()
				+ ", getJobTitle()=" + getJobTitle() + "]";
	}

}

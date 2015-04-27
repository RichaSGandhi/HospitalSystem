package com.group7.hms.Users;

/**
 * public class Providers - stores and handles the provider specific information
 * @author Jacob Christensen
 *
 */
public class Providers extends User {


	

	/**
	 * private field degree - stores the degree of the Provider
	 */
	private String degree="";

	/**
	 * private field specialization - stores the specialization of the Provider
	 */
	private String specialization="";

	/**
	 * private field certification - stores the certification of the provider
	 */
	private String certification="";

	/**
	 * private field experience - stores the experience level of the provider
	 */
	private int experience=0;

	/**
	 * private field department - stores the department information of the
	 * provider
	 */
	private String department="";

	/**
	 * private field affiliation - stores the affiliation of the provider.
	 */
	private String affiliation="";
	

	// TODO implement the Shift/Availability and Holidays
	private String availableDays="";

	public String getAvailableHours() {
		return availableHours;
	}
	
	public void setAvailableHours(String availableHours) {
		this.availableHours = availableHours;
	}
	private String availableHours="";
	public String getAvailableDays() {
		return availableDays;
	}
	/**
	 * public constructor - minimal constructor
	 * 
	 * @param applicantEmail
	 *            - the email address of the provider
	 * @param applicantPassword
	 *            - the projected email address of the provider
	 */
	public Providers(){
		super();
	}
	public Providers(String applicantEmail, String applicantPassword, String role, String name) {	
		super(applicantEmail, applicantPassword,role,name);

	}

	/**
	 * public constructor - maximal constructor
	 * 
	 * @param applicantEmail
	 *            - the email address of the provider
	 * @param applicantPassword
	 *            - the projected password of the provider
	 * @param jobTitle
	 *            - the job title of the provider
	 * @param degree
	 *            - the degree of the provider
	 * @param specailization
	 *            - the specialization of the provider.
	 * @param certificaion
	 *            - the certification of the provider.
	 * @param department
	 *            - the department of the provider.
	 * @param affiliation
	 *            - the affiliation of the provider
	 */
	/*public Providers(String applicantEmail, String applicantPassword,
			String jobTitle, String degree, String specailization,
			String certificaion, String department, String affiliation) {
		//super(applicantEmail, applicantPassword,jobTitle,);
		setJobTitle(jobTitle);
		setDegree(degree);
		setSpecalization(specailization);
		setCertification(certificaion);
		setDepartment(department);
		setAffiliation(affiliation);

	}*/

	

	/**
	 * public method setDegree - will return the degree of the provider
	 * 
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * public method setDegree - will set the degree of the provider
	 * 
	 * @param degree
	 *            the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * public method getSpecailization - will return the specialization of the
	 * provider
	 * 
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}

	/**
	 * public method setSpecailization - will set the specialization of the
	 * provider
	 * 
	 * @param specalization
	 *            the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/**
	 * public method getCertification - will return the certification of the
	 * provider
	 * 
	 * @return the certification
	 */
	public String getCertification() {
		return certification;
	}

	/**
	 * public method setCertification - will set the certification of the
	 * provider
	 * 
	 * @param certification
	 *            the certification to set
	 */
	public void setCertification(String certification) {
		this.certification = certification;
	}

	/**
	 * public method getExperience - will return the experience of the provider
	 * 
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * public method setExperience - will set the experience of the provider
	 * 
	 * @param experience
	 *            the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * public method getDepartment - will return the department of the provider
	 * 
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * public method setDepartment - will set the department of the provider
	 * 
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * public method getAffiliation - will return the affiliation of the
	 * provider
	 * 
	 * @return the affiliation
	 */
	public String getAffiliation() {
		return affiliation;
	}

	/**
	 * public method setAffilifation - will set the affiliation of the provider
	 * 
	 * @param affiliation
	 *            the affiliation to set
	 */
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public void setAvailableDays(String days) {
		// TODO Auto-generated method stub
		this.availableDays =days;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Providers [getAvailableHours()=" + getAvailableHours()
				+ ", getAvailableDays()=" + getAvailableDays()
				+ ", getDegree()=" + getDegree() + ", getSpecialization()="
				+ getSpecialization() + ", getCertification()="
				+ getCertification() + ", getExperience()=" + getExperience()
				+ ", getDepartment()=" + getDepartment()
				+ ", getAffiliation()=" + getAffiliation()
				+ ", getMobilePhoneNumber()=" + getMobilePhoneNumber()
				+ ", getSex()=" + getSex() + ", getEcPhoneNumber()="
				+ getEcPhoneNumber() + ", getStatus()=" + getStatus()
				+ ", getAge()=" + getAge() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getName()="
				+ getName() + ", getMiddleName()=" + getMiddleName()
				+ ", getLastName()=" + getLastName() + ", getDateOfBirth()="
				+ getDateOfBirth() + ", getMaritialStatus()="
				+ getMaritialStatus() + ", getUserAddress()="
				+ getUserAddress() + ", getPrimaryPhone()=" + getPrimaryPhone()
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

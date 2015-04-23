package com.group7.hms.Users;

/**
 * public class Administrator - will hold and handle the Administrator specific
 * information
 * 
 * @author Jacob Christensen
 *
 */
public class Administrator extends User {

	/**
	 * private field jobTitle - The job title that the Administrator holds
	 */
	private String jobTitle="";
	/**
	 * private field degree - The degree that the Administrator holds
	 */
	private String degree="";
	/**
	 * private field certifications - The certifications that the Administrator
	 * holds
	 */
	private String certifications="";
	/**
	 * private field specializations - The specializations that the
	 * Administrator holds.
	 */
	private String specializations="";
	/**
	 * private field department - The department the Administrator belongs to.
	 */
	private String department="";

	public Administrator(){
		super();
	}
	// TODO Implement shift/Availability and Holidays
	/**
	 * public constructor - minimal constructor
	 * 
	 * @param applicantEmail
	 *            - applicants email address
	 * @param applicantPassword
	 *            - applicants proposed email address
	 */
	public Administrator(String applicantEmail, String applicantPassword,String role,String name) {
		super(applicantEmail, applicantPassword,role,name);

	}

	/**
	 * public constructor - complete constructor
	 * 
	 * @param applicantEmail
	 *            - applicants email
	 * @param applicantPassword
	 *            - applicants proposed password
	 * @param jobTitle
	 *            - the job title of the administrator
	 * @param degree
	 *            - the degree of the administrator
	 * @param certifications
	 *            - the certifications of the administrator.
	 * @param specailizations
	 *            - the specializations of the administrator.
	 * @param department
	 *            - the department of the administrator.
	 */
	/*public Administrator(String applicantEmail, String applicantPassword,
			String jobTitle, String degree, String certifications,
			String specailizations, String department) {
		super(applicantEmail, applicantPassword,jobTitle);
		//setJobTitle(jobTitle);
		setDegree(degree);
		setCertifications(certifications);
		setSpecailizations(specailizations);
		setDepartment(department);
	}*/

	/**
	 * public method getJobTitle - will return the job title of the
	 * Administrator.
	 * 
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	@Override
	public String toString() {
		return "Administrator ["+ super.toString()+"getJobTitle()=" + getJobTitle()
				+ ", getDegree()=" + getDegree() + ", getCertifications()="
				+ getCertifications() + ", getSpecailizations()="
				+ getSpecailizations() + ", getDepartment()=" + getDepartment()
				+ "]";
	}
	/**
	 * public method setJobTitle - Sets the job title of the Administrator.
	 * 
	 * @param jobTitle
	 *            the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * public method getDegree - will return the degree the Administrator holds.
	 * 
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * public method setDegree - Sets the degree the Administrator holds.
	 * 
	 * @param degree
	 *            the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * public method getCertification - will return the certification the
	 * Administrator holds.
	 * 
	 * @return the certifications
	 */
	public String getCertifications() {
		return certifications;
	}

	/**
	 * public method setCertifications - Sets the certifications the
	 * Administrators hold.
	 * 
	 * @param certifications
	 *            the certifications to set
	 */
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

	/**
	 * public method getSpecailizations - will return the specializations of the
	 * administrator
	 * 
	 * @return the specializations
	 */
	public String getSpecailizations() {
		return specializations;
	}

	/**
	 * public method setSpecailizations - Sets the specializations of the
	 * administrator.
	 * 
	 * @param specailizations
	 *            the specializations to set
	 */
	public void setSpecailizations(String specailizations) {
		this.specializations = specailizations;
	}

	/**
	 * public method getDepartment - will return the department of the
	 * Administrator
	 * 
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * private method setDepartment - sets the department of the Administrator.
	 * 
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

}

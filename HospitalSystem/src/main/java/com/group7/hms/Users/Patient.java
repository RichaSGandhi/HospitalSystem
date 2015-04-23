package com.group7.hms.Users;

import java.util.Date;;

/**
 * public class Patient extends User - will hold the Patient specific
 * information
 * 
 * @author Jacob Christensen
 *
 */
public class Patient extends User {

	/**
	 * private field patientInsurance - will hold the information of the
	 * patients insurance
	 */
	private Insurance patientInsurance;

	public Patient(){
		super();
		patientInsurance = new Insurance();
	}
	/**
	 * public constructor - the minimal constructor
	 * 
	 * @param applicantEmail
	 *            - the patients email address.
	 * @param applicantPassword
	 *            - the projected patient password.
	 */
	public Patient(String applicantEmail, String applicantPassword, String role, String name) {
		super(applicantEmail, applicantPassword, role,name);
		patientInsurance = new Insurance();
	}

	/**
	 * public constructor - maximal constructor
	 * 
	 * @param applicantEmail
	 *            - the patients email address
	 * @param applicantPassword
	 *            - the projected patient password
	 * @param provider
	 *            - the Name of the Insurance provider
	 * @param startDate
	 *            - the the start date of the insurance policy
	 * @param endDate
	 *            - the end date of the insurance policy
	 * @param insuranceID
	 *            - the insurance policy ID
	 */
	/*public Patient(String applicantEmail, String applicantPassword,
			String provider, Date startDate, Date endDate,
			String insuranceID, String role) {
		super(applicantEmail, applicantPassword,role);
		patientInsurance = new Insurance(provider, startDate, endDate,
				insuranceID);
	}
*/
	/**
	 * public method getInsuranceProvider - will return the patients insurance
	 * provider
	 * 
	 * @return Patient Insurance Provider
	 */
	public String getInsuranceProvider() {
		return patientInsurance.getProvider();
	}

	/**
	 * public method setInsuranceProvider - will set the patients insurance
	 * provider
	 * 
	 * @param provider
	 *            - patients insurance provider
	 */
	public void setInsuranceProvider(String provider) {
		patientInsurance.setProvider(provider);
	}

	/**
	 * public method getInsuranceStartDate - will return the insurance policy
	 * start date of the patient
	 * 
	 * @return start date of the insurance policy
	 */
	public Date getInsuranceStartDate() {
		return patientInsurance.getStartDate();
	}

	/**
	 * public method getInsuranceEndDate - will return the insurance policy end
	 * date of the patient insurance policy
	 * 
	 * @return end date of the insurance policy
	 */
	public Date getInsuranceEndDate() {
		return patientInsurance.getEndDate();
	}

	/**
	 * public method setInsuranceStartDate - will set the the start date for the
	 * insurance policy
	 * 
	 * @param startDate
	 *            - The start date of the insurance policy
	 */
	public void setInsuranceStartDate(Date startDate) {
		patientInsurance.setStartDate(startDate);
	}

	/**
	 * public method setInsuranceEndDate - will set the end date for the
	 * insurance policy
	 * 
	 * @param endDate
	 *            - The end date of the insurance policy
	 */
	public void setInsuranceEndDate(Date endDate) {
		patientInsurance.setEndDate(endDate);
	}

	/**
	 * public method setInsuranceID - will set the insurance ID for the patient
	 * insurance policy
	 * 
	 * @param insuranceID
	 */
	public void setInsuranceID(String insuranceID) {
		patientInsurance.setInsuranceID(insuranceID);
	}

	/**
	 * public method getInsuranceID - will return the insurance id for the patient ploicy
	 * @return insuranceID for patient policy
	 */
	public String getInsuranceID() {
		return patientInsurance.getInsuranceID();
	}

	/**
	 * private class Insurance - will hold and handle the patient insurance
	 * information. This class will help encapsulate and keep all the
	 * information in one location
	 * 
	 * @author Jacob Christensen
	 *
	 */
	private class Insurance {

		private String provider="";
		private Date startDate = new Date();
		private Date endDate = new Date();
		private String insuranceID="";

		/**
		 * public constructor - minimal constructor
		 */
		public Insurance() {

		}

		/**
		 * public constructor - maximal constructor
		 * 
		 * @param provider
		 *            - Name of the insurance provider
		 * @param startDate
		 *            - Start Date of the Insurance coverage
		 * @param endDate
		 *            - End Date of insurance Coverage
		 * @param insuranceID
		 *            - insurance ID of the Insured.
		 */
		public Insurance(String provider, Date startDate,
				Date endDate, String insuranceID) {
			setProvider(provider);
			setStartDate(startDate);
			setEndDate(endDate);
			setInsuranceID(insuranceID);
		}

		/**
		 * public method getProvider - will return the name of the insurance
		 * provider
		 * 
		 * @return the provider
		 */
		public String getProvider() {
			return provider;
		}

		/**
		 * public method setPovider - will set the name of the insurance
		 * provider
		 * 
		 * @param provider
		 *            the provider to set
		 */
		public void setProvider(String provider) {
			this.provider = provider;
		}

		/**
		 * public method getStartDate - will return the start date of the
		 * insurance policy
		 * 
		 * @return the startDate
		 */
		public Date getStartDate() {
			return startDate;
		}

		/**
		 * public method setStartDate - will set the start date of the Insurance
		 * policy
		 * 
		 * @param startDate
		 *            the startDate to set
		 */
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		/**
		 * public method getEndDate - will return the end date of the insurance
		 * policy
		 * 
		 * @return the endDate
		 */
		public Date getEndDate() {
			return endDate;
		}

		/**
		 * public method setEndDate - will set the endDate of the insurance
		 * policy
		 * 
		 * @param endDate
		 *            the endDate to set
		 */
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		/**
		 * public method getInsuranceID - will return the insurance id for the
		 * Insured Patient
		 * 
		 * @return the insuranceID
		 */
		public String getInsuranceID() {
			return insuranceID;
		}

		/**
		 * public method setInsuranceID - will set the insurance Id of the
		 * Insured Patient.
		 * 
		 * @param insuranceID
		 *            the insuranceID to set
		 */
		public void setInsuranceID(String insuranceID) {
			this.insuranceID = insuranceID;
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Patient [getInsuranceProvider()=" + getInsuranceProvider()
				+ ", getInsuranceStartDate()=" + getInsuranceStartDate()
				+ ", getInsuranceEndDate()=" + getInsuranceEndDate()
				+ ", getInsuranceID()=" + getInsuranceID() + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword()
				+ ", getName()=" + getName() + ", getMiddleName()="
				+ getMiddleName() + ", getLastName()=" + getLastName()
				+ ", getDateOfBirth()=" + getDateOfBirth()
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

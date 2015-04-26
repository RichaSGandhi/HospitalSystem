package com.group7.hms.salary;

import java.util.Calendar;

import com.group7.hms.Users.Administrator;
import com.group7.hms.Users.Providers;
import com.group7.hms.Users.User;
import com.group7.hms.dao.UserDAOImpl;

public class Salary {

	// The doctor calculation variables
	private static final int docBase = 100000;
	private static final int docAppBase = 10;

	// the nurse calculation variables
	private static final int nurseBase = 50000;
	private static final int nurseAppBase = 2;

	// the admin calculation variables
	private static final int adminBase = 75000;

	// the experience calculation factor
	// 5% raise per year double at 20 years
	private static final double expFactor = 0.05;

	private double calculatedSalary;

	private int appointments;
	private double departmentFactor;
	private int experience;

	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * @return the appointments
	 */
	public int getAppointments() {
		return appointments;
	}

	/**
	 * @param appointments
	 *            the appointments to set
	 */
	public void setAppointments(int appointments) {
		this.appointments = appointments;
	}

	/**
	 * @return the calculatedSalary
	 */
	public double getCalculatedSalary() {
		return calculatedSalary;
	}

	/**
	 * @param calculatedSalary
	 *            the calculatedSalary to set
	 */
	public void setCalculatedSalary(double calculatedSalary) {
		this.calculatedSalary = calculatedSalary;
	}

	/**
	 * @return the docbase
	 */
	public static int getDocbase() {
		return docBase;
	}

	/**
	 * @return the docappbase
	 */
	public static int getDocappbase() {
		return docAppBase;
	}

	/**
	 * @return the nursebase
	 */
	public static int getNursebase() {
		return nurseBase;
	}

	/**
	 * @return the nurseappbase
	 */
	public static int getNurseappbase() {
		return nurseAppBase;
	}

	/**
	 * @return the adminbase
	 */
	public static int getAdminbase() {
		return adminBase;
	}

	/**
	 * @return the expfactor
	 */
	public static double getExpfactor() {
		return expFactor;
	}



	public Salary(Providers user) {
		UserDAOImpl dao = new UserDAOImpl();
		setAppointments(dao.getNumberAppointments(user));
		setExperience(user.getExperience());

		if (user.getJobTitle().equalsIgnoreCase("doctor")) {
			setCalculatedSalary((getDocbase() * (1 + (getExpfactor() * getExperience())))
					+ (getAppointments() * (1 + getDepartmentFactor()) * getDocappbase()));
		} else if (user.getJobTitle().equalsIgnoreCase("nurse")) {
			setCalculatedSalary((getNursebase() * (1 + (getExpfactor() * getExperience())))
					+ (getAppointments() * (1 + getDepartmentFactor()) * getNurseappbase()));
		}

	}

	public Salary(Administrator user) {
		setExperience(user.getExperience());

		setCalculatedSalary((getAdminbase() * (1 + (getExpfactor() * getExperience()))));

	}

	public double getDepartmentFactor() {
		return departmentFactor;
	}

	public void setDepartmentFactor(double departmentFactor) {
		this.departmentFactor = departmentFactor;
	}

}

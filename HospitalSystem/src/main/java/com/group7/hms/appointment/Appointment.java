
package com.group7.hms.appointment;

import java.sql.Date;
import java.sql.Time;

import org.hibernate.validator.constraints.NotEmpty;
public class Appointment {

	@Override
	public String toString() {
		return "Appointment [appointment=" + appointment + ", day=" + day
				+ ", startTime=" + startTime + ", appId=" + appId + ", cost="
				+ cost + ", docNotes=" + docNotes + ", endTime=" + endTime
				+ ", appDate=" + appDate + ", doctor=" + doctor + ", nurse="
				+ nurse + ", patient=" + patient + ", doctorName=" + doctorName
				+ ", nurseName=" + nurseName + ", patientName=" + patientName
				+ "]";
	}

	@NotEmpty
	private String appointment;
	private String day;
	private Time startTime;
	private int appId;
	private int cost;
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDocNotes() {
		return docNotes;
	}

	public void setDocNotes(String docNotes) {
		this.docNotes = docNotes;
	}

	private String docNotes;
	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getNurse() {
		return nurse;
	}

	public void setNurse(String nurse) {
		this.nurse = nurse;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	private Time endTime;
	private Date appDate;
	private String doctor;
	private String nurse;
	private String patient;
	private String doctorName;
	private String nurseName;
	private String patientName;
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}

	public String getAppointment(){
		return appointment;
	}
	
	public void setAppointment(String appointment){
		this.appointment=appointment;
	}
}


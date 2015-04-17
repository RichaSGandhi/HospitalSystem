package com.group7.hms.appointment;

import org.hibernate.validator.constraints.NotEmpty;
public class Appointment {

	@NotEmpty
	private String appointment;
	private String day;
	
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

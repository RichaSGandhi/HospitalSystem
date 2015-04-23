package com.group7.hms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.group7.hms.Users.*;
import com.group7.hms.appointment.Appointment;


@Service
public class AppointmentDAO{

	private DataSource dataSource;	
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("Datasource set");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}


	public List<Appointment> getAppointments(String emailaddress, String role)
	{
		String sql =  null;
		List<Appointment> appList = new ArrayList<Appointment>();
		if (role.equalsIgnoreCase("Patient"))
			sql = "Select * from HospitalManagement.appointments where Patient = ? "
					+ "ORDER BY appDate DESC ";	
		else if (role.equalsIgnoreCase("Doctor"))
			sql = "Select * from HospitalManagement.appointments where attendingDoc = ? "
					+ "ORDER BY appDate DESC ";	
		else if (role.equalsIgnoreCase("Nurse"))
			sql = "Select * from HospitalManagement.appointments where attendingNurse = ?"
					+ "ORDER BY appDate DESC ";
		else 
			sql = "Select * from HospitalManagement.appointments order by appDate ASC";
	
	Connection conn = null;

	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","jacob"); 
		PreparedStatement ps = conn.prepareStatement(sql);
		if(!(role.equalsIgnoreCase("Admin"))){
			ps.setString(1, emailaddress);
		}
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Appointment app = new Appointment();
			app.setDay(rs.getString("appDay"));
			app.setStartTime(rs.getTime("startTime"));
			app.setEndTime(rs.getTime("endTime"));
			app.setAppDate(rs.getDate("appDate"));
			app.setDoctor(rs.getString("attendingDoc"));
			app.setDoctorName(rs.getString("DoctorName"));
			app.setNurse(rs.getString("attendingNurse"));
			app.setNurseName(rs.getString("NurseName"));
			app.setPatient(rs.getString("patient"));
			app.setPatientName(rs.getString("patientName"));
			appList.add(app);
			
		}

	} catch (SQLException e) {
		throw new RuntimeException(e);

	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	return appList;
	}


	
}

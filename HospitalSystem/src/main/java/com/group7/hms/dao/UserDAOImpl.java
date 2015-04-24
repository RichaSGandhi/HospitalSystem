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
public class UserDAOImpl implements UserDAO {

	private DataSource dataSource;	
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("Datasource set");
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

@Override
	public void updateUser(String emailaddress,String password, String fName, String lName,
			String phoneNumber, String street, String state,String zip)
	{
	String sql = "UPDATE USERS SET password =" + password +" , fName = " + fName +", lName = "
	+ lName +" , phoneNumber = "+ phoneNumber +", street = "+street +", state = "+state +
	", zip = " +zip +" WHERE email = "+ emailaddress;
	
	Connection conn = null;

	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.executeUpdate();
		ps.close();

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
	}


	//new user
	@Override
	public void setUser(User user) throws SQLException {

		String sql = "INSERT INTO hospitalmanagement.Users "
				+ "(username, emailid, password, role,name,status) VALUES (?, ?, ?, ?,?,?)";
		Connection conn = null;

		try {
			//conn = dataSource.getConnection();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","jacob"); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPrimaryEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getJobTitle());
			ps.setString(5, user.getName());
			ps.setString(6, "InActive");

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw e;

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public User getUserName(String email) {

		String sql = "SELECT * FROM hospitalmanagement.Users WHERE emailId = ?";

		Connection conn = null;

		try {
			System.out.println("trying to get connection");
			 //User user = jdbcTemplateObject.queryForObject(sql, 
                  //   email, new StudentMapper());
			//conn = dataSource.getConnection();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","jacob"); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			//String[] sendInfo = new String[3];
			
			ResultSet rs = ps.executeQuery();
			String role = null;
			if (rs.next()) {
				role = rs.getString("Role");
			
			if(role.equalsIgnoreCase("Doctor")||role.equalsIgnoreCase("Nurse")){
				Providers user = new Providers();
				user.setName(rs.getString("Name"));
				user.setPrimaryEmail(rs.getString("emailId"));
				user.setJobTitle(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				return user;
			}else if (role.equalsIgnoreCase("Admin")){
				Administrator user = new Administrator();
				user.setName(rs.getString("Name"));
				user.setPrimaryEmail(rs.getString("emailId"));
				user.setJobTitle(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				return user;
			}else if (role.equalsIgnoreCase("Patient")){
				Patient user=  new Patient();
				user.setName(rs.getString("Name"));
				user.setPrimaryEmail(rs.getString("emailId"));
				user.setJobTitle(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				
				return user;
			}
			}
		
			rs.close();
			ps.close();
			return null;
			 
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
	

		// return "Test Name";
	}
	
	@Override
	public List<Providers> getDoctorInfo(String dept) {

		String sql = "SELECT * FROM hospitalmanagement.Users WHERE department = ?";
		List<Providers> docList = new ArrayList<Providers>();
		Connection conn = null;

		try {
			System.out.println("trying to get connection");
			 //User user = jdbcTemplateObject.queryForObject(sql, 
                  //   email, new StudentMapper());
			//conn = dataSource.getConnection();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","jacob"); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dept);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Providers doc = new Providers();
				doc.setPrimaryEmail(rs.getString("emailId"));
				doc.setName(rs.getString("name"));
				doc.setAffiliation(rs.getString("affiliation"));
				doc.setDegree(rs.getString("degree"));
				doc.setSpecialization(rs.getString("specialization"));
				//doc.setExperience(rs.getString("experience"));
				doc.setAvailableDays(rs.getString("availableDays"));
				docList.add(doc);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		for(Providers a:docList){
			System.out.println(a);
		}
		return docList;
	}
	@Override
	public Providers getDoctorDetails(String email){
		String sql = "SELECT * FROM hospitalmanagement.Users WHERE emailId = ?";

		Connection conn = null;
		Providers doc = new Providers();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","jacob"); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				doc.setName(rs.getString("name"));
				doc.setAvailableDays(rs.getString("availableDays"));
				doc.setPrimaryEmail(email);
		}}catch(SQLException e){
			e.printStackTrace();
		}
		return doc;
	}
	
	@Override
	public void resetPassword(String emailAddress, String password) {
		String sql = "UPDATE USERS SET password = ? WHERE email = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emailAddress);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException(e);
	}

}

	@Override
	public User getUser(String email) {
		String sql = "SELECT * FROM hospitalmanagement.Users WHERE emailId = ?";
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","jacob"); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				if(rs.getString("Role").equalsIgnoreCase("Doctor")){
					Providers doctor = new Providers(email,rs.getString("Password"),rs.getString("Role"),rs.getString("Name"));
					return doctor;
				}
				else if (rs.getString("Role").equalsIgnoreCase("Patient")){
					Patient patient = new Patient(email,rs.getString("Password"),rs.getString("Role"),rs.getString("Name"));
					return patient;
				}
				else if (rs.getString("Role").equalsIgnoreCase("Admin")){
					Administrator admin = new Administrator(email,rs.getString("Password"),rs.getString("Role"),rs.getString("Name"));
					return admin;
				}
				
		}}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	public void createAppointmemt(Appointment app){

		String sql = "INSERT INTO hospitalmanagement.Appointments "
				+ "(startTime, endTime, appDate, attendingDoc,attendingNurse,patient) VALUES (?, ?, ?, ?,?,?)";
		String sqlNurse = "Select * from hospitalmanagement.users" 
				+"where role =?";
		Connection conn = null;

		try {
			//conn = dataSource.getConnection();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","jacob"); 
			
			PreparedStatement ps = conn.prepareStatement(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void updateUser(User user) throws SQLException{
		String sql = "INSERT INTO hospitalmanagement.Users "
				+ "(username, emailid, password, role,name,status) VALUES (?, ?, ?, ?,?,?)";
		Connection conn = null;

		try {
			//conn = dataSource.getConnection();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","jacob"); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPrimaryEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getJobTitle());
			ps.setString(5, user.getName());
			ps.setString(6, "InActive");

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw e;

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	
}

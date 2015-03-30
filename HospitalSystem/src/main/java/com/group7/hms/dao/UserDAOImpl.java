package com.group7.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.group7.hms.Users.*;


@Service
public class UserDAOImpl implements UserDAO {

	private DataSource dataSource;
	//private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		//this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

@Override
	public void updateUser(String emailaddress,String password, String fName, String lName, String phoneNumber, String street, String state,
			String zip)
	{
	String sql = "UPDATE USERS SET password =" + password +" , fName = " + fName +", lName = "+ lName +" , phoneNumber = "+ phoneNumber 
			+", street = "+street +", state = "+state +", zip = " +zip +" WHERE email = "+ emailaddress;
	
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
	public void setUser(String email, String password, String fName,
			String lName, String phoneNumber, String street, String state,
			String zip, String answer1, String answer2, String answer3) {

		String sql = "INSERT INTO USERS "
				+ "(email, password, fName, lName, phoneNumber, street, state, zip, answer1, answer2, answer3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, fName);
			ps.setString(4, lName);
			ps.setString(5, phoneNumber);
			ps.setString(6, street);
			ps.setString(7, state);
			ps.setString(8, zip);
			ps.setString(9, answer1);
			ps.setString(10, answer2);
			ps.setString(11, answer3);

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

	@Override
	public String getUserName(String email) {

		String sql = "SELECT * FROM hospitalmanagement.login WHERE email = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			User user = null;
			ResultSet rs = ps.executeQuery();
			String name= null;
			if (rs.next()) {
				name = rs.getString("fName");
				//user = new User();
				//user.setEmail(email);
				//user.setfName(rs.getString("fName"));
			}
			rs.close();
			ps.close();
			return name;

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
}

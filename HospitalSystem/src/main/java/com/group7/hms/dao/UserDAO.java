package com.group7.hms.dao;

import java.util.Map;

import com.group7.hms.Users.*;

public interface UserDAO {



	public String getUserName(String email);

	public void setUser(String email, String password, String fName,
			String lName, String phoneNumber, String street, String state,
			String zip, String answer1, String answer2, String answer3);

	public void updateUser(String email, String password, String fName,
			String lName, String phoneNumber, String street, String state,
			String zip);
	
	//public Map getUserPreferences(String email);

	//public void blockUser(String emailAddress);

	public void resetPassword(String emailAddress, String password);

}

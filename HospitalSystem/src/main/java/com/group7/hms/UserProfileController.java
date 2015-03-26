package com.group7.hms;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.group7.hms.Users.Administrator;
import com.group7.hms.Users.Patient;
import com.group7.hms.Users.Providers;
import com.group7.hms.Users.User;


/**
 * 
 * @author Richa Gandhi
 *
 */
@Controller

public class UserProfileController {
	private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String newUser(Locale locale, Model model) {
		logger.info("Accessing the new User Signup page.");

		model.addAttribute("viewName", "newUser");

		return "signup";
	}
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String createUser(
			Locale locale,
			Model model,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password,
			@RequestParam(value = "role", defaultValue = "") String role

	) {

		logger.info("Attempting to create new user.");

		User user = null;
		if(role.equalsIgnoreCase("Doctor")||role.equalsIgnoreCase("Nurse")){
			user = new Providers(email,password);

		}else if(role.equalsIgnoreCase("Patient")){
			user = new Patient(email,password);

		}if(role.equalsIgnoreCase("Admin")){
			user = new Administrator(email,password);

		}
		

		model.addAttribute("user", user);

		model.addAttribute("email", email);

		//model.addAttribute("viewName", "signupEmailConfirmation");

		return "signupEmailConfirmation";
	}

	
	
	


}

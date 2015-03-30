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
import com.group7.hms.dao.UserDAOImpl;
import com.group7.hms.service.SendEmail;


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

		model.addAttribute("viewName", "signup");

		return "masterpage";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(Locale locale, Model model) {
		logger.info("Accessing the new User Login page.");

		model.addAttribute("viewName", "login");

		return "masterpage";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginSubmit(Locale locale, Model model,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password) {
		logger.info("Logging in");
		UserDAOImpl dao = new UserDAOImpl();
		String name = dao.getUserName(email);
		if (name==null){
			model.addAttribute("ErrorMsg", "Account doesn't exist, Please Signup");
			model.addAttribute("viewName", "signup");
			return "masterpage";
		}
		else{
		model.addAttribute("name", name);
		model.addAttribute("viewName", "Profile");
		return "masterpage";
		}
	}
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String createUser(
			Locale locale,
			Model model,
			@RequestParam(value = "name", defaultValue = "") String name,
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

		}else{
			model.addAttribute("ErrorMsg", "Role does not exist");
			model.addAttribute("viewName", "signup");
			return "masterpage";
		}
		logger.info("Here Printing " + role + " " + email + " " + password +" "+name);
		logger.info("new user object created." + role + " " + email + " " + password);
		//model.addAttribute("user", user);
		//model.addAttribute("email", email);;
		logger.info("Mail Object Created");
		boolean answer = SendEmail.generateAndSendEmail(email,name);
		logger.info("" +answer);
		model.addAttribute("name", name);
		model.addAttribute("viewName", "signupEmailConfirmation");
		return "masterpage";
	}

	
	
	


}

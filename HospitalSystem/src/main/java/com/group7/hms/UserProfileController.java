package com.group7.hms;

import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.group7.hms.Users.Administrator;
import com.group7.hms.Users.Patient;
import com.group7.hms.Users.Providers;
import com.group7.hms.Users.User;
import com.group7.hms.dao.UserDAO;
import com.group7.hms.dao.UserDAOImpl;
import com.group7.hms.service.SendEmail;

/**
 * 
 * @author Richa Gandhi
 *
 */
@Controller
public class UserProfileController {
	private static final Logger logger = LoggerFactory
			.getLogger(UserProfileController.class);
	UserDAO daoObject = new UserDAOImpl();

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

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String LoginSubmit(Locale locale, Model model,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password) {
		logger.info("Logging in");
		UserDAOImpl dao = new UserDAOImpl();
		String[] info = dao.getUserName(email);
		if (info[0] == null) {
			model.addAttribute("ErrorMsg",
					"Account doesn't exist, Please Signup");
			model.addAttribute("viewName", "signup");

		} else if (null == info[2] || ("InActive").equalsIgnoreCase(info[2])) {
			return "redirect:/updateProfile";
		} else if (("active").equalsIgnoreCase(info[2])) {
			model.addAttribute("name", info[0]);
			model.addAttribute("role", info[1]);
			model.addAttribute("email", email);
			model.addAttribute("viewName", "Profile");
		}
		return "masterpage";

	}

	// Sign-up Submit Method
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
		if (role.equalsIgnoreCase("Doctor") || role.equalsIgnoreCase("Nurse")) {
			user = new Providers(email, password, role, name);

		} else if (role.equalsIgnoreCase("Patient")) {
			user = new Patient(email, password, role, name);

		} else if (role.equalsIgnoreCase("Admin")) {
			user = new Administrator(email, password, role, name);

		}
		try {
			daoObject.setUser(user);

			logger.info("Here Printing " + role + " " + email + " " + password
					+ " " + name);
			logger.info("new user object created." + role + " " + email + " "
					+ password);
			// model.addAttribute("user", user);
			// model.addAttribute("email", email);;
			logger.info("Mail Object Created");
			boolean answer = SendEmail.generateAndSendEmail(email, name);
			logger.info("" + answer);
			model.addAttribute("name", name);
			model.addAttribute("viewName", "signupEmailConfirmation");
		} catch (SQLException e) {
			model.addAttribute("ErrorMsg",
					"Account already Exists, Please Login");
			model.addAttribute("viewName", "signup");
		}

		return "masterpage";
	}

	@RequestMapping(value = "/makeAppointment", method = RequestMethod.GET)
	public String makeAppointment(
			Locale locale,
			Model model,
			@RequestParam(value = "department", defaultValue = "General") String department) {
		System.out.println("Im here 1");
		List<Providers> docList = daoObject.getDoctorInfo(department);
		System.out.println("Im here 2");
		// String[] info = daoObject.getUserName(email);
		// model.addAttribute("role", info[1]);
		model.addAttribute("viewName", "makeAppointment");
		model.addAttribute("doctorList", docList);
		return "masterpage";
	}

	/*
	 * @RequestMapping(value = "/makeAppointmentAjax", method =
	 * RequestMethod.POST) public @ResponseBody Providers
	 * makeAppointmentAjax(Locale locale, Model model,
	 * 
	 * @RequestParam(value = "department", defaultValue = "General") String
	 * department){ List<Providers> docList =
	 * daoObject.getDoctorInfo(department);
	 * System.out.println("Im here n ajax"); //model.addAttribute("viewName",
	 * "makeAppointment"); //model.addAttribute("doctorList", docList); //return
	 * "masterpage"; Providers x=null; for(Providers a : docList){ x = a; }
	 * return x; }
	 */

	@RequestMapping(value = "/makeAppointment", method = RequestMethod.POST, params = "search")
	public String searchDocs(
			Locale locale,
			Model model,
			@RequestParam(value = "department", defaultValue = "") String department) {
		List<Providers> docList = daoObject.getDoctorInfo(department);
		model.addAttribute("viewName", "makeAppointment");
		model.addAttribute("doctorList", docList);
		// return "redirect:/makeAppointment";
		return "masterpage";
	}

	@RequestMapping(value = "processSelectionProfile", method = RequestMethod.POST)
	public String porcessProfilePost(@RequestParam String action,
			@RequestParam(value = "email", defaultValue = "") String email,
			Model model) {
		if(action.equalsIgnoreCase("updateProfile")){
			logger.info("User:" + email +" requests to update their profile page");
			UserDAOImpl daoObject = new UserDAOImpl();
			String[] info = daoObject.getUserName(email);
			model.addAttribute("username",email);
			model.addAttribute("name", info[0]);
			model.addAttribute("role", info[1]);
			model.addAttribute("viewName", "updateProfile");
			
		}
		return "masterpage";

	}

}

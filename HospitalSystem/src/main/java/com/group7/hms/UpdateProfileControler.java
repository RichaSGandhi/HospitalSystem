package com.group7.hms;

import java.sql.SQLException;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.group7.hms.Users.Administrator;
import com.group7.hms.Users.Patient;
import com.group7.hms.Users.Providers;
import com.group7.hms.Users.User;
import com.group7.hms.dao.UserDAOImpl;

@Controller
public class UpdateProfileControler {
	private static final Logger logger = LoggerFactory
			.getLogger(UpdateProfileControler.class);

	/*
	 * @RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
	 * public String updateProfile(Locale locale, Model model,
	 * 
	 * @RequestParam(value = "email", defaultValue = "") String email) {
	 * 
	 * logger.info("User:" + email +" requests to update their profile page");
	 * 
	 * 
	 * UserDAOImpl daoObject = new UserDAOImpl(); String[] info =
	 * daoObject.getUserName(email); model.addAttribute("username",email);
	 * model.addAttribute("name", info[0]); model.addAttribute("role", info[1]);
	 * model.addAttribute("viewName", "updateProfile"); return "masterpage"; }
	 */

	@RequestMapping("/processUpdateProfile")
	public String processUpdateProfile(
			@Valid @ModelAttribute("user") User user, BindingResult result) {
		return "masterpage";
	}

	@RequestMapping("/processUpdatePatientProfile")
	public String procecessUpdatePatientProfile(
			@Valid @ModelAttribute("patient") Patient patient,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			System.out.println("Has Errors");
			model.addAttribute("viewName", "home");
		} else {
			UserDAOImpl dao = new UserDAOImpl();
			try {
				dao.updatePatient(patient);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//RedirectAttributesModelMap ra = new RedirectAttributesModelMap();
		//ra.addFlashAttribute("email", patient.getUsername());
		return "redirect:/profile?email="+patient.getUsername();

	}

	@RequestMapping("/processUpdateProviderProfile")
	public String procecessUpdateProviderProfile(
			@Valid @ModelAttribute("provider") Providers provider,
			BindingResult result) {
		
		UserDAOImpl dao = new UserDAOImpl();
		try {
			dao.updateProvider(provider);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(provider);
		//RedirectAttributesModelMap ra = new RedirectAttributesModelMap();
		//ra.addFlashAttribute("email", provider.getUsername());
		return "redirect:/profile?email="+provider.getUsername();

	}

	@RequestMapping("/processUpdateAdminProfile")
	public String procecessUpdateAdminProfile(Model model,
			@Valid @ModelAttribute("admin") Administrator admin,
			BindingResult result) {
		System.out.println(admin);
		UserDAOImpl dao = new UserDAOImpl();
		try {
			dao.updateAdmin(admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(admin);
		System.out.println("redirect:/profile?email="+admin.getUsername());
		//RedirectAttributesModelMap ra = new RedirectAttributesModelMap();
		//ra.addFlashAttribute("email", admin.getPrimaryEmail());
		return "redirect:/profile?email="+admin.getUsername();
		
	}
}

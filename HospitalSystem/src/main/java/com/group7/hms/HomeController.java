package com.group7.hms;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({ "user" })
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("viewName", "home");

		
		//model.addAttribute("serverTime", formattedDate );
		model.addAttribute("welcomeMessage", "Welcome to Hospital Management System By Group 7 : Richa");
		
		return "masterpage";
	}
	@RequestMapping(value ="/logout", method= RequestMethod.GET)
	public String logout(Model model){
		
		model.addAttribute("viewName", "home");
		model.addAttribute("welcomeMessage","Thanks for using the Hospital Management System By Group 7");
		return "masterpage";
	}
	
}

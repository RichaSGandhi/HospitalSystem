package com.group7.hms;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.group7.hms.Users.Providers;
import com.group7.hms.appointment.Appointment;
import com.group7.hms.dao.AppointmentDAO;
import com.group7.hms.dao.UserDAOImpl;
import com.group7.hms.service.SendEmail;

@Controller
public class AppointmentController {
	/*
	 * @RequestMapping(value ="/scheduleAppointment", method =RequestMethod.GET
	 * ) public String schedlueAppointment(Model model, Locale locale){
	 * 
	 * 
	 * //model.addAttribute("appointments",appointments);
	 * //model.addAttribute("viewname", "scheduleAppointment");
	 * 
	 * return "masterpage"; }
	 */
	// @ModelAttribute("dayList")
	AppointmentDAO daoObject = new AppointmentDAO();

	public List<String> getDayList(String avaliableDays) {

		// TODO Generate the logic to generate the dayList based on the
		// available days from database
		List<String> generatedDayList = new ArrayList<String>();
		String[] days = avaliableDays.split(",");
		for (String i : days) {
			if (i.equalsIgnoreCase("m")) {
				generatedDayList.add("Monday");
			} else if (i.equalsIgnoreCase("t")) {
				generatedDayList.add("Tuesday");
			} else if (i.equalsIgnoreCase("w")) {
				generatedDayList.add("Wednesday");
			} else if (i.equalsIgnoreCase("th")) {
				generatedDayList.add("Thursday");
			} else if (i.equalsIgnoreCase("f")) {
				generatedDayList.add("Friday");
			}

		}

		// hard code
		List<String> dayList = new ArrayList<String>();
		dayList.add("Monday");
		dayList.add("Tuesday");
		dayList.add("Wednesday");
		dayList.add("Thursday");
		dayList.add("Friday");

		for (String i : dayList) {
			System.out.println(i);
		}

		return generatedDayList;
	}

	// @ModelAttribute("appointmentList")
	public List<String> getAppointmentList(String avaliableAppointments) {

		// TODO Generate Logic to create the appointmentsList based on the
		// available appointments from database
		List<String> appointmentsList = new ArrayList<String>();
		for (int i = 9; i < 17; i++) {
			String aMpM = (i < 12) ? "AM" : "PM";
			appointmentsList.add(Integer.toString((i > 12) ? (i % 12)
					: (i % 13))
					+ ":00-"
					+ Integer.toString((i > 13) ? (i % 12) : (i % 13))
					+ ":59 "
					+ aMpM);
		}

		for (String i : appointmentsList) {
			System.out.println(i);
		}
		return appointmentsList;

	}

	@RequestMapping("/scheduleAppointment")
	public String scheduleAppointment(Model model, String email) {

		UserDAOImpl dao = new UserDAOImpl();
		Providers doctor = dao.getDoctorDetails(email);

		Appointment app = new Appointment();
		List<String> appointments = getAppointmentList(doctor
				.getAvailableHours());
		List<String> days = getDayList(doctor.getAvailableDays());
		model.addAttribute("doctorName", doctor.getName());
		model.addAttribute("doctoremail", email);
		model.addAttribute("appointmentList", appointments);
		model.addAttribute("dayList", days);
		model.addAttribute("app", app);
		model.addAttribute("viewName", "scheduleAppointment");

		return "masterpage";
	}

	@RequestMapping("/processAppointment")
	public String processForm(@Valid @ModelAttribute("app") Appointment app,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("inside error block");
			model.addAttribute("viewName", "scheduleAppointment");
			return "masterpage";
		} else {
			// TODO generate A confirmation Email
			// boolean sent =
			// SendEmail.generateAndSendEmailAppointmentConfimation(email, name,
			// app.getDay()+" "+app.getAppointment());
			System.out.println("Appointment Sucessfully scheduled: "
					+ app.getDay() + " " + app.getAppointment()
					+ "\nConfirmation Email Has been Sent");
			model.addAttribute("viewName", "appointmentSuccess");
			return "masterpage";
		}
	}


	@RequestMapping(value = "/updateAppointment", method = RequestMethod.POST)
	public String updateAppointment(
			Locale locale,
			Model model,
			@RequestParam(value = "doctorNotes", defaultValue = "") String doctorNotes,
			@RequestParam(value = "cost", required = false) int cost,
			@RequestParam(value = "save", defaultValue = "") String save,
			@RequestParam(value = "release", defaultValue = "") String release,
			@RequestParam(value = "appId", required = false) int appId,
			@RequestParam(value = "patientEmail", defaultValue = "") String patientEmail) {
		//if(save.isEmpty()){
			//daoObject.releasePatient(patientEmail);
		//}else if(release.isEmpty()){
			//daoObject.saveAppointmentRecord(doctorNotes,cost, appId);
		//}
		System.out.println("I AM IN UPDATE PROFILE");
		model.addAttribute("viewName","home");
		return "masterpage";


		//return "redirect:/Profile";

	}
}

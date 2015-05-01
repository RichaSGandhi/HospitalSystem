package com.group7.hms;

import java.sql.Time;
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

import com.group7.hms.Users.Patient;
import com.group7.hms.Users.Providers;
import com.group7.hms.Users.User;
import com.group7.hms.appointment.Appointment;
import com.group7.hms.dao.AppointmentDAO;
import com.group7.hms.dao.UserDAO;
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
	UserDAO userDaoObject = new UserDAOImpl();
	public List<String> getDayList(String avaliableDays) {

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
			} else if (i.equalsIgnoreCase("s")) {
				generatedDayList.add("Saturday");
			} else if (i.equalsIgnoreCase("sun")) {
				generatedDayList.add("Sunday");
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
	public List<String> getAppointmentTimes(String avaliableHours,
			List<Appointment> appointmentList) {

		String[] split = avaliableHours.split(",");
		String startHourStr = split[0];
		String endHourStr = split[1];
		int startHour = Integer.parseInt(startHourStr.substring(0, 1));
		int endHour = Integer.parseInt(endHourStr.substring(0, 1));
		startHour = (startHourStr.contains("am")) ? (startHour)
				: (startHour + 12);
		endHour = (endHourStr.contains("am")) ? (endHour) : (endHour + 12);
		List<String> appointmentsList = new ArrayList<String>();
		for (int i = startHour; i < endHour; i++) {
			if (!appointmentList.isEmpty()) {
				for (Appointment app : appointmentList) {
					java.sql.Time testTime = java.sql.Time
							.valueOf(i + ":00:00");
					if (!app.getStartTime().equals(testTime)) {
						String aMpM = (i < 12) ? "AM" : "PM";
						appointmentsList.add(Integer
								.toString((i > 12) ? (i % 12) : (i % 13))
								+ ":00-"
								+ Integer.toString((i > 13) ? (i % 12)
										: (i % 13)) + ":59 " + aMpM);
					}
				}
			}
			else{
				String aMpM = (i < 12) ? "AM" : "PM";
				appointmentsList.add(Integer
						.toString((i > 12) ? (i % 12) : (i % 13))
						+ ":00-"
						+ Integer.toString((i > 13) ? (i % 12)
								: (i % 13)) + ":59 " + aMpM);
			}
		}

		for (String i : appointmentsList) {
			System.out.println(i);
		}
		return appointmentsList;

	}

	@RequestMapping("/scheduleAppointment")
	public String scheduleAppointment(Model model, String email,String docEmail ) {

		UserDAOImpl dao = new UserDAOImpl();

		//Providers doctor = dao.getDoctorDetails(email);
		
		AppointmentDAO appDao = new AppointmentDAO();
		Providers doctor = (Providers) dao.getUser(docEmail);


		Appointment app = new Appointment();
		List<String> appointments = getAppointmentTimes(
				doctor.getAvailableHours(),
				appDao.getAppointments(doctor.getUsername(),
						doctor.getJobTitle()));
		List<String> days = getDayList(doctor.getAvailableDays());
		User userInfo = userDaoObject.getUserName(email);
		model.addAttribute("user", userInfo);
		model.addAttribute("doctorName", doctor.getName());
		model.addAttribute("doctorEmail", docEmail);
		model.addAttribute("patientEmail", email);
		model.addAttribute("appointmentList", appointments);
		model.addAttribute("dayList", days);
		model.addAttribute("app", app);
		model.addAttribute("viewName", "scheduleAppointment");

		return "masterpage";
	}

	@RequestMapping("/processAppointment")
	public String processForm(@Valid @ModelAttribute("app") Appointment app,
			BindingResult result, Model model, String doctorEmail, String patientEmail ) {
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
			System.out.println(doctorEmail);
			System.out.println(patientEmail);
			app.setDoctor(doctorEmail);
			app.setPatient(patientEmail);
			
			Patient patient = (Patient) new UserDAOImpl().getUser(patientEmail);
			Providers provider = (Providers) new UserDAOImpl().getUser(doctorEmail);
			
			app.setDoctorName(provider.getName());
			app.setPatientName(patient.getName());
			int appointmentTime = Integer.parseInt(app.getAppointment().substring(0, 1));
			app.setStartTime(java.sql.Time.valueOf(appointmentTime+":00:00"));
			app.setEndTime(java.sql.Time.valueOf(appointmentTime+":59:00"));
			daoObject.createAppointment(app);
			
			return "masterpage";
		}
	}

	@RequestMapping(value = "/updateAppointment", method = RequestMethod.GET)
	public String updateAppointment(
			Locale locale,
			Model model,
			@RequestParam(value = "doctorNotes", defaultValue = "") String doctorNotes,
			@RequestParam(value = "cost", required = false) int cost,
			@RequestParam(value = "save", defaultValue = "") String save,
			@RequestParam(value = "release", defaultValue = "") String release,
			@RequestParam(value = "appId", required = false) int appId,
			@RequestParam(value = "patientEmail", defaultValue = "") String patientEmail,
			@RequestParam(value = "email", defaultValue = "") String email) {
		if(!save.isEmpty()){
			daoObject.saveAppointmentRecord(doctorNotes,cost, appId);
			
		}else if(!release.isEmpty()){
			daoObject.releasePatient(patientEmail);
		}
		else{
			System.out.println("SOME THING WENT WRONG");
		}

		//model.addAttribute("viewName", "home");
		//return "masterpage";

		return "redirect:/profile?email="+email;

	}
}

package com.group7.hms.service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Richa Gandhi
 *
 */

public class SendEmail {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	private static final Logger logger = LoggerFactory.getLogger(SendEmail.class);
	public SendEmail() //throws AddressException, MessagingException 
	{
		logger.info("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
		//generateAndSendEmail();
		
	}
 
	public static boolean generateAndSendEmail(String to, String name) //throws AddressException, MessagingException 
	{
		try{
//Step1		
	 logger.info("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.host", "smtp.gmail.com");
		System.out.println("Mail Server Properties have been setup successfully..");
 
//Step2		
		logger.info("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getInstance(mailServerProperties, new GmailAuthenticator("richa1gandhi@gmail.com", "satnamwahaguru12345"));
		generateMailMessage = new MimeMessage(getMailSession);
		//generateMailMessage.setFrom(new InternetAddress("richa1gandhi@gmail.com"));
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		//generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("richa-gandhi@uiowa.edu"));
		generateMailMessage.setSubject("Please activate your account");
		String emailBody = "Hi, " +name+ "! Please follow this link activate your account and login http://localhost:8080/hms/login<br><br> Regards, <br>Richa Gandhi<br>Group 7<br> Hospital Management System";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
//Step3		
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
		
		// Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
		//transport.connect("smtp.gmail.com");
		//transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		//transport.close();
		Transport.send(generateMailMessage);
		return true;
	}catch (Exception e){
		logger.info("IN CATCH");
		e.printStackTrace();
		return false;
	}
	} 
}
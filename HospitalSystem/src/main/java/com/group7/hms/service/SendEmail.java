package com.group7.hms.service;

import java.util.*;
import javax.mail.*;
//import javax.mail.MessagingException;
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
 
public class SendEmail {
 
	public static void main(String[] args) {
 
		final String username = "username@gmail.com";
		final String password = "password";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("to-email@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
/**
 * 
 * @author Richa Gandhi
 *

public class SendEmail
{
	 
    String to ;
    String from ;  
    String host ;
    Properties properties;
    Session session;
    MimeMessage message;
   
	public SendEmail(String to,String subject, String messageText){
    	  // Recipient's email ID needs to be mentioned.
		try{
    	  this.to = to;
    	  // Assuming you are sending email from localhost
    	  this.host = "localhost";
    	  // Sender's email ID needs to be mentioned
    	  this.from = "richa1gandhi@gmail.com";
    	  // Get system properties
    	  this.properties = System.getProperties();
    	  // Get the default Session object.
    	  this.session = Session.getDefaultInstance(properties);
    	  // Create a default MimeMessage object.
          this.message = new MimeMessage(session);
          // Set From: header field of the header.
         System.out.println("Mail setting done");
          
          message.setFrom(new InternetAddress(from));
          // Set To: header field of the header.
          message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
         // Set Subject: header field
         message.setSubject(subject);
         // Now set the actual message
         message.setText(messageText);
         System.out.println("Meassage Set");
         // Send message"
          }catch (Exception mex) {
        	  System.out.println("In exception -------> Richa");
 	         mex.printStackTrace();
 		 }
        
   }
	public boolean sendMail(){
		 try{
			 Transport.send(message);
			 System.out.println("Sent message successfully....");
			 return true;
	         
		 }catch (MessagingException mex) {
	         mex.printStackTrace();
	         return false;
		 }
}
}

/*import java.util.Properties;

import javax.mail.Message;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.group7.hms.UserProfileController;
 
/**
 * @author Crunchify.com
 * 

 
public class SendEmail {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	private static final Logger logger = LoggerFactory.getLogger(SendEmail.class);
	public SendEmail() //throws AddressException, MessagingException 
	{
		logger.info("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
		generateAndSendEmail();
		
	}
 
	public static boolean generateAndSendEmail() //throws AddressException, MessagingException 
	{
		logger.info("Reaching here");
		try{
//Step1		
	 logger.info("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
//Step2		
		logger.info("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.setFrom(new InternetAddress("richa1gandhi@gmail.com"));
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("richa-gandhi@uiowa.edu"));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("richa-gandhi@uiowa.edu"));
		generateMailMessage.setSubject("Greetings from Crunchify..");
		String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
//Step3		
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		//Transport transport = getMailSession.getTransport("smtp");
		
		// Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
		//transport.connect("smtp.gmail.com", "richa1gandhi@gmail.com", "satnamwahaguru12345");
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
}*/
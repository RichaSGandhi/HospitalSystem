package com.group7.hms.service;

import java.util.*;
import javax.mail.*;
import javax.mail.MessagingException;
import javax.mail.internet.*;
import javax.activation.*;
/**
 * 
 * @author Richa Gandhi
 *
 */
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
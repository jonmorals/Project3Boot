package project3.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.PasswordAuthentication;

/*
 * class with method to send an email
 */
public class Email {

	//The "From" fields for an existing GMAIL account:
		public static final String from ="revature.pages@gmail.com";
		public static final String username ="revature.pages@gmail.com";
		public static final String password ="p4ssw0rd$123";
		
		
		public static void sendEmail(String to, String text, String subject){
			//GMAIL server properties
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,password);
						}
					});

				try {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(from));
					message.setRecipients(Message.RecipientType.TO, 
							InternetAddress.parse(to));
					message.setSubject(subject);
					message.setContent(text, "text/html; charset=utf-8");
//					message.setText(text);

					Transport.send(message);

					System.out.println("Message sent!");

				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
			}

}


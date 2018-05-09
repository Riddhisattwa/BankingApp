package com.mybankapp.misc;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailsender {
	final static String host="smtp.gmail.com";
	final static String username = "mylabgroup2@gmail.com";
	final static String password = "riku95devil";
public static boolean sendmail(String message,String to) {
	try {
		Properties properties=new Properties();
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.socketFactory.port", "587");
		properties.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		Session session=Session.getInstance(properties,new Authenticator() {
		protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			return new javax.mail.PasswordAuthentication(username, password);
		}
		});
		MimeMessage mimeMessage=new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress(username));
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		mimeMessage.setSubject("Testing");
		mimeMessage.setText(message);
		Transport.send(mimeMessage);
		return true;
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return false;
	
}
}

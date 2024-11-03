package com.SpringProject.email.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public interface EmailService {
	public void sendEmail(String to, String subject, String text) throws MessagingException,  UnsupportedEncodingException;
	
	public String randomCode();
	
	public String createEmailContent(String randomCode);

}

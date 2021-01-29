package com.bmw.sell.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.net.Authenticator;

public class MailAuth extends Authenticator {
	String username = null;
	String password = null;
	public MailAuth(String username,String password)
	{
		this.username=username;
		this.password=password;
	}
	public PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(username,password);
	}

}

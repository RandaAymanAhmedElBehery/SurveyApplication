package com.SurveyApplication.Models;

public class User {
	
	private String userName;
	private String email;
	private String password;
	private String SessionID ; 
	
	public User(String userName, String email, String password) 
	{
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
		
	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getSessionID() 
	{
		return SessionID;
	}

	public void setSessionID(String sessionID)
	{
		SessionID = sessionID;
	}
	
	

}
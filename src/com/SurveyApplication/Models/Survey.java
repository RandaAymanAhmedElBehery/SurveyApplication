package com.SurveyApplication.Models;

public class Survey {
	
	private String surveyName ;
	private String creatorEmail	;
    private boolean isClosed ;
    private boolean isSuspended ;
    
	public Survey(String surveyName, String creatorEmail, boolean isClosed, boolean isSuspended)
	{
		super();
		this.surveyName = surveyName;
		this.creatorEmail = creatorEmail;
		this.isClosed = isClosed;
		this.isSuspended = isSuspended;
	}
	
	public String getSurveyName() 
	{
		return surveyName;
	}
	
	public void setSurveyName(String surveyName) 
	{
		this.surveyName = surveyName;
	}
	
	public String getCreatorEmail() 
	{
		return creatorEmail;
	}
	
	public void setCreatorEmail(String creatorEmail) 
	{
		this.creatorEmail = creatorEmail;
	}
	
	public boolean isClosed() 
	{
		return isClosed;
	}
	
	public void setClosed(boolean isClosed) 
	{
		this.isClosed = isClosed;
	}
	
	public boolean isSuspended()
	{
		return isSuspended;
	}
	
	public void setSuspended(boolean isSuspended) 
	{
		this.isSuspended = isSuspended;
	}
    
    

}

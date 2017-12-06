package com.SurveyApplication.Models;

public class Report 
{
	
	private String reportUser;
	private String reportMsg;
	private String reportedSurvey;
	private String reportedSurveyCreator;
	
	public Report(String reportUser, String reportMsg, String reportedSurvey, String reportedSurveyCreator) 
	{
		super();
		this.reportUser = reportUser;
		this.reportMsg = reportMsg;
		this.reportedSurvey = reportedSurvey;
		this.reportedSurveyCreator = reportedSurveyCreator;
	}

	public String getReportUser() 
	{
		return reportUser;
	}
	
	public void setReportUser(String reportUser)
	{
		this.reportUser = reportUser;
	}
	
	public String getReportMsg() 
	{
		return reportMsg;
	}
	
	public void setReportMsg(String reportMsg) 
	{
		this.reportMsg = reportMsg;
	}
	
	public String getReportedSurvey() 
	{
		return reportedSurvey;
	}
	
	public void setReportedSurvey(String reportedSurvey) 
	{
		this.reportedSurvey = reportedSurvey;
	}
	
	public String getReportedSurveyCreator() 
	{
		return reportedSurveyCreator;
	}
	
	public void setReportedSurveyCreator(String reportedSurveyCreator) 
	{
		this.reportedSurveyCreator = reportedSurveyCreator;
	}
	

}

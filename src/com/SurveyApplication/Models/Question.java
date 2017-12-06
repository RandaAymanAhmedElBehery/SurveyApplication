package com.SurveyApplication.Models;

public class Question 
{
	private String question;
	private String type ;
	private String[] choices;

	public Question(String question, String type, String[] choices)
	{
		super();
		this.question = question;
		this.type = type;
		this.choices = choices;
	}
	
	public String getQuestion() 
	{
		return question;
	}
	
	public void setQuestion(String question) 
	{
		this.question = question;
	}
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String[] getChoices() 
	{
		return choices;
	}
	
	public void setChoices(String[] choices)
	{
		this.choices = choices;
	} 
	
	
}

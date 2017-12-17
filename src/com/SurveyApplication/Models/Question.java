package com.SurveyApplication.Models;

import java.util.ArrayList;

public class Question 
{
	private String question;
	private String type ;
	private ArrayList<String> choices;

	public Question(String question, String type, ArrayList<String> choices)
	{
		super();
		this.question = question;
		this.type = type;
		this.choices = choices;
	}
	
	public Question() {
		super();
		this.question="";
		this.type="";
		this.choices = new ArrayList<String>();
		
		
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
	
	public ArrayList<String> getChoices() 
	{
		return choices;
	}
	
	public void setChoices(ArrayList<String> choices)
	{
		this.choices = choices;
	} 
	
	
}

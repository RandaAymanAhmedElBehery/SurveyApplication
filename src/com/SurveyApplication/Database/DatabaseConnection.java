package com.SurveyApplication.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	
	private Connection connection;
	
	void connect()
	{
			setConnection(null);
		try{
			setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/SurveyApplication?"+
					"user=root&password=&characterEncoding=utf8"));
			
		}
		catch(SQLException Ex)
		{
			Ex.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	
}

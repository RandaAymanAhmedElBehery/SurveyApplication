package com.SurveyApplication.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	
	private Connection conn;
	
	public void connect()
	{
		
		try
		{
			this.conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/SurveyApplication", "root","root");
		}
		catch(SQLException Ex)
		{
			Ex.printStackTrace();
		}
	}

	public Connection getConnection() {
		connect();
		return conn;
	}

	public void setConnection(Connection connection) {
		this.conn = connection;
	}

	
}

package com.SurveyApplication.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SurveyApplication.Database.DatabaseConnection;

/**
 * Servlet implementation class SurveyController
 */
@WebServlet("/GetUserSurveys")
public class GetUserSurveys extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserSurveys() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		DatabaseConnection dbConn = new DatabaseConnection() ;
		dbConn.connect(); 
		Connection conn = dbConn.getConnection();
		
		String query = "select * from Surveys where CreatorEmail = '" + email + "';" ;
		
		try
		{
			PreparedStatement stmt = conn.prepareStatement(query);
        	ResultSet rs = stmt.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.SurveyApplication.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		HttpSession session = request.getSession(true);
		String email = (String)request.getAttribute("email");
		
		DatabaseConnection dbConn = new DatabaseConnection() ;
		dbConn.connect(); 
		Connection conn = dbConn.getConnection();
		
		String query = "select surveyName from Surveys where CreatorEmail = '" + email + "';" ;
    	ArrayList<String> Surveys = new ArrayList<String>();
		try
		{
			PreparedStatement stmt = conn.prepareStatement(query);
        	ResultSet rs = stmt.executeQuery();
        	while(rs.next())
        	{
        		Surveys.add(rs.getString("surveyName"));
        	}
        	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		session.setAttribute("userSurveys",Surveys);
		
		response.sendRedirect("UserProfile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

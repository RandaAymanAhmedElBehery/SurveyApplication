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

import org.omg.CORBA.portable.RemarshalException;

import com.SurveyApplication.Database.DatabaseConnection;
import com.SurveyApplication.Models.Survey;

/**
 * Servlet implementation class getAllSurveys
 */
@WebServlet("/getAllSurveys")
public class getAllSurveys extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllSurveys() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String  q= " select surveyName,isSuspended,isClosed from Surveys";
		DatabaseConnection dbc = new DatabaseConnection();
		dbc.connect();
		ArrayList<Survey> surveys = new ArrayList<Survey>();
		Connection c = dbc.getConnection();
		try {
			PreparedStatement  ps = c.prepareStatement(q);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				Survey s  = new Survey();
				s.setClosed(rs.getBoolean("isClosed"));
				s.setSuspended(rs.getBoolean("isSuspended"));
				s.setSurveyName(rs.getString("surveyName"));
				surveys.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("Surveys", surveys);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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

import com.SurveyApplication.Database.DatabaseConnection;

/**
 * Servlet implementation class GetStatistics
 */
@WebServlet("/GetStatistics")
public class GetStatistics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStatistics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String surveyName = request.getParameter("surveyName");
		String email = request.getParameter("creatorEmail");
		
		DatabaseConnection dbc = new  DatabaseConnection();
		Connection conn = dbc.getConnection();
		
		ArrayList<Integer> freq  = new ArrayList<Integer>();  
		String query = "select count(questionNumber) from Questions where surveyName = '" + surveyName + "' and "
				+ "creatorEmail = '" + email + "';";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);
		
			ResultSet rs = stmt.executeQuery() ;
			
			if (rs.next())
			{
				for (int i=1 ; i<rs.getInt(0)+1 ; i++)
				{
					query = "select count(*) from answeredQuestions where questionNumber = " + i
							+ " and creatorEmail = '" + email + "' and surveyName = '" + surveyName
							+ "' ;";
					stmt = conn.prepareStatement(query);
					rs = stmt.executeQuery() ;
					if (rs.next())
						freq.add(rs.getInt(0));
				}
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ViewStatistics.jsp?data=" + freq);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

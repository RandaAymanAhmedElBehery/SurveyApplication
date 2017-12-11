package com.SurveyApplication.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SurveyApplication.Database.DatabaseConnection;
import com.SurveyApplication.Models.Question;
import com.SurveyApplication.Models.Survey;

/**
 * Servlet implementation class AddSurvey
 */
@WebServlet("/AddSurvey")
public class AddSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSurvey() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void addQuestion(String survey , String email ,Question q)
	{
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		String query = "insert into question values( '" + /*Question ID*/ + "' , '" + q.getQuestion() + "','" + q.getType() + "','" + survey + "','" + email +"');" ;
		PreparedStatement stmt = conn.prepareStatement("query");
		stmt.executeUpdate();
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Survey survey = (Survey) session.getAttribute("survey");
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		String query = "insert into Surveys values ();";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

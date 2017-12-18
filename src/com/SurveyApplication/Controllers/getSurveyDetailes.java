package com.SurveyApplication.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class getSurveyDetailes
 */
@WebServlet("/getSurveyDetailes")
public class getSurveyDetailes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getSurveyDetailes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String surveyName = (String) request.getParameter("surveyName");
		String creatorEmail = (String) request.getParameter("email");
		Survey s= new Survey();
		String q = "select questionType , question , questionNumber from Questions where creatorEmail='"+creatorEmail+"' and surveyName ='"+surveyName+"' ";
		DatabaseConnection dbc = new DatabaseConnection();
		dbc.connect();
		Connection c= dbc.getConnection();
		ArrayList<Question> questions = new ArrayList<Question>();
		
		try {
			PreparedStatement ps =c.prepareStatement(q);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				Question question = new Question();
				 question.setQuestion(rs.getString("question"));
				 question.setType(rs.getString("questionType"));
				 q="select choice from choices where questionNumber='"+(int)rs.getInt("questionNumber")+"'";
				 ps=c.prepareStatement(q);
				 ResultSet internal= ps.executeQuery();
				 ArrayList<String> choices = new ArrayList<String>();
				 while(internal.next())
				 {
					 choices.add(internal.getString("choice"));
				 }
				 question.setChoices(choices);
				 questions.add(question);				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("fillSurvey.jsp");
		session.setAttribute("questions", questions);
		session.setAttribute("surveyName", surveyName);
		session.setAttribute("creatorEmail", creatorEmail);
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

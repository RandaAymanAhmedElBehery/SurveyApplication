package com.SurveyApplication.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public void addChoices(String survey, String email ,Question q , int qNum)
    {
    	DatabaseConnection dbc = new DatabaseConnection() ;
		Connection conn = dbc.getConnection();
		
    	for (int i=0 ; i<q.getChoices().size() ; i++)
    	{
    		String query = "insert into choices values('"+ q.getChoices().get(i) + "'," + qNum
    						+ ",'" + survey + "','" + email + ");";
    		try {
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	}
    }
    
	public void addQuestions(String survey , String email ,ArrayList<Question> q )
	{
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();
		
		for (int i=0 ; i<q.size();  i++)
		{
			String query = "insert into question values( '" + (i+1) + "' , '" + q.get(i).getQuestion() + "','" + q.get(i).getType() + "','" + survey + "','" + email +"');" ;
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(query);
				stmt.executeUpdate();
				
				if (!(q.get(i).getType().equals("text")))
				{
					addChoices(survey, email, q.get(i), (i+1));
				}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
		String query = "insert into Surveys values ('" + survey.getSurveyName() + "','"
						+ survey.getCreatorEmail()+  "', false,false);";
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addQuestions(survey.getSurveyName(), survey.getCreatorEmail(), survey.getQuestions());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

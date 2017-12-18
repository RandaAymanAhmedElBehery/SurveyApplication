package com.SurveyApplication.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

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

	public void addChoices(String survey, String email, Question q, int qNum) {
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();

		for (int i = 0; i < q.getChoices().size(); i++) {
			String query = "insert into choices values('" + q.getChoices().get(i) + "'," + qNum + ",'" + survey + "','"
					+ email + ");";
			try {
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void addQuestions(String survey, String email, ArrayList<Question> q) {
		DatabaseConnection dbc = new DatabaseConnection();
		Connection conn = dbc.getConnection();

		for (int i = 0; i < q.size(); i++) {
			String query = "insert into questions values( '" + (i + 1) + "' , '" + q.get(i).getQuestion() + "','"
					+ q.get(i).getType() + "','" + survey + "','" + email + "');";
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(query);
				stmt.executeUpdate();

				if (!(q.get(i).getType().equals("text"))) {
					addChoices(survey, email, q.get(i), (i + 1));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		try {
			JSONObject jObj = new JSONObject(request.getParameter("survey")); 
			
			System.out.println(jObj);
			
			Iterator it = jObj.keys(); // gets all the keys
			if  (it.hasNext()) {

				String surveyName = (String) jObj.get("surveyName");
				System.out.println(surveyName);
				
				JSONArray jsonarray =jObj.getJSONArray("questions");
				ArrayList<Question> questions = new ArrayList<Question>();
				
				for (int i = 0; i < jsonarray.length(); i++) {
				    JSONObject jsonobject = jsonarray.getJSONObject(i);
				    String question = jsonobject.getString("question");
				    String type = jsonobject.getString("type");
				    
					JSONArray jsonarray2 = jsonobject.getJSONArray("choices");
				    ArrayList<String> choices = new ArrayList<String>();
					for (int j = 0; j < jsonarray2.length(); j++) {
						JSONObject jsonobject2 = jsonarray2.getJSONObject(j);
						String choice = jsonobject2.getString("choice"+j);
						choices.add(choice);
					}
					
					questions.add( new Question(question , type , choices));
				    
				}
				Survey survey = new Survey(surveyName , (String)session.getAttribute("email") , false , false );
				survey.setQuestions(questions);
				DatabaseConnection dbc = new DatabaseConnection();
				Connection conn = dbc.getConnection();
				String query = "insert into Surveys values ('" + survey.getSurveyName() + "','"
						+ session.getAttribute("email") + "', false,false);";

				PreparedStatement stmt;
				try {
					stmt = conn.prepareStatement(query);
					stmt.executeUpdate();
					System.out.println(query);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				addQuestions(survey.getSurveyName(), survey.getCreatorEmail(), survey.getQuestions());
				response.sendRedirect("UserProfile.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * List<Survey> surveys = new LinkedList<Survey>(); // 1. get received
		 * JSON data from request BufferedReader br = new BufferedReader(new
		 * InputStreamReader(request.getInputStream())); String json = ""; if(br
		 * != null){ json = br.readLine(); }
		 * 
		 * // 2. initiate jackson mapper ObjectMapper mapper = new
		 * ObjectMapper();
		 * 
		 * // 3. Convert received JSON to Article Survey survey =
		 * mapper.readValue(json, Survey.class);
		 * 
		 * // 4. Set response type to JSON
		 * response.setContentType("application/json");
		 * 
		 * // 5. Add article to List<Article> surveys.add(survey);
		 * 
		 * // 6. Send List<Article> as JSON to client
		 * mapper.writeValue(response.getOutputStream(), surveys);
		 */
		doGet(request, response);
	}

}

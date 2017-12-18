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
import com.SurveyApplication.Models.Report;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String email= (String) request.getParameter("email");
		String pass= (String) request.getParameter("password");
		
		DatabaseConnection dbc = new DatabaseConnection(); 
		Connection conn = dbc.getConnection();
		String query = "select * from users where email = '" +email+ "' and pass ='" + pass + "';";
		System.out.println(email);
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next())
			{
				session.setMaxInactiveInterval(3*60);
				session.setAttribute("email", email);
				if (rs.getBoolean("isAdmin") == true)
				{
					response.sendRedirect("Dashboard");
				}
				else
				{	RequestDispatcher rd= request.getRequestDispatcher("getAllSurvey");
					session.setAttribute("userName", rs.getString("userName"));
					rd.forward(request, response);
				}
			}
			else
			{
				response.sendRedirect("index.jsp");
			}
			
			
		} catch (SQLException e) {
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

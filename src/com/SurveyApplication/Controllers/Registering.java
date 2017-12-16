package com.SurveyApplication.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.SurveyApplication.Database.DatabaseConnection;

/**
 * Servlet implementation class Registering
 */
@WebServlet("/Registering")
public class Registering extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registering() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession();
		String email= (String) request.getParameter("email");
		String name= (String) request.getParameter("name");
		String password =(String) request.getParameter("password");
		//System.out.println(email+name+password);
		String q="select email from users";
		DatabaseConnection dbc = new DatabaseConnection();
		dbc.connect();
		Connection c=dbc.getConnection();
		boolean found=false;
		try {
			PreparedStatement ps= c.prepareStatement(q);
			ResultSet rs;
			rs=ps.executeQuery();
			while(rs.next())
			{
				String retrivedEmail = rs.getString("email");
				if(retrivedEmail.equals(email))
					{
						found=true;
						response.sendRedirect("index.jsp");
						break;
						
					}
			}
			if (found==false)
			{
				q="insert into users (email,userName,pass,isSuspended,isAdmin) values ('"+email+"','"+name+"','"+password+"','"+(int)0+"','"+(int)0+"')";
				ps=c.prepareStatement(q);
				ps.executeUpdate();
				
			}
			}
			catch (SQLException e) {
			// TODO Auto-generated catch block
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

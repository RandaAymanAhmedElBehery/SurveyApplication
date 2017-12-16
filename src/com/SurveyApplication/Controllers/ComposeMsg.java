//package com.SurveyApplication.Controllers;
//
//import java.io.IOException;
//import java.sql.Connection;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.SurveyApplication.Database.DatabaseConnection;
//
///**
// * Servlet implementation class QuestionController
// */
//@WebServlet("/ComposeMsg")
//public class ComposeMsg extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ComposeMsg () {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{	
//		HttpSession session = request.getSession();
//		String[] emails = (String[])request.getAttribute("emails");
//		String msg = (String) session.getAttribute("msg");
//		
//		DatabaseConnection dbc = new DatabaseConnection();
//		Connection conn = dbc.getConnection();
//		
//		for (int i=0 ; i<emails.length ; i++)
//		{
//			if (emails[i].equals(""))
//				continue; 
//			String query = "insert into messages values (" + msgID + ",'" + msg +"');" ;
//			String query2 = "insert into userMsg values (" + emails[i] + ",'" + msgID +"');" ;
//			
//			PreparedStatement stmt;
//			try 
//			{	
//				stmt = conn.prepareStatement(query);
//				stmt.executeUpdate();
//				stmt = conn.prepareStatement(query2);
//				stmt.executeUpdate();	
//			}
//			catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
//		}
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{
//		doGet(request, response);
//	}
//
//}

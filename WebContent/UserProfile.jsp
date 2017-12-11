<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@page import="com.SurveyApplication.Models.Survey" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=windows-1256">
		<title>Insert title here</title>
	</head>
	<body>
		
		<%
			
			Arraylist<Survey> surveys = (Arraylist<Survey>)session.getAttribute("userSurveys") ;
			
			for (int i=0 ; i<surveys.size() ; i++)
			{
				%>
				<h2> <%= surveys.get(i).getSurveyName(); %> </h2>
				<%
				if (surveys.get(i).getIsSuspended())
				{ %>
					<label>Suspended</label>
			<%	}
			
				if (surveys.get(i).getIsClosed())
					{ %>
						<label>Closed</label>
				<%	}
			}
			
			
		%>
		
	</body>
</html>
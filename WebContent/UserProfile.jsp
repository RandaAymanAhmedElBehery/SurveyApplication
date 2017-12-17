<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@page import="com.SurveyApplication.Models.Survey" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=windows-1256">
		<title>Insert title here</title>
	
	<script>
		
		function viewSurvey(name)
		{
			document.location.href ="getSurveyDetails?surveyName="+name;
		}
		
		function suspendSurvey(name)
		{
			document.location.href ="suspendSurvey?surveyName="+name;
		}
		
		function closeSurvey(name)
		{
			document.location.href ="closeSurvey?surveyName="+name;
		}
	
	</script>
	
	</head>
	<body>
		
		<form action="AddSurvey">
			<input type="submit" value="surveyName">
		</form>

		<form action="ChangePass">
			<input type="submit" value="changePass">
		</form>


		<form action="Logout">
			<input type="submit" value="surveyName">
		</form>
		
		<%
		
		ArrayList<Survey> surveys = (ArrayList<Survey>)session.getAttribute("userSurveys") ;
			System.out.println(surveys);
			for (int i=0 ; i<surveys.size() ; i++)
			{
				%>
					<h2 onclick="viewSurvey(<%=surveys.get(i).getSurveyName()%>)">
							 <%= surveys.get(i).getSurveyName() %> </h2>
					<%
					if (surveys.get(i).isSuspended())
					{ %>
						<label>Suspended</label>
				<%	}
				
					if (surveys.get(i).isClosed())
						{ %>
							<label>Closed</label>
					<%	}  %> 
					<button onclick = "suspendSurvey(<%=surveys.get(i).getSurveyName()%>)">Suspend</button>
					<button onclick = "closeSurvey(<%=surveys.get(i).getSurveyName()%>)" >Close</button>
					
		<%	}
			
			
		%>		
		
	</body>
</html>
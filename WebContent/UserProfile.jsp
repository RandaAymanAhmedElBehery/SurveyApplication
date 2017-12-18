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

	
	</head>
	<body>
		
		<form action="AddSurvey.jsp">
			<input type="submit" value="Add Survey">
		</form>

		<form action="ChangePass.jsp">
			<input type="submit" value="changePass">
		</form>


		<form action="Logout">
			<input type="submit" value="logout">
		</form>
		
		<%
			ArrayList<Survey> surveys = (ArrayList<Survey>)session.getAttribute("userSurveys") ;
			for (int i=0 ; i<surveys.size() ; i++)
			{
				%>
					<h2 onclick="viewSurvey(this.innerHTML)"> <%= surveys.get(i).getSurveyName() %> </h2>
					<%
					if (surveys.get(i).isSuspended())
					{ %>
						<label>Suspended</label>
				<%	}
				
					if (surveys.get(i).isClosed())
						{ %>
							<label>Closed</label>
					<%	}  %> 
					<button onclick = "suspendSurvey(this.innerHTML)">Suspend</button>
					<button onclick = "closeSurvey(this.innerHTML)" >Close</button>
					
		<%	}
			
			
		%>		

	
	<script>
		
		function viewSurvey(name)
		{
			document.location.href ="getSurveyDetailes?surveyName="+name;
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
	</body>
</html>
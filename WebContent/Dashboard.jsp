<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@page import="com.SurveyApplication.Models.Report" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=windows-1256">
		<title>Insert title here</title>
	
	</head>
	<body>
		
		<form action="Logout">
			<input type="submit" value="Logout">
		</form>
		
		<form action="AddAdmin">
			<input type="submit" value="AddAdmin">
		</form>
		
		<form action="showUsers">
			<input type="submit" value="showUsers">
		</form>
		
		<form action="ComposeMsg.jsp">
			<input type="submit" value="Compose Msg">
		</form>

		<form action="getAllSurveys">
			<input type="submit" value="show All Surveys">
		</form>

		<%
		
		ArrayList<Report> reports = (ArrayList<Report>)session.getAttribute("reports") ;
			for (int i=0 ; i<reports.size() ; i++)
			{
				%>
				<div onclick="viewSurvey(<%=reports.get(i).getReportedSurvey()%>  ,<%=reports.get(i).getReportedSurveyCreator()%>  )">
				<h3>
					<%=reports.get(i).getReportUser()%> reported the survey <%=reports.get(i).getReportedSurvey()%> which is created by <%=reports.get(i).getReportedSurveyCreator()%> 
				</h3>
				<p><%=reports.get(i).getReportMsg()%> </p>
				</div>
		<%	}
			
			
		%>	

	<script>
		
		function viewSurvey(name , email)
		{
			document.location.href ="getSurveyDetails?surveyName="+name+"&creatorEmail=" + email;
		}	
	
	</script>
			
		
	</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.SurveyApplication.Models.Survey"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="UserProfile">
	<input type="submit" value="profile">
</form>
	<%
		ArrayList<Survey> surveys = (ArrayList<Survey>) session.getAttribute("Surveys");

		for (int i = 0; i < surveys.size(); i++) {
	%>
	<button type="button" onclick="getDetailes(<%=surveys.get(i).getCreatorEmail()%>)" id=<%="survey"+i %>>
		<%=surveys.get(i).getSurveyName()%>
	</button>
	<%
		}
	%>

	<script>
function getDetailes(creator)
{
		var name = document.getElementById("survey").value;
		document.location.href="http://localhost:8080/SurveyApplication/getSurveyDetailes?surveyName='"+name+"'& creatorEmail='"+creator"'";
			
}

</script>



</body>
</html>
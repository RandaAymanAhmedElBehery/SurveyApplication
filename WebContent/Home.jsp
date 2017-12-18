<%@page import="java.util.ArrayList"%>
<%@page import="com.SurveyApplication.Models.Survey" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<button type="button" onclick="goToUserProfile()" value="<%=session.getAttribute("userName") %>" > </button>

<% ArrayList<Survey> surveys = (ArrayList<Survey>) session.getAttribute("surveys"); 

for (int i=0;i<surveys.size();i++)
{ %>
<button type="button" onclick="getDetailes(<%=surveys.get(i).getCreatorEmail()%>)" id="survey">

<% out.print(surveys.get(i).getSurveyName()); %>


</button>
<%} %>

<script>
function getDetailes(creator)
{
		var name = document.getElementById("survey").value;
		document.location.href="http://localhost:8080/SurveyApplication/getSurveyDetailes?surveyName='"+name+"'& creatorEmail='"+creator"'";
			
}
function goToUserProfile()
{
	document.location.href="http://localhost:8080/SurveyApplication/UserProfile";
		
}

</script>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.SurveyApplication.Models.Question" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% ArrayList<Question> questions = (ArrayList<Question>)session.getAttribute("questions"); 
	String surveyName=(String) session.getAttribute("surveyName");
	String creatorEmail=(String) session.getAttribute("creatorEmail");
	session.setAttribute("questionsnumbers", questions.size());
	session.setAttribute("creatorEmail", creatorEmail);

%>

<form method="get" action = "fillSurvey">

<h1><%=surveyName%>  </h1>

<%for (int i=0;i<questions.size();i++){
	
	out.print(questions.get(i).getQuestion());
	
	if(questions.get(i).getType().equals("Radio Buttons"))
		
		{
			for(int j=0;j<questions.get(i).getChoices().size();j++){
		%>
		
				<input type="radio" value=<%=questions.get(i).getChoices().get(j) %> name="ans"+i >
		
		<%}} 
		if(questions.get(i).getType().equals("Check Boxes")){
			
			session.setAttribute("qType", questions.get(i).getType());
			for(int j=0;j<questions.get(i).getChoices().size();j++){ %>
		
		
		<input type ="checkbox" value= <%=questions.get(i).getChoices().get(j) %> name="ans"+i+j) >
		
		<%}}else{  %>
		
		<input type="text" name="ans"+i>
	

<%}} %>
<input type="submit" value="fill survey" >
</form>
</body>
</html>
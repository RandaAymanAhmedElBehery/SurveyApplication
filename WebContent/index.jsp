<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Class.forName("com.mysql.jdbc.Driver");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method=get id="login">


		<input type="email" placeholder="enter your email" name="email" /> 
		<input type="password" placeholder="enter your password" name="password" />
		<input type="submit" value="login" />

	</form>


	<form id="form" action="Registering" onsubmit="return checkPass()">

		 <input type="text" placeholder="enter your name " name="name" />
		 <input type="email" placeholder="enter your email" name="email" />
		 <input	type="password" placeholder="enter your password" name="password" id="p" />
		 <input type="password" placeholder="verify your password" name="vPassword" id="vp" />
		 <input type="submit" value="Register" />

 	</form> 


	<script>
		function checkPass() {
			var password = document.getElementById("p").value;
			var varPassword = document.getElementById("vp").value;

			console.log(password);
			console.log(varPassword);
			
			if (password != varPassword) {

				window.alert("the passwords aren't matched ! ");
				document.location.href = "http://localhost:8080/SurveyApplication";

				document.getElementById("form").action="index.jsp";
			}
		}
	</script>

</body>
</html>
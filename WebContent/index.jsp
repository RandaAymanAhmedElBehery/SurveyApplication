<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <% Class.forName("com.mysql.jdbc.Driver"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method=get id="login">


<input type="email" placeholder="enter your email" name= "email"/>
<input type="password" placeholder="enter your password" name="password"/>
<input type="submit" value="login" />

</form>


<form action="Registering">

<input type = "text" placeholder= "enter your name " name = "name"/>
<input type= "email" placeholder = "enter your email" name = "email"/>
<input type= "password" placeholder= "enter your password" name ="password" id= "p"/>
<input type ="password" placeholder= "verify your password" name="vPassword" id="vp"/>
<input type="submit" value="Register"  /> 

</form>


<script>

var password = document.getElementById("p").value;
var verPassword= document.getElementById("vp").value;

if(passwor!=varPassword)
	{
		window.alret("the passwords aren't matched ! ")
		document.location.href("index.jsp")
	}

</script>

</body>
</html>
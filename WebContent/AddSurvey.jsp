<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Add Survey</title>
		<script src="js/jquery.min.js"></script>
		
	</head>
	<body>
	
		<script>
			var questionArr = [] ;
			function newQuestion()
			{
				var question ;
				question.questionTxt = document.getElementById("question").value;
				document.getElementById("question").value="";
				question.type = // select choice of dropdown menu
				if (question.type != text)
				{
					
				}	
				
			}
			
		</script>
	
		<form action="AddSurvey">
		
			<input type="text" placeholder="Survey Name" name="surveyName"/>
			<br>
			<input type="text" placeholder="Question" name="question" id="question"/>
			
			<select name="questionType" id="questionType">
				<option value = "text" >Open Answer</option>
				<option value = "radio" >One Choice(Radio Buttons)</option>
				<option value = "checkbox" >Multiple Selections(Check Boxes)</option>
			</select>
			
			<script> alert($("#questionType").html); </script>
				
			<br>
			<button value="next Question" onclick="newQuestion()">Next Question</button>
			<input type="submit" value="Save Survey">
		</form>
		
	</body>
</html>
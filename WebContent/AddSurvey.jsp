<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Add Survey</title>
				
	</head>
	<body>
		
		<script src="js/jquery.min.js" ></script>
		
		<script>
			var questionArr = [] ;
			var i = 0 ;
			var choices = [] ;
			
			function newQuestion()
			{
				questionTxt = document.getElementById("question").value;
				document.getElementById("question").value="";
				
				var questionType = document.getElementById("questionType");
				qtype = questionType.options[questionType.selectedIndex].text;

				var question = {"question" : questionTxt , "type" : qtype , "choices" : choices};
				i = 0 ;
				choices = [];
				$("#form").remove(".choice");
			}
			
			function addChoice()
			{
				var questionType = document.getElementById("questionType");
				qtype = questionType.options[questionType.selectedIndex].text;
				if (qtype != "text")
				{
					$("#form").append('<input type="text" name="choice'+i+'" id="choice'+i+'" class="choice">');
				}
				
				ch = document.getElementById("choice"+i).value; 
					//$("#choice"+ i ).val();
				alert(ch);
				choices.push(ch);
				i++;

			}
			
		</script>
	
		<form action="AddSurvey" id="form">
		
			<input type="text" placeholder="Survey Name" name="surveyName"/>
			<br><br>
			<input type="text" placeholder="Question" name="question" id="question"/>
			<br><br>
			<select name="questionType" id="questionType" onchange="addChoice()">
				<option value = "text" >Text</option>
				<option value = "radio" >Radio Buttons</option>
				<option value = "checkbox" >Check Boxes</option>
			</select>
			<br><br>
			<input type="submit" value="Save Survey">
		</form>
		
		<button id="addChoice" onclick="addChoice()" >Add Choice</button>
		<button value="next Question" onclick="newQuestion()">Next Question</button>
		
		
	</body>
</html>
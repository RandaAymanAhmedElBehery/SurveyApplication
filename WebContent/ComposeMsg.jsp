<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type"
		content="text/html; charset=windows-1256">
	<title>Compose Message</title>
			<script src="js/jquery.min.js" ></script>

	</head>
	
	<body>
	
		<form>
			
			<input id="Receipent" type="text" >
			<button id="btn" onclick = "addReceipent()">Add Receipent</button>
			<input type="text" id="rec0">
			<textarea rows="10" cols="50" placeholder="your message here"> </textarea>
			<input type="submit" value="Send" onclick = "sendData()">
			
		</form>
				
		<script>
			
			var emails = [] ;
			var i=0 ;
			
			function addReceipent()
			{
				emails.push($("#rec" + i).val);
				i++ ;
				$("form").append('<input type="text" id="rec' + i +'">');
			}
			
			function sendData ()
			{
				document.location.href ="ComposeMsg?emails="+emails;
			}
			
		</script>
		
		
	</body>

</html>
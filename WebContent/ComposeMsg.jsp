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
	
			<button id="btn" onclick = "addReceipent()">Add Receipent</button>

		<form action="ComposeMsg">			
			<input type="text" id="rec0">
			<textarea rows="10" cols="50" placeholder="your message here" name="msg"> </textarea>
			<input type="submit" value="Send" onclick = "sendData()">
			
		</form>
				
		<script>
			
			var emails ="" ;
			var i=0 ;
			
			function addReceipent()
			{
				emails+=($("#rec" + i).val) + ";";
				i++ ;
				$("form").append('<input type="text" id="rec' + i +'">');
			}
			
			function sendData ()
			{
				$("form").append("<input type='hidden' id='emails' value='"+emails +"'  name='emails' />");
			}
			
		</script>
		
		
	</body>

</html>
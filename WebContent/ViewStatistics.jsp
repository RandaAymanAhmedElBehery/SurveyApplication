<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=windows-1256">
		<title>Insert title here</title>
		
		<style type="text/css">
			#chart-container {
				width: 640px;
				height: auto;
			}
		</style>
		
	</head>
	<body>
		
       	<div id="chart-container">
			<canvas id="mycanvas"></canvas>
		</div>

		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/chart.min.js"></script>
		
		<script>
		$(document).ready(function(){
			$.ajax({
				url: "getSurveyDetails?surveyName=" + <%=session.getAttribute("surveyName")%>
									+ "&creatorEmail=" + <%=session.getAttribute("email")%> ,
				method: "GET",
				success: function(data) {
					console.log(data);
					var qNum = [];
					var qFreq = [];
					var x = 0 ;
					for(var i in data) {
						x++ ;
						qNum.push("Question" + x);
						qFreq.push(data[i].freq);
					}

					var chartdata = {
						labels: qNum,
						datasets : [
							{
								label: 'Question Frequency',
								backgroundColor: 'rgba(200, 200, 200, 0.75)',
								borderColor: 'rgba(200, 200, 200, 0.75)',
								hoverBackgroundColor: 'rgba(200, 200, 200, 1)',
								hoverBorderColor: 'rgba(200, 200, 200, 1)',
								data: qFreq
							}
						]
					};

					var ctx = $("#mycanvas");

					var barGraph = new Chart(ctx, {
						type: 'bar',
						data: chartdata
					});
				},
				error: function(data) {
					console.log(data);
				}
			});
		});
			
			
		</script>
	
	</body>
</html>
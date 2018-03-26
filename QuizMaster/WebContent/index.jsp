<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Quiz Master</title>
	
	<link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/styles/border.css>
	<link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/styles/main.css>
</head>
<body>
	<h3 class="header"><jsp:include page="header.html"></jsp:include> </h3>
		<div>
			<br>
			<h1>The Sendai Quiz</h1>
			<p>Welcome to the Quiz Master site to start the quiz enter your name and click the button below.</p>
			<br>
			<form action="QuizServlet" method="get">
				
				<input type="text" class="edittext" name="user">
				<input type="submit" class="button" name="button" value="Let's Play">
				 
			</form>
		</div>
	<h5 class="footer"><jsp:include page="footer.html"></jsp:include></h5>
</html>
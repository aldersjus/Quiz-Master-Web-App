<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Questions</title>
	<link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/styles/border.css>
	<link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/styles/main.css>
</head>
<body>
	<h3 class="header"><jsp:include page="header.html"></jsp:include> </h3>
		<div>
			<br>
			<br>
			<h3>Okay <%=session.getAttribute("user") %>, here's the <%= request.getAttribute("order")%> question.</h3>
			
			<p>
			<%=request.getAttribute("questionNumber")%>. <%=request.getAttribute("question")%> 
			
			<form action="AnswerServlet" method="get" >
			
				<input type="hidden" name="next" value=<%=request.getAttribute("questionNumber")%>>
				<input type="radio" class="radio" name="radio" value="A"> <%=request.getAttribute("answer")%>
				<input type="radio" class="radio" name="radio" value="B"> <%=request.getAttribute("answerWrong")%>
				<br>
				<br>
				<input type="submit" class="button" name="answer_button" value="Enter">
				
			</form>
		</div>
	<h5 class="footer"><jsp:include page="footer.html"></jsp:include></h5>
</body>
</html>
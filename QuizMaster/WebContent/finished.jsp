<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="quizzes.AnswerSheet,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/styles/border.css>
	<link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/styles/main.css>
</head>
<body>
	<h3 class="header"><jsp:include page="header.html"></jsp:include> </h3>
		<div>
			<%
			int score = 0;
			
			AnswerSheet answerSheet = (AnswerSheet)session.getAttribute("answerSheet");
			ArrayList<String> answers = answerSheet.getAnswers() ;
			for(String s : answers){
				if(s.equals("A")){
					score++;
				}
			}
			out.println("<br>");
			out.print("<h1>");
			out.print("You scored " + score);
			out.print(" out of 5");
			out.print("<br>");
			out.print("Thanks for playing, ");
			out.print(session.getAttribute("user"));
			out.print(".");
			out.print("</h1/");
			out.println("<br>");
			
		%>
		<br>
			<a href="/QuizMaster/index.jsp">Quiz Master </a> To play again.
		<br>
		<br>
			<a href="http://sendai-travel.jp/">Sendai Travel </a> Visit this site to find out about Sendai city.
		</div>
	<h5 class="footer"><jsp:include page="footer.html"></jsp:include></h5>
</body>
</html>
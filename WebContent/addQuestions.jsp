<%@page import="com.dao.QuizDao"%>
<%@page import="com.bean.QuizBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
input {
	margin-top: 50px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Question</title>
</head>
<body  >
		  
	<div class="w3-container"  >
		<jsp:include page="AdminHeader.jsp"></jsp:include>
		<div class="w3-quarter">&nbsp;</div>
		<form action="QuestionServlet" method="post">
			<div class="w3-half w3-card-4 "  style="background-color: white; margin-top: 30px;" >
				<div class="w3-row">
					<div align="center">
						<font size="5"> Question Addition Form </font>
					</div>	
				</div>
				<div class="w3-row">
					<div class="w3-col m3">
						<font
							style="font-size: 20px; text-transform: capitalize; padding-left: 15px;">Quiz
							Name</font>
					</div>
					<%
						ArrayList<QuizBean> quizbean = (ArrayList) QuizDao.ListQuizName();
					%>
					<div class="w3-col m7">
						<select name="quizid" class="w3-input">
							<option>Quiz Name</option>
							<%
								for (int i = 0; i < quizbean.size(); i++) {
									QuizBean bean = quizbean.get(i);
							%>
							<option value="<%=bean.getQuizId()%>"><%=bean.getQuizName()%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>
				<div class="w3-row">
					<div class="w3-col m3"
						style="margin-top: 20px; padding-left: 15px;">
						<font style="font-size: 20px; text-transform: capitalize;">
							Question</font>
					</div>
					<div class="w3-col m7" style="margin-top: 20px;">
					<textarea rows="7" cols="25" class="w3-input" placeholder="Question" name="question">
					</textarea>
					</div>
				</div>
				<div class="w3-row">
					<div class="w3-col m3" style="margin-top: 20px;">
						<font
							style="font-size: 20px; text-transform: capitalize; padding-left: 15px;">
							answer</font>
					</div>
					<div class="w3-col m7" style="margin-top: 20px;">
						<input type="text" name="answer" placeholder="Answer"
							class="w3-input" maxlength="100">
					</div>
				</div>
				<div class="w3-row">
					<div class="w3-col m3" style="margin-top: 20px;">
						<font
							style="font-size: 20px; text-transform: capitalize; padding-left: 15px;">
							Option 1</font>
					</div>
					<div class="w3-col m7" style="margin-top: 20px;">
						<input type="text" name="option1" placeholder="option 1"
							class="w3-input" maxlength="100">
					</div>
				</div>
				<div class="w3-row">
					<div class="w3-col m3" style="margin-top: 20px;">
						<font
							style="font-size: 20px; text-transform: capitalize; padding-left: 15px;">
							Option 2</font>
					</div>
					<div class="w3-col m7" style="margin-top: 20px;">
						<input type="text" class="w3-input" name="option2"
							placeholder="option 2" maxlength="100">
					</div>
					<div class="w3-row">
						<div class="w3-col m3" style="margin-top: 20px;">

							<font
								style="font-size: 20px; text-transform: capitalize; padding-left: 15px;">
								Option 3</font>
						</div>
						<div class="w3-col m7" style="margin-top: 20px;">
							<input type="text" class="w3-input" name="option3"
								placeholder="Option 3" maxlength="100">
						</div>
					</div>

					<div class="w3-row" style="margin-bottom: 20px;">
						<div class="w3-col m5"
							style="margin-left: 130px; margin-top: 20px;">
							<button type="submit" class="w3-btn w3-theme-d1" style="font-family: cursive;">Submit</button>
							 	</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="w3-quarter">&nbsp;</div>

</body>
</html>
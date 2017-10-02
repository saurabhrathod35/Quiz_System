<%@page import="com.bean.QuestionBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question List</title>
</head>
<body>

	<div class="w3-container">
		<jsp:include page="AdminHeader.jsp"></jsp:include>
		<div class="w3-quarter">&nbsp;</div>

		<div class="w3-half w3-card-4"
			style="background-color: white; border-radius: 1em">


<center>
			<label class="w3-xlarge"><i class="fa-list fa"></i>&emsp; List Question</label>
</center>
			<%
				ArrayList<QuestionBean> listQuestion = (ArrayList) request
						.getAttribute("listQuestion");

				if (listQuestion != null) {
			%>
			<table class="table table-hover "
				style="padding-left: 10px; padding-right: 10px;">
				<tr style="font-weight: 800; font-size: 15px; text-transform: capitalize;">
					<td>No</td>
					<td>Question Name</td>
					<td>Answer</td>
					<td>Option 1</td>
					<td>Option 2</td>
					<td>Option 3</td>
					<td>Quiz Name</td>
					<td colspan="2"> Action</td>
				</tr>
				
				<%
				for (int i = 0; i < listQuestion.size(); i++) {
							QuestionBean bean = listQuestion.get(i);
				%>
				<tr style=" font-size: 13px; text-transform: capitalize;">
					<td><%=i+1 %>
					</td>
					<td><%=bean.getQuestion()%></td>
					<td><%=bean.getAnswer()%></td>
					<td><%=bean.getOption1()%></td>
					<td><%=bean.getOption2()%></td>
					<td><%=bean.getOption1()%></td>
					<td><%=bean.getQuizName()%></td>
					<td><a href="DeleteQuestionServlet?qid=<%=bean.getQuestion_id()%>">Delete</a></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				}
			%>
		</div>
		<div class="w3-quarter">&nbsp;</div>
	</div>
</body>
</html>
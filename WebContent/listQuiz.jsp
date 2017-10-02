<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.QuizBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="w3-container">
		<jsp:include page="AdminHeader.jsp"></jsp:include>
		<div class="w3-quarter">&nbsp;</div>

		<div class="w3-half w3-card-4"
			style="background-color: white; border-radius: 1em">


			<font style="word-spacing: 6px; font-size: 30px;"><center>List
					Quiz Name</center> </font>
			<%
				ArrayList<QuizBean> quizList = (ArrayList) request
						.getAttribute("listquiz");
				if (quizList != null) {
			%>
			<table class="table table-hover "
				style="padding-left: 10px; padding-right: 10px;">
				<tr style="font-weight: 800; font-size: 15px;">
					<td>No</td>
					<td>Quiz Name</td>
					<td colspan="2">Action</td>
				</tr>
				<%
					for (int i = 0; i < quizList.size(); i++) {
							QuizBean bean = quizList.get(i);
				%>
				<tr>
					<td><%=i + 1%></td>
					<td><%=bean.getQuizName()%></td>
					<td>
					<% if(!bean.isVisible()){%>
					<a href="QuizVisibleServlet?quiz=<%=bean.getQuizId()%>" style="text-transform: capitalize;"  class="w3-btn w3-theme-d3">Visible quiz</a> 
					<%}else{ %>
					<a href="QuizInVisibleServlet?quiz=<%=bean.getQuizId()%>" style="text-transform: capitalize;"  class="w3-btn w3-theme-d3">InVisible quiz</a>
					<%} %>
					</td>
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
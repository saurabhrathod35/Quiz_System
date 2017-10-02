<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<jsp:include page="UserHeader.jsp"></jsp:include>
	<div class="w3-container">
		<div class="w3-quarter">&nbsp;</div>

		<div class="w3-half w3-white w3-card-8"
			style="border-radius: 15px; padding-top: 40px; padding-bottom: 40px; margin-top: 260px;">

			<div
				style="padding-left: 290px; font-size: 35px; text-transform: uppercase;"><%=session.getAttribute("loginName")%>
			</div>
			<div style="margin-top: 25px;">
				<font
					style="font-size: 26px; color: green; margin-left: 190px; text-transform: capitalize;">
					<%
						int attpQue = (Integer) request.getAttribute("attempQue");
					%> You attempt <span style="font-weight: 900;"> <%=attpQue%>
				</span> Question </font>
			</div>
			<div style="margin-top: 30px;">
				<font
					style="font-size: 26px; color: red; margin-left: 190px; text-transform: capitalize;">
					<%
						UserBean userBean = (UserBean) session.getAttribute("userBean");

						int notAtte;
						if (userBean.getQuizid() != 1) {
							notAtte = 30 - attpQue;
						} else {
							notAtte = 25 - attpQue;
						}
						int notAttemplted = (Integer) request.getAttribute("notAttempQue");
					%> You Not attempt</font> <span style="font-weight: 900;"> <%=notAtte%>Question
				</span>

			</div>
			<div class="w3-quarter">&nbsp;</div>
		</div>
	</div>
</body>
</html>
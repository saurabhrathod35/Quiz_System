<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.ResultBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<style type="text/css">
body {
	background: url(picture/background.jpg) no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<center>

		<table border=1
			style="background-color: white; border-radius: 7px; margin-top: 60px;">

			<tr style="color: gray; font-size: 25px;">
				<td style="padding: 20px;">Name</td>
				<td style="padding: 20px;">Result marks</td>
				<td style="padding: 20px;">Starting Time</td>
				<td style="padding: 20px;">Right answer</td>
				<td style="padding: 20px;">Wrong answer</td>
			</tr>
			<% ArrayList<ResultBean> resultList=(ArrayList)request.getAttribute("resultlist");
if(resultList!=null)
{
	
	for(int i=0;i<resultList.size();i++)
	{
		
	ResultBean resultBean=resultList.get(i);
%>
			<tr>
				<td style="padding: 10px;"><%=resultBean.getUser_id() %></td>
				<td><%=resultBean.getTotal() %></td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
			</tr>
  			<%} %>
		</table>
		<%} %>
	</center>
</body>
</html>
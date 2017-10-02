 <%@page import="com.dao.ResultDAO"%>
<%@page import="com.bean.ResultBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background: url(picture/background.jpg) no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<%
		ArrayList<ResultBean> listQuestion = (ArrayList) ResultDAO.TechnicalQuizResultList();
		if (listQuestion != null) {
	%>

	<div class="w3-container">
		<jsp:include page="AdminHeader.jsp"></jsp:include>
		<div class="w3-quarter">&nbsp;</div>
	<div class="w3-half w3-card-8" id="table1"
			style="background-color: white; border-radius: 1px">
			
<a style="font-size: 23px; cursor: help;" align="center"
		onclick="printDiv('table1')" class="w3-btn w3-theme"> Print</a>
		
			<font style="word-spacing: 6px; font-size: 25px;"><center>Code Quiz Result</center> </font>
				<center> <table class="table table-hover " id="table1" border="1"
				style="padding-left: 10px; padding-right: 10px;">

				<tr style="font-weight: 800; font-size: 20px;">
					<td >Name</td>
					<td >Quiz Name</td>
					<td >Result marks</td>
 
					<td>Complete Time </td>
								
				</tr>
				<%
					for (int i = 0; i < listQuestion.size(); i++) {
							ResultBean bean = listQuestion.get(i);
				%>
				<tr>
					<td><%=bean.getUserName()%></td>
					<td><%=bean.getQuizname()%></td>
					<td><%=bean.getTotal()%></td>
					<td><%=bean.getComplitionTime()%> </td>
				</tr>
				<%
					}
				%>
			</table>
			</center>
		</div>
				<div class="w3-quarter">&nbsp;</div>
	</div>
	<%
		}
	%>

	<script type="text/javascript">
	function printDiv(divName) {
		var printContents = document.getElementById(divName).innerHTML;
		var originalContents = document.body.innerHTML;

		document.body.innerHTML = printContents;

		window.print();

		document.body.innerHTML = originalContents;
	}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<!-- <link rel="stylesheet" href="css/w3.css" rel="stylesheet"
	type="text/css" />

<link rel="stylesheet"
	href="css/font-awesome-4.5.0/css/font-awesome.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<link href="css/w3-theme-brown.css" rel="stylesheet" type="text/css" />

<noscript>
	<meta HTTP-EQUIV="Refresh" CONTENT="0;URL=JavaScriptErrorPage.html">
</noscript>
 -->
 <jsp:include page="UserHeader.jsp"></jsp:include>
</head>
<body>
						<table class="table table table-bordered "
							style="font-size: 20px; text-transform: capitalize; background-color: white; ">
					<tr>
					<th colspan="2" ><center><h3>User Instruction</h3></center> </th>
					</tr>
							<tr>
								<td>1</td>
								<td>Login with your user_id and Password</td>
							</tr>
							<tr>
								<td>2</td>
								<td>if you loggedin mak sure do not refresh the page and
									use back button.</td>
							</tr>
							<tr>
								<td>3</td>
								<td>we give you 30 minutes for quiz</td>
							</tr>

							<tr>
								<td>4</td>
								<td>if you want finish your exam in between <strong>click
										on</strong> <strong class="w3-btn w3-green">finish Exam</strong></td>
							</tr>
							<tr>
								<td>5</td>
								<td>in the last compulsory <strong>click on</strong><strong
									class="w3-btn w3-green">FinishExam</strong> button otherwise
									your result not declare</td>
							</tr>
							<tr>
								<td>6</td>
								<td>your result will depends on your right question in
									minimum time</td>
							</tr>
					
							<tr>
								<td></td>
								<td> <center>
								<a href="loginPage.jsp"  class="w3-btn w3-blue  w3-xxlarge">I Agree </a>
								</center>	 </td>
							</tr>
					
						</table>
					<div class="">
					
					</div>
 

	<script src="js/jquery-1.10.2.js"></script>

	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#openmodalbtn").click();
		});
	</script>
</body>

</html>
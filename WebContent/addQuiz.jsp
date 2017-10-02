<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Quiz</title>
</head>
<body>
	<form action="QuizInsertServlet" method="post">
		<div class="w3-container">
			<jsp:include page="AdminHeader.jsp"></jsp:include>
			<div class="w3-quarter">&nbsp;</div>
			<div class="w3-half w3-card-8" style="background-color: white; margin-top: 50px; border-radius:15px;">
			<div class="w3-row" align="center"><font style="font-size: 30px;">Add Quiz</font> </div>
				<div class="w3-row">
					<div class="w3-col m3" style="margin-bottom: 10px;">
						<font style="font-size: 20px; padding-left: 20px; ">Quiz Name</font>
					</div>
					<div class="w3-col m7">
						<input type="text" class="w3-input" name="quizname" placeholder="Quiz Name">
					</div>
				</div>
				<div class="w3-row" style="margin-top: 40px; margin-left: 160px; margin-bottom: 30px;">
					<button type="submit" class="w3-btn w3-theme-d2" >Add Quiz</button>
				</div>

			</div>

			<div class="w3-quarter">&nbsp;</div>
		</div>

	</form>
</body>
</html>
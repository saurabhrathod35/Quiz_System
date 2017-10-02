<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.UserBean"%>
<%@page import="com.bean.QuestionBean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Name</title>
 
 
<script src="js/jquery.js"></script>
<script type="text/javascript">
	
</script>
<script type="text/javascript">
$(window).keydown(function(e){
	if(e.keyCode==122){
		e.preventDefault();
	}
});
window.onload = function () {
    document.onkeydown = function (e) {
        return (e.which || e.keyCode)== 122;
    
    };
}    
window.onload = function () {
        document.onkeydown = function (e) {
            return (e.which || e.keyCode) != 116;
        
        };
    }
     window.onload = function () {
         document.onkeydown = function (e) {
             return (e.which || e.keyCode)== 154;
         
         };
     }
      
</script>
<script>
myStartFunction();
var myVar;
						var min =<%=session.getAttribute("timerMini")%>;
	var sec = <%=session.getAttribute("timerSecond")%>;

 
 
	function myStartFunction() {
		myVar = setInterval(alertFunc, 1000);
	}

	function alertFunc() {
		document.getElementById("demo").innerHTML = min;
		document.getElementById("demo2").innerHTML = sec;
		sec = sec - 1;
		if (sec == 0) {
			min = min - 1;
			sec = 59;
		}

		if (min == 00  ) {
			document.finishExam.submit();
			alert("time over");
		}

		document.getElementById("min").value = min;
		document.getElementById("sec").value = sec;

	}
	function myStopFunction() {
		clearInterval(myVar);
	}

					</script>

</head>
 

<script type="text/javascript">
element.webkitRequestFullScreen(); 
</script>
<script type="text/javascript">
$(document).on("keydown", function (e) {
    if (e.which === 8 && !$(e.target).is("input:not([readonly]):not([type=radio]):not([type=checkbox]), textarea, [contentEditable], [contentEditable=true]")) {
        e.preventDefault();
    }
});
</script>

<body >
 
	<%
				ArrayList<QuestionBean> listQuestion = (ArrayList) session
				.getAttribute("beans");

		if (listQuestion != null) {
	%>
		<jsp:include page="UserHeader.jsp"></jsp:include>
	<form action="DatabaseQuizResultServlet" method="post" name="myform">
		
		<div class="w3-container">
			<div class="w3-quarter">&nbsp;</div>
			<div class="w3-half " style="border-radius: 25px; margin-top: 90px;">
				 
<div >
<span style="background-color: white; 
background-color: white; 
 font-size: 20px;
  border-radius:15px 15px 0px 0px; 
   padding-left: 20px; 
  padding-bottom: 45px; 
  padding-right: 20px; 
  padding-top: 15px;
  
  "  >
	<span style="color: green;">			 	User id <label class="fa fa-arrow-right"></label>
					<%=session.getAttribute("loginName")%></span>
</span>

 <span style="
 float: right; 
 background-color: white; 
  padding-left: 20px; 
  padding-bottom: 45px; 
  padding-right: 20px; 
  padding-top: 15px;
  font-size: 20px; 
 border-radius:15px;
  " >
		<span style="color: red">	Time Left :-		 <b id="demo"></b>:<b id="demo2"></b> 
 </span></span>
</div>
					<input type="hidden"
						name="sec" id="sec" value=""> <input type="hidden"
						name="min" id="min" value="">
					
					 


				<%
					int que = (Integer) session.getAttribute("que");

						if (que < listQuestion.size()) {
							QuestionBean questionBean = listQuestion.get(que);
				%>
					<input type="hidden" name="correctAnswer" value="<%=questionBean.getAnswer()%>">
 
				<div class="w3-card-8"
					style="margin-top: 20px; padding-top: 20px; padding-bottom: 20px; margin-bottom: 20px; padding-left: 10px; background-color: #FFFFFF; border-radius: 15px 15px 0px 0px;">
					<font
						style="font-size: 20px; font-family: 'Times New Roman';  ">
						<span style="color: blue;"> Q<%= session.getAttribute("qcnt")%>

					</span> <label class="fa fa-arrow-right"></label> <%=questionBean.getQuestion()%></font>

				</div>

				<input type="hidden" value="<%=que%>" name="count" />
				<div class="w3-card-8"
					style="padding-left: 50px; padding-top: 20px; padding-bottom: 20px; background-color: #FFFFFF; border-radius: 0px 0px 15px 15px;">
					<%
						if (que % 2 == 0) {
					%>
					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getAnswer()%>"> <label
						class="w3-validate">(A) <%=questionBean.getAnswer()%></label> <br>

					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getOption1()%>"> <label
						class="w3-validate"> (B) <%=questionBean.getOption1()%> </label> <br>
					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getOption2()%>"> <label
						class="w3-validate"> (C) <%=questionBean.getOption2()%> </label> <br>
					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getOption3()%>"> <label
						class="w3-validate"> (D) <%=questionBean.getOption3()%> </label> <br>

					<div class="w3-xlarge"
						style="margin-left: 200px; margin-top: 80px; border-radius: 15px; font-family: 'comic sans ms';">
						<input class="w3-theme-d4 w3-btn " type="submit" value="Next">

					</div>
					<%
						} else if (que / 3 >= 1) {
					%>
					
					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getOption1()%>"> <label
						class="w3-validate"> (A)<%=questionBean.getOption1()%> </label> <br>
					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getAnswer()%>"> <label
						class="w3-validate">(B) <%=questionBean.getAnswer()%></label> <br>
					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getOption2()%>"> <label
						class="w3-validate"> (C) <%=questionBean.getOption2()%> </label> <br>
					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getOption3()%>"> <label
						class="w3-validate"> (D) <%=questionBean.getOption3()%> </label> <br>

					<div class="w3-xlarge"
						style="margin-left: 200px; margin-top: 80px; border-radius: 15px; font-family: 'comic sans ms';">
						<input class="w3-theme-d4 w3-btn " type="submit" value="Next">

					</div>

					<%
						} else {
					%>
					
					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getOption1()%>"> <label
						class="w3-validate"> (A)<%=questionBean.getOption1()%> </label> <br>

					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getOption2()%>"> <label
						class="w3-validate"> (B) <%=questionBean.getOption2()%> </label> <br>
					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getAnswer()%>"> <label
						class="w3-validate">(C) <%=questionBean.getAnswer()%></label> <br>
					<input type="radio" name="answer" class="w3-radio"
						value="<%=questionBean.getOption3()%>"> <label
						class="w3-validate"> (D) <%=questionBean.getOption3()%> </label> <br>

					<div class="w3-xlarge" 
						style="margin-left: 200px; margin-top: 80px; border-radius: 15px; font-family: 'comic sans ms';">
						<input class="w3-theme-d4 w3-btn " type="submit" value="Next">
					</div>
			
	 	
					<%
						}
					%>
				</div>
				<%
					}
				%>
			
			
			</div>
			<div class="w3-quarter">&nbsp;
			</div>
		</div>
	</form>
	<%
		}
	%>
	<form action="DBQuizCheckAnswer" method="get" name="finishExam" >
		<div
			style="margin-left: 850px; border-radius: 15px; margin-top: 20px;">
			<input type="submit" value="Finish Exam"
				class="w3-btn w3-xxlarge w3-green">
		</div>
	</form>
	 <script src="js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->


</body>
</html>
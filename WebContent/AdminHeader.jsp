
<link rel="stylesheet" href="css/w3.css" rel="stylesheet"
	type="text/css" />

<link rel="stylesheet"
	href="css/font-awesome-4.5.0/css/font-awesome.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<link href="css/w3-theme-brown.css" rel="stylesheet" type="text/css" />

<noscript>
	<meta HTTP-EQUIV="Refresh" CONTENT="0;URL=JavaScriptErrorPage.html">
</noscript>
<style>
input {
	outline: none;
}
</style>

<%
	if (request.getSession().getAttribute("username") == null) {
		request.getRequestDispatcher("adminLoginPage.jsp").forward(request,
				response);
	}
%>
<body onload="logoEffect()"
	style="background-image: url(picture/11Aq1.jpg); background-size: cover;">
	<img src="picture/retro-tm.png" id="logo" height="120" width="220"
		class="w3-animate-top" />
	<nav
		class=" navbar navbar-default w3-theme-d2 w3-card-8 w3-animate-top">
	<div class="container-fluid ">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav" id="menu">
				<li class="dropdown" id="activity"><a href="AdminAllEvent.jsp"><i
						class="fa fa-home" style="font-size: 24px"> Dashboard</i> </a>
				</li>

				<li class="dropdown" id="activity"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><i class="fa fa-sitemap"
						style="font-size: 24px"> Question</i><span class="caret"></span> </a>
					<ul class="dropdown-menu">
						<li><a href="addQuestions.jsp">Add Question</a></li>
						<li><a href="QuestionListServlet">List Question</a></li>
					</ul></li>
				<li class="dropdown" id="activity"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><i class="fa-bolt fa"
						style="font-size: 24px"> Quiz </i><span class="caret"></span> </a>
					<ul class="dropdown-menu">
						<li class="w3-theme"></li>
						<li><a href="addQuiz.jsp">Add Quiz</a></li>
						<li><a href="QuizListServlet">List Quiz</a></li>

					</ul></li>


				<li class="dropdown" id="activity"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><i class="fa-user fa"
						style="font-size: 24px"> Result</i><span class="caret"></span> </a>
					<ul class="dropdown-menu">
						<li class="w3-theme"></li>
						<li><a href="DBQuizResult.jsp">Database Result  List </a></li>
						<li><a href="CodeQuizResult.jsp">Code Quiz Result List </a></li>
						<li><a href="DebugQuizResult.jsp">Debug Quiz Result List </a></li>
						<li><a href="TechnicalQuizResult.jsp"> Technical Quiz Result List </a></li>		
					</ul></li>


			</ul>
			<ul class="nav navbar-nav navbar-right">

				<li class="dropdown" id="activity"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><i class="fa-user fa"
						style="font-size: 24px"> ${username} </i><span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li class="w3-theme"></li>
						<li><a href="LoginOut">Logout</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	</nav>

	<script src="js/jquery.min.js"></script>

	<script src="js/bootstrap.min.js"></script>
	<script>
		$(document)
				.ready(
						function() {
							$(
									"#home, #logIn ,  #activity ,#Equipment , #gym , #About ,#Contact , #member")
									.mouseleave(function() {
										$(this).addClass("w3-theme-d2 ");
										$(this).css({
											"transition" : "1s"
										});
										$(this).removeClass("w3-card-16 ");
									});

							$(
									"#home,#logIn  , #activity ,#Equipment , #gym, #About ,#Contact , #member")
									.mouseenter(
											function() {
												$(this).addClass(
														"w3-white w3-card-16");
												$(this).removeClass(
														"w3-theme-d2");
											});
						});
	</script>
	<script type="text/javascript">
		function logoEffect() {
			$("#logo").css({
				"transition" : "3s all",
				"transform" : "rotateY(360deg)"
			});
		}
	</script>
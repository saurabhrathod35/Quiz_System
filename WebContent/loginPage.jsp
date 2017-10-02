<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
input {
	outline: none;
}

body {
	background: url(picture/background.jpg) no-repeat;
	background-size: cover;
	
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login</title>

<link href="css/w3.css" rel="stylesheet" type="text/css" />
<link href="css/w3-theme-khaki.css" rel="stylesheet" type="text/css" />
</head>

<body onload="maxwin();">
	<div class=" w3-container" style="margin-top: 200px;">
		<div class="w3-quarter">&nbsp;</div>
		<div class="w3-half w3-card-16"
			style="background-color: #FFFFFF; border-radius: 25px;">

			<div class="w3-animate-top w3-row "
				style="margin-bottom: 10px; ">
				<div class="w3-half"> &nbsp; </div>	
				<img src="picture/retro-tm.png" style="margin-left:-60px" class="w3-quarter" /> 
				<div class="w3-half" > &nbsp; </div>
			</div>
<form action="checkLogin" method="post"> 

			<div class="w3-animate-right w3-row "
				style="margin-bottom: 10px; margin-top: 20px;">
				<span class="w3-col m2"
					style="font-size: 16px; margin-top: 10px; margin-left: 20px;">User
					Name</span> <span class="w3-col m9"> <input type="text"
					class=" w3-animate-input w3-input" maxlength="50" name="username"
					placeholder="User Name" /> </span>
			</div>

			<div class="w3-animate-left w3-row" style="padding-top: 10px;">
				<span class="w3-col m2"
					style="font-size: 16px; margin-top: 10px; margin-left: 20px;">Password</span>
				<span class="w3-col m9"> <input
					class="w3-animate-input w3-input" type="password" name="password"
					maxlength="50" placeholder="Password" /> </span>
			</div>
			<div class="w3-animate-bottom w3-row"
				style="margin-bottom: 5px; margin-left: 250px; margin-top: 30px;">
				<span
					style="font-size: 20px; font-family: 'Lucida Calligraphy'; font-weight: 800;">
					<input type="submit" value="Login"
					class="w3-btn w3-col m5 w3-theme-d4	" style="border-radius: 10px;" />
				</span>

			</div>
			</form>
		</div>
		
		<div class="w3-quarter">&nbsp;</div>
	</div>
</body>
</html>

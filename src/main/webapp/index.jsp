<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>welcome page</title>
</head>
<body style="background-color: powderblue;">
	<img height="100px" width="100px" src="unisa.png">
	<br>
	<br>
	<form action="employeeLogin" method="post">
		<br> <br> <label for="userName"> userName: </label> <input
			type="text" id="userName" name="userName"><br> <br>
		<label for="password"> Password: </label> <input type="password"
			id="password" name="password"><br> <br> <br> <input
			type="submit" value="LogIn"><br>

	</form>
	<br>
	<a href="register.jsp"><button>create new account</button></a>
</body>
</html>
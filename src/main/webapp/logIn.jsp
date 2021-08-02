<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn</title>
</head>
<body style="background-color: LightGray;">
	<img height="50px" width="50px" src="unisa.png">
	<form action="employeeLogin" method="post">
	<br>
		<label>login incorrect</label> <br> <br> <label
			for="userName"> userName: </label> <input type="text" id="userName"
			name="userName"><br> <br> <label for="password">
			Password: </label> <input type="password" id="password" name="password"><br>
		<br> <br> <input type="submit" value="LogIn"><br>
	</form>
	<br>
	<a href="register.jsp"><button>create new account</button></a>
	<br>
	<br>
	<a href="index.jsp" class="previous">&laquo; Previous</a>

</body>
</html>
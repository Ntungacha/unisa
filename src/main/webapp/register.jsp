<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employee registration form</title>
</head>
<body>
	<img height="100px" width="100px" src="unisa.png">
	<form action="registerEmployee" method="post">
		<label for="surname">Surname:</label> <input type="text" id="surname"
			name="surname"><br> <br> <label for="lastName">Last
			name:</label> <input type="text" id="lastName" name="lastName"><br>
		<br> <label for="emailAddress"> Email Address:</label> <input
			type="email" id="emailAddress" name="emailAddress"><br>
		<br> <label for="telePhoneNumber"> Telephone Number:</label> <input
			type="number" id="telephoneNumber" name="telePhoneNumber"><br>
		<label for="sex">Sex:</label><br> <input type="radio" id="sex"
			name="sex" value="male" />M<br> <input type="radio" id="sex"
			name="sex" value="female" />F<br> <label for="maritalStatus">MaritalStatus:</label><br>
		<input type="radio" id="maritalStatus" name="maritalStatus"
			value="Single" />Single<br> <input type="radio"
			id="maritalStatus" name="maritalStatus" value="Married" />Married<br>
		<input type="radio" id="maritalStatus" name="maritalStatus"
			value="Divorce" />Divorce<br> <label for="birthday">Date
			Of Birth:</label> <input type="date" id="birthday" name="dateOfBirth"><br>
		<br> <label for="idNumber"> ID Card Number </label> <input
			type="text" id="idNumber" name="idNumber"><br> <br>
		<label for="password"> Password: </label> <input type="password"
			id="password" name="password"><br> <br> <label
			for="userName"> User Name: </label> <input type="text" id="userName"
			name="userName"><br> <br> <label for="role">
			Role </label> <input type="text" id="role" name="role"><br> <br>
		<input type="submit" value="Register">

	</form>
	<br>
	<br>
	<a href="index.jsp" class="previous">&laquo; Previous</a>
</body>
</html>
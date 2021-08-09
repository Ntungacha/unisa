<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.unisa.models.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>successful</title>
</head>
<body>

	<img height="100px" width="100px" src="unisa.png">
	<h1 align="center">WELCOME TO UNISA</h1>

	<br>
	<br>
	<form action="search" method="post">
	<label for="option">option:</label>
		<select name="option" id="option">
			<option value=""></option>
			<option value="student_id">student Id</option>
			<option value="surname">surname</option>
			<option value="last_Name">last name</option>
			<option value="telephone_Number">TELEPHONE NUMBER</option>
			<option value="email_Address">email address</option>
			<option value="date_Of_Birth">Date of Birth</option>
			<option value="course">course</option>
			<option value="marital_Status">MARITAL STATUS</option>
			<option value="sex">Sex</option>
		</select>
		<label>Search:</label> <input type="search" name="search"> <input
			type="submit" value="search"> 
	</form>
	
	<a href="registerStudent.jsp"><button>Create</button> </a>
	<a href="index.jsp"><button>LogOut</button> </a>
	<br>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>SURNAME</th>
				<th>LAST NAME</th>
				<th>TELEPHONE NUMBER</th>
				<th>EMAIL ADDRESS</th>
				<th>DATE OF BIRTH</th>
				<th>COURSE</th>
				<th>MARITAL STATUS</th>
				<th>SEX</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Student> students = (List<Student>) request.getAttribute("students");
			%>
			<%
			for (int i = 0; i < students.size(); i++) {
			%>
			<tr>
				<td><%=students.get(i).getSurname()%></td>
				<td><%=students.get(i).getLastName()%></td>
				<td><%=students.get(i).getTelePhoneNumber()%></td>
				<td><%=students.get(i).getEmailAddress()%></td>
				<td><%=students.get(i).getDateOfBirth()%></td>
				<td><%=students.get(i).getCourse()%></td>
				<td><%=students.get(i).getMaritalStatus()%></td>
				<td><%=students.get(i).getSex()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br>
	<a href="index.jsp" class="previous">&laquo; Previous</a>
</body>
</html>
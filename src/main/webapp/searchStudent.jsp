<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.unisa.models.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student</title>
</head>
<body>
	<img height="100px" width="100px" src="unisa.png">
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>FIRST NAME</th>
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
	<br>
</body>
</html>
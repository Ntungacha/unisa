package za.ac.unisa.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.ac.unisa.models.Student;
import za.ac.unisa.models.User;
import za.ac.unisa.services.EmployeeService;
import za.ac.unisa.services.StudentService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("registrationSuccessfull.jsp.").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = new User(userName, password);
		EmployeeService employeeService = new EmployeeService();
		boolean loggedIn = employeeService.employeeLogin(user);
		if (loggedIn) {
			StudentService studentService = new StudentService();
			List<Student> students = studentService.getAllStudent();
			System.out.print(students);
			request.setAttribute("students", students);
			request.getRequestDispatcher("/registrationSuccessfull.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid login");
			request.getRequestDispatcher("/logIn.jsp").forward(request, response);
		}
	}

}

package za.ac.unisa.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.ac.unisa.models.Employee;
import za.ac.unisa.models.Student;
import za.ac.unisa.models.User;
import za.ac.unisa.services.EmployeeService;
import za.ac.unisa.services.StudentService;
import za.ac.unisa.services.UserService;

@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final EmployeeService employeeService = new EmployeeService();
	private final UserService userService = new UserService();

	public EmployeeRegistrationServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String surname = request.getParameter("surname");
		String lastName = request.getParameter("lastName");
		String emailAddress = request.getParameter("emailAddress");
		String telePhoneNumber = request.getParameter("telePhoneNumber");
		String sex = request.getParameter("sex");
		String maritalStatus = request.getParameter("maritalStatus");
		String dateOfBirth = request.getParameter("dateOfBirth");
		LocalDate date = LocalDate.parse(dateOfBirth);
		String idNum = request.getParameter("idNumber");
		long idNumber = Long.parseLong(idNum);
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		User user = new User(userName, password, role);
		Employee employee = new Employee(surname, lastName, emailAddress, telePhoneNumber, sex, maritalStatus, date,
				idNumber, user);
		try {
			int registerUser = userService.registerUser(user);
			System.out.println(registerUser);
			user = userService.getUser(user);
			int registerEmployee = employeeService.registerEmployee(employee, user);
			System.out.println(registerEmployee);
			StudentService studentService = new StudentService();
			List<Student> students = studentService.getAllStudent();
			request.setAttribute("students", students);
			request.setAttribute("Employee", employee);
			request.getRequestDispatcher("/registrationSuccessfull.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// e.printStackTrace();
			System.out.println(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/registrationSuccessfull.jsp").forward(request, response);
	}

}

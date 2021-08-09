package za.ac.unisa.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.ac.unisa.models.Student;
import za.ac.unisa.services.StudentService;

@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final StudentService studentService = new StudentService();

	public SearchStudentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/registrationSuccessfull.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search = request.getParameter("search");
		String option = request.getParameter("option");
		try {
			List<Student> students = studentService.search(option, search);
			// List<Student> students = studentService.searchStudent(search);
			System.out.println(students);
			request.setAttribute("students", students);
			request.getRequestDispatcher("/registrationSuccessfull.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e);
		}

	}

}

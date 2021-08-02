package za.ac.unisa.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import za.ac.unisa.dao.DataBaseManagement;
import za.ac.unisa.models.Student;

public class StudentService {
	public StudentService() {

	}

	public int registerStudent(Student student) {
		int student1 = 0;
		String registerStudentQuery = "INSERT INTO student(surname, last_Name, email_Address,"
				+ " telephone_Number, sex, marital_Status, date_Of_Birth, id, course) VALUES ('" + student.getSurname()
				+ "','" + student.getLastName() + "','" + student.getEmailAddress() + "','"
				+ student.getTelePhoneNumber() + "','" + student.getSex() + "','" + student.getMaritalStatus() + "','"
				+ student.getDateOfBirth() + "'," + student.getIdNumber() + ",'" + student.getCourse() + "')";
		try {
			student1 = DataBaseManagement.executeQuery(registerStudentQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student1;
	}

	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		String selectQuery = "SELECT * FROM student";
		try {
			ResultSet resultSet = DataBaseManagement.getResultSet(selectQuery);
			while (resultSet.next()) {
				student = new Student();
				student.setSurname(resultSet.getString("surname"));
				student.setLastName(resultSet.getString("last_Name"));
				student.setCourse(resultSet.getString("course"));
				String date = resultSet.getDate("date_Of_Birth").toString();
				student.setDateOfBirth(LocalDate.parse(date));
				student.setEmailAddress(resultSet.getString("email_Address"));
				student.setIdNumber(resultSet.getLong("id"));
				student.setMaritalStatus(resultSet.getString("marital_Status"));
				student.setSex(resultSet.getString("sex"));
				student.setTelePhoneNumber(resultSet.getString("telephone_Number"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	public List<Student> searchStudent(String search) {
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		String sql = "SELECT * FROM student WHERE student_id LIKE '%" + search + "%' OR surname LIKE '%" + search
				+ "%' OR last_Name LIKE '%" + search + "%' OR email_Address LIKE '%" + search
				+ "%' OR telephone_Number LIKE '%" + search + "%' OR sex LIKE '%" + search
				+ "%' OR marital_Status LIKE '%" + search + "%' OR date_Of_Birth LIKE '%" + search + "%' OR id LIKE '%"
				+ search + "%' OR course LIKE '%" + search + "%'";
		try {
			ResultSet resultSet = DataBaseManagement.getResultSet(sql);
			while (resultSet.next()) {
				student = new Student();
				student.setSurname(resultSet.getString("surname"));
				student.setLastName(resultSet.getString("last_Name"));
				student.setCourse(resultSet.getString("course"));
				String date = resultSet.getDate("date_Of_Birth").toString();
				student.setDateOfBirth(LocalDate.parse(date));
				student.setEmailAddress(resultSet.getString("email_Address"));
				student.setIdNumber(resultSet.getLong("id"));
				student.setMaritalStatus(resultSet.getString("marital_Status"));
				student.setSex(resultSet.getString("sex"));
				student.setTelePhoneNumber(resultSet.getString("telephone_Number"));
				students.add(student);
			}
			System.out.println(student);
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return students;
	}
}

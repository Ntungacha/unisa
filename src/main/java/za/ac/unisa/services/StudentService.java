package za.ac.unisa.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import za.ac.unisa.dao.DataBaseManagement;
import za.ac.unisa.models.Student;

public class StudentService {
	List<Student> allStudent = new ArrayList<Student>();
	Student studen = null;

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
				System.out.println();
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

	public List<Student> search(String option, String search) {
		Student student = null;
		String surname = null;
		String lastName = null;
		String course = null;
		String dateOfBirth = null;
		String emailAddress = null;
		String id = null;
		String maritalStatus = null;
		String sex = null;
		String telephoneNumber = null;
		String sql = "SELECT * FROM student WHERE " + option + " LIKE '%" + search + "%';";
	//	String sql = "SELECT * FROM student WHERE surname  LIKE '%" + search + "%';";
		switch (option) {

		case "surname":
			try {
				ResultSet resultSet = DataBaseManagement.getResultSet(sql);
				System.out.println();
				System.out.println(resultSet);

				while (resultSet.next()) {
					surname = resultSet.getString("surname");
					lastName = resultSet.getString("last_Name");
					course = resultSet.getString("course");
					dateOfBirth = resultSet.getString("date_Of_Birth");
					LocalDate date = LocalDate.parse(dateOfBirth);
					emailAddress = resultSet.getString("email_Address");
					id = resultSet.getString("id");
					long idn = Long.parseLong(id);
					maritalStatus = resultSet.getString("marital_Status");
					sex = resultSet.getString("sex");
					telephoneNumber = resultSet.getString("telephone_Number");
					student = new Student(surname, lastName, emailAddress, telephoneNumber, sex, maritalStatus, date,
							idn, course);
					allStudent.add(student);
					System.out.println(allStudent);
				}

			} catch (SQLException e) {
				System.out.println(e);
			}
			break;

		case "last_Name":
			try {
				ResultSet resultSet = DataBaseManagement.getResultSet(sql);
				while (resultSet.next()) {
					surname = resultSet.getString("surname");
					lastName = resultSet.getString("last_Name");
					course = resultSet.getString("course");
					dateOfBirth = resultSet.getString("date_Of_Birth");
					LocalDate date = LocalDate.parse(dateOfBirth);
					emailAddress = resultSet.getString("email_Address");
					id = resultSet.getString("id");
					long idn = Long.parseLong(id);
					maritalStatus = resultSet.getString("marital_Status");
					sex = resultSet.getString("sex");
					telephoneNumber = resultSet.getString("telephone_Number");
					student = new Student(surname, lastName, emailAddress, telephoneNumber, sex, maritalStatus, date,
							idn, course);
					allStudent.add(student);
					System.out.println(allStudent);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case "course":
			try {
				ResultSet resultSet = DataBaseManagement.getResultSet(sql);
				while (resultSet.next()) {
					surname = resultSet.getString("surname");
					lastName = resultSet.getString("last_Name");
					course = resultSet.getString("course");
					dateOfBirth = resultSet.getString("date_Of_Birth");
					LocalDate date = LocalDate.parse(dateOfBirth);
					emailAddress = resultSet.getString("email_Address");
					id = resultSet.getString("id");
					long idn = Long.parseLong(id);
					maritalStatus = resultSet.getString("marital_Status");
					sex = resultSet.getString("sex");
					telephoneNumber = resultSet.getString("telephone_Number");
					studen = new Student(surname, lastName, emailAddress, telephoneNumber, sex, maritalStatus, date,
							idn, course);
					allStudent.add(studen);
					System.out.println(allStudent);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case "date_Of_Birth":
			try {
				ResultSet resultSet = DataBaseManagement.getResultSet(sql);
				while (resultSet.next()) {
					surname = resultSet.getString("surname");
					lastName = resultSet.getString("last_Name");
					course = resultSet.getString("course");
					dateOfBirth = resultSet.getString("date_Of_Birth");
					LocalDate date = LocalDate.parse(dateOfBirth);
					emailAddress = resultSet.getString("email_Address");
					id = resultSet.getString("id");
					long idn = Long.parseLong(id);
					maritalStatus = resultSet.getString("marital_Status");
					sex = resultSet.getString("sex");
					telephoneNumber = resultSet.getString("telephone_Number");
					studen = new Student(surname, lastName, emailAddress, telephoneNumber, sex, maritalStatus, date,
							idn, course);
					allStudent.add(studen);
					System.out.println(allStudent);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case "id":
			try {
				ResultSet resultSet = DataBaseManagement.getResultSet(sql);
				while (resultSet.next()) {
					surname = resultSet.getString("surname");
					lastName = resultSet.getString("last_Name");
					course = resultSet.getString("course");
					dateOfBirth = resultSet.getString("date_Of_Birth");
					LocalDate date = LocalDate.parse(dateOfBirth);
					emailAddress = resultSet.getString("email_Address");
					id = resultSet.getString("id");
					long idn = Long.parseLong(id);
					maritalStatus = resultSet.getString("marital_Status");
					sex = resultSet.getString("sex");
					telephoneNumber = resultSet.getString("telephone_Number");
					studen = new Student(surname, lastName, emailAddress, telephoneNumber, sex, maritalStatus, date,
							idn, course);
					allStudent.add(studen);
					System.out.println(allStudent);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case "maritalStatus":
			try {
				ResultSet resultSet = DataBaseManagement.getResultSet(sql);
				while (resultSet.next()) {
					surname = resultSet.getString("surname");
					lastName = resultSet.getString("last_Name");
					course = resultSet.getString("course");
					dateOfBirth = resultSet.getString("date_Of_Birth");
					LocalDate date = LocalDate.parse(dateOfBirth);
					emailAddress = resultSet.getString("email_Address");
					id = resultSet.getString("id");
					long idn = Long.parseLong(id);
					maritalStatus = resultSet.getString("marital_Status");
					sex = resultSet.getString("sex");
					telephoneNumber = resultSet.getString("telephone_Number");
					studen = new Student(surname, lastName, emailAddress, telephoneNumber, sex, maritalStatus, date,
							idn, course);
					allStudent.add(studen);
					System.out.println(allStudent);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case "sex":
			try {
				ResultSet resultSet = DataBaseManagement.getResultSet(sql);
				while (resultSet.next()) {
					surname = resultSet.getString("surname");
					lastName = resultSet.getString("last_Name");
					course = resultSet.getString("course");
					dateOfBirth = resultSet.getString("date_Of_Birth");
					LocalDate date = LocalDate.parse(dateOfBirth);
					emailAddress = resultSet.getString("email_Address");
					id = resultSet.getString("id");
					long idn = Long.parseLong(id);
					maritalStatus = resultSet.getString("marital_Status");
					sex = resultSet.getString("sex");
					telephoneNumber = resultSet.getString("telephone_Number");
					studen = new Student(surname, lastName, emailAddress, telephoneNumber, sex, maritalStatus, date,
							idn, course);
					allStudent.add(studen);
					System.out.println(allStudent);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case "emailAddress":
			try {
				ResultSet resultSet = DataBaseManagement.getResultSet(sql);
				while (resultSet.next()) {
					surname = resultSet.getString("surname");
					lastName = resultSet.getString("last_Name");
					course = resultSet.getString("course");
					dateOfBirth = resultSet.getString("date_Of_Birth");
					LocalDate date = LocalDate.parse(dateOfBirth);
					emailAddress = resultSet.getString("email_Address");
					id = resultSet.getString("id");
					long idn = Long.parseLong(id);
					maritalStatus = resultSet.getString("marital_Status");
					sex = resultSet.getString("sex");
					telephoneNumber = resultSet.getString("telephone_Number");
					studen = new Student(surname, lastName, emailAddress, telephoneNumber, sex, maritalStatus, date,
							idn, course);
					allStudent.add(studen);
					System.out.println(allStudent);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case "telephoneNumber":
			try {
				ResultSet resultSet = DataBaseManagement
						.getResultSet("SELECT * FROM student WHERE" + option + "LIKE '%" + search + "%';");
				while (resultSet.next()) {
					surname = resultSet.getString("surname");
					lastName = resultSet.getString("last_Name");
					course = resultSet.getString("course");
					dateOfBirth = resultSet.getString("date_Of_Birth");
					LocalDate date = LocalDate.parse(dateOfBirth);
					emailAddress = resultSet.getString("email_Address");
					id = resultSet.getString("id");
					long idn = Long.parseLong(id);
					maritalStatus = resultSet.getString("marital_Status");
					sex = resultSet.getString("sex");
					telephoneNumber = resultSet.getString("telephone_Number");
					studen = new Student(surname, lastName, emailAddress, telephoneNumber, sex, maritalStatus, date,
							idn, course);
					allStudent.add(studen);
					System.out.println(allStudent);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		}
		return allStudent;
	}
}

package za.ac.unisa.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import za.ac.unisa.dao.DataBaseManagement;
import za.ac.unisa.models.Employee;
import za.ac.unisa.models.User;

public class EmployeeService {

	public EmployeeService() {

	}

	public int registerEmployee(Employee employee, User user) {
		int employe = 0;
		String registerEmployeeQuery = "INSERT INTO employee(surname, last_Name, email_Address, "
				+ "telephone_Number, sex, marital_Status, date_Of_Birth, id, user_id) " + "VALUES('"
				+ employee.getSurname() + "','" + employee.getLastName() + "','" + employee.getEmailAddress() + "','"
				+ employee.getTelePhoneNumber() + "','" + employee.getSex() + "','" + employee.getMaritalStatus()
				+ "','" + employee.getDateOfBirth() + "'," + employee.getIdNumber() + "," + user.getUser_id() + ")";

		try {
			employe = DataBaseManagement.executeQuery(registerEmployeeQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employe;
	}

	public boolean employeeLogin(User user) {
		String loginQuery = "SELECT * FROM employee e JOIN user u WHERE e.user_id = u.user_id AND u.user_Name = '"
				+ user.getUserName() + "' AND u.password = '" + user.getPassword() + "'";

		try {
			ResultSet resultSet = DataBaseManagement.getResultSet(loginQuery);

			while (resultSet.next()) {
				System.out.println(resultSet.getString("surname"));
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}
}

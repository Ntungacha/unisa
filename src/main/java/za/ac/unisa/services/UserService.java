package za.ac.unisa.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import za.ac.unisa.dao.DataBaseManagement;
import za.ac.unisa.models.User;

public class UserService {
	public UserService() {

	}

	public int registerUser(User user) {
		int user1 = 0;
		String registerUserQuery = "INSERT INTO user(user_Name, password, rule) VALUES('" + user.getUserName() + "','"
				+ user.getPassword() + "','" + user.getRole() + "')";
		try {
			user1 = DataBaseManagement.executeQuery(registerUserQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user1;
	}
	
	public User getUser(User user) {
		String sql = "SELECT * FROM user WHERE user_Name = '"+ user.getUserName() + "'";
		User user1 = null;
		try {
			ResultSet resultSet = DataBaseManagement.getResultSet(sql);
			while(resultSet.next()) {
				user1 = new User();
				user1.setUser_id(resultSet.getInt("user_id"));
				user1.setUserName(resultSet.getString("user_Name"));
				user1.setPassword(resultSet.getString("password"));
				user1.setRole(resultSet.getString("rule"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user1;
	}
}

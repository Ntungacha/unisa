package za.ac.unisa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManagement {
	private static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/unisaSystem_db", "root", "Pvi@2020");
		} catch (Exception e) {
			System.out.println(e);
		}

		return connection;
	}

	public static ResultSet getResultSet(String sqlQuery) throws SQLException {
		Statement statement = null;
		Connection connection = getConnection();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
		ResultSet resultSet = statement.executeQuery(sqlQuery);
		return resultSet;
	}

	public static int executeQuery(String sqlQuery) throws SQLException {
		Statement statement = null;
		try {
			statement = getConnection().createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
		int affectedRows = statement.executeUpdate(sqlQuery);
		return affectedRows;

	}

}

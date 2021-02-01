package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.exceptionhandling.ConnectionUtilityException;

public class ConnectionUtility {
	private static final String URL = "jdbc:mysql://localhost:3306/WatchStore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root123";
	Connection conn;

	public Connection getConnection() throws ConnectionUtilityException {

		try {

			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); // For MySQL only

		} catch (SQLException e) {
			throw new ConnectionUtilityException("Could not make connection");
		}
		return conn;

	}

	public void closeConnection(Connection conn) throws ConnectionUtilityException {

		try {

			conn.close();

		} catch (SQLException e) {
			throw new ConnectionUtilityException("Could not close Connection");
		}

	}

	public void closeConnection(PreparedStatement preparedStatement) throws ConnectionUtilityException {
		try {
			{
				preparedStatement.close();
			}
		} catch (SQLException e) {
			throw new ConnectionUtilityException("Could not close prepared statement");

		}
	}

	public void closeConnection(ResultSet resultSet) throws ConnectionUtilityException {
		try {
			{
				resultSet.close();
			}
		} catch (SQLException e) {
			throw new ConnectionUtilityException("Could not close prepared statement");

		}
	}
}

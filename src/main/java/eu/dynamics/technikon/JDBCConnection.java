package eu.dynamics.technikon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	private static Connection connection;
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/technikon_db?createDatabaseIfNotExist=true";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Paok28346";

	private JDBCConnection() {

	}

	private static void createJDBCConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database");
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Connection with database established successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
	}

	public static Connection getConnection() {
		if (connection == null) {
			createJDBCConnection();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
	}
}

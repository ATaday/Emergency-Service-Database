package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB { 

	static Connection connection = null;

	public static Connection connectDB() {

		if (connection != null)
			return connection;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/emergency_service", "username", "pw");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (connection == null)
			System.out.println("Failed to make connection!");

		return connection;
	}
}

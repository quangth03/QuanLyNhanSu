package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		Connection conn = null;

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			String url = "jdbc:mysql://localhost:3306/quanlynhansu?useSSL=false";
			String username = "root";
			String password = "1234";

			conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			System.out.println("Connection error...");
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				System.out.println("Close connection!");
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

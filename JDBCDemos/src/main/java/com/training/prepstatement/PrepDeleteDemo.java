package com.training.prepstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepDeleteDemo {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/trail";
		String username = "root";
		String password = "root";
		String sql_statement = "delete from student where std_name=?";

		// Link and Load the driver

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection object
			connection = DriverManager.getConnection(url, username, password);

			// create a statement object using connection
			statement = connection.prepareStatement(sql_statement);
			statement.setString(1, "manu");

			boolean result = statement.execute();
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

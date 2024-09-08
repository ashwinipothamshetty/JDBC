package com.training.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDemo {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/trail";
		String username = "root";
		String password = "root";
		String sql_statement = "delete from employee where emp_name='harsha'";

		// Link and Load the driver

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection object
			connection = DriverManager.getConnection(url, username, password);

			// create a statement object using connection
			statement = connection.createStatement();

			boolean result = statement.execute(sql_statement);
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

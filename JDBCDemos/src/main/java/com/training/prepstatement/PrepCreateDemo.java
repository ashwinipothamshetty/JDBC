package com.training.prepstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepCreateDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/trail";
		String username = "root";
		String password = "root";
		String sql_statement = "create table student(std_name varchar(20),std_id int primary key,city varchar(20))";

		// Link and Load the driver

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection object
			connection = DriverManager.getConnection(url, username, password);

			// create a statement object using connection
			statement = connection.prepareStatement(sql_statement);

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

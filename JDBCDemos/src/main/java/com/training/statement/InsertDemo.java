package com.training.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/trail";
		String username = "root";
		String password = "root";
		String sql_statement = "insert into employee values('sonu',2,'HR')";

		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			boolean result=statement.execute(sql_statement);
			System.out.println("inserted :" +result);
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

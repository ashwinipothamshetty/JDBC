package com.training.prepstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepInsertDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/trail";
		String username = "root";
		String password = "root";
		String sql_statement = "insert into student values(?,?,?)";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.prepareStatement(sql_statement);
			
			//set values for placeholders ?
			
			statement.setString(1, "Ashwini");
			statement.setInt(2, 2);
			statement.setString(3, "Bangalore");

			boolean result=statement.execute();
			
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

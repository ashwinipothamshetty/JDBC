package com.training.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/trail";
		String username = "root";
		String password = "root";
		String sql_statement = "select * from employee";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql_statement);

		) {
			while (result.next()) {
				String empName = result.getString(1);
				String empId = result.getString("emp_id");
				String department = result.getString("department");

				System.out.println(empName +"  " + empId +"  " +department);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

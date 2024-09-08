package com.training.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertManyDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/trail";
		String username = "root";
		String password = "root";

		try (Scanner sc = new Scanner(System.in);
				Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {
			for (int i = 1; i <= 5; i++) {
				System.out.println("enter name");
				String empName=sc.next();
				System.out.println("enter id");
				int empId=sc.nextInt();
				System.out.println("enter department");
				String department=sc.next();
				String sql_statement = "insert into employee values('"+empName+"',"+empId+",'"+department+"')";
				statement.execute(sql_statement);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

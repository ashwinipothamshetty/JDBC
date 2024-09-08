package com.training.prepstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PrepInsertManyDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/trail";
		String username = "root";
		String password = "root";
		String sql_statement = "insert into student values(?,?,?)";

		try (Scanner sc = new Scanner(System.in);
				Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement statement = connection.prepareStatement(sql_statement)) {
			for (int i = 1; i <= 5; i++) {
				System.out.println("enter name");
				String Name = sc.next();
				System.out.println("enter id");
				statement.setInt(2, sc.nextInt());

				System.out.println("enter city");
				statement.setString(3, sc.next());

				statement.setString(1, Name);

				statement.execute();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

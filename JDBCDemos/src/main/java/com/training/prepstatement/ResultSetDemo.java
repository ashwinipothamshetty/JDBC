package com.training.prepstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/trail";
		String username = "root";
		String password = "root";
		String city="Bangalore";
		//String sql_statement = "select * from student where city='"+ city+"'";
		String sql_statement = "select * from student where city=?";

		
		

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement statement = connection.prepareStatement(sql_statement);){
			statement.setString(1, city);
			try(ResultSet result = statement.executeQuery();
					){
				while (result.next()) {
					String Name = result.getString(1);
					String Id = result.getString("std_id");
					String city1 = result.getString("city");

					System.out.println(Name +"  " + Id +"  " +city1);

				}
			}
				
			}
		
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}

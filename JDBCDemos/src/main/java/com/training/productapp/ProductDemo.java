package com.training.productapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDemo {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/trail";
		String username = "root";
		String password = "root";
		String sql = "select * from prodct";
		String Createsql = "insert into prodct values(?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			preparedStatement = connection.prepareStatement(sql);
			resultSet= preparedStatement.executeQuery(sql);
			List<Product> products = new ArrayList<>();
			while (resultSet.next()) {
				Product product = new Product();
				product.setProductId(1);
				product.setProductName("Apple");
				product.setCategory("fruits");
				product.setBrand("Big basket");
				product.setPrice((double) 200);

				preparedStatement.setString(1, product.getProductName());
				preparedStatement.setInt(2, product.getProductId());

				preparedStatement.setString(1, product.getBrand());

				preparedStatement.setString(1, product.getCategory());

				preparedStatement.setDouble(1, product.getPrice());

				products.add(product);
				String name = resultSet.getString("product_name");
				String id = resultSet.getString("product_id");
				String category = resultSet.getString("category");
				String price = resultSet.getString("price");
				String brand = resultSet.getString("brand");

				System.out
						.println("ID" + id + "Name" + name + "Category" + category + "Price" + price + "brand" + brand);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (resultSet != null)
				resultSet.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
}

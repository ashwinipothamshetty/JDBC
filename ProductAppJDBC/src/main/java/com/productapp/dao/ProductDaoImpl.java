package com.productapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.productapp.model.Product;
import com.productapp.util.ConnectionUtil;
import com.productapp.util.Queries;

public class ProductDaoImpl implements IProductDao {
	static Connection connection;
	static {
		connection = ConnectionUtil.openConnection();

	}

	@Override
	public void addProduct(Product product) {
		Connection connection = ConnectionUtil.openConnection();
		try (PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);) {
			statement.setString(1, product.getProductName());
			statement.setString(2, product.getBrand());
			statement.setString(3, product.getCategory());

			statement.setDouble(4, product.getPrice());

			// covert local date to sql date object
			statement.setDate(5, Date.valueOf(product.getMfgDate()));
			statement.setDate(6, Date.valueOf(product.getExpiryDate()));
			statement.setString(7, product.getWeightInGms());

			boolean result = statement.execute();
			System.out.println("inserted: " + !result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(int productId, double price) {
		Connection connection = ConnectionUtil.openConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);
			statement.setDouble(1, price);
			statement.setInt(2, productId);
			int result = statement.executeUpdate();
			System.out.println("updated " + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int productId) {
		Connection connection = ConnectionUtil.openConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);
			statement.setInt(1, productId);
			boolean result = statement.execute();
			System.out.println("Record deleted" + !result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(Queries.GETALLQUERY);
				ResultSet resultSet = statement.executeQuery()) {
			products = convertToList(resultSet);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public List<Product> getByBrand(String brand) {
		List<Product> products = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(Queries.GETBYBRAND);) {
			statement.setString(1, brand);
			try (ResultSet resultSet = statement.executeQuery()) {
				products = convertToList(resultSet);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> getByCategory(String category) {
		List<Product> products = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(Queries.GETBYCATEGORY);) {
			statement.setString(1, category);
			try (ResultSet resultSet = statement.executeQuery()) {
				products = convertToList(resultSet);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> getByLesserPrice(double price) {
		List<Product> products = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(Queries.GETBYLESSERPRICE);) {
			statement.setDouble(1, price);
			try (ResultSet resultSet = statement.executeQuery()) {
				products = convertToList(resultSet);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;

	}

	@Override
	public Product getById(int productId) {
		Product product = null;

		try (PreparedStatement statement = connection.prepareStatement(Queries.GETBYIDQUERY);) {
			statement.setInt(1, productId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					product = new Product();
					String productName = resultSet.getString("product_name");
					Date date = resultSet.getDate("mfg_date");
					LocalDate mfgDate = date.toLocalDate();
					product.setProductName(productName);
					product.setBrand(resultSet.getString("brand"));
					product.setCategory(resultSet.getString("category"));
					product.setPrice(resultSet.getDouble("price"));
					product.setWeightInGms(resultSet.getString("weight_in_gms"));
					product.setMfgDate(mfgDate);
					product.setExpiryDate(resultSet.getDate("expiry_date").toLocalDate());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<String> getProductNames() {
		List<String> productNames = new ArrayList<String>();
		try (PreparedStatement statement = connection.prepareStatement(Queries.GETPRODUCTNAMEQUERY);
				ResultSet resultSet = statement.executeQuery();) {
			while (resultSet.next()) {
				String prdNames = resultSet.getString("product_name");
				productNames.add(prdNames);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productNames;
	}

	@Override
	public List<Product> getByNameAndExpiry(String productName, String date) {
		List<Product> products = new ArrayList<>();

		try (PreparedStatement statement = connection.prepareStatement(Queries.GETBYNAMEANDEXPIRY);) {
			statement.setString(1, productName);
			statement.setString(2, date);
			try (ResultSet resultSet = statement.executeQuery();) {
				products = convertToList(resultSet);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> getByBrandAndLesserPrice(String brand, double price) {
		List<Product> products = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(Queries.GETBYBRANDANDLESSPRICE);) {
			statement.setString(1, brand);
			statement.setDouble(2, price);
			try (ResultSet resultSet = statement.executeQuery();) {
				products = convertToList(resultSet);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	private List<Product> convertToList(ResultSet resultSet) throws Exception {
		List<Product> products = new ArrayList<>();
		while (resultSet.next()) {
			String productName = resultSet.getString("product_name");
			Date date = resultSet.getDate("mfg_date");
			LocalDate mfgDate = date.toLocalDate();
			Product product = new Product();
			product.setProductName(productName);
			product.setBrand(resultSet.getString("brand"));
			product.setCategory(resultSet.getString("category"));
			product.setPrice(resultSet.getDouble("price"));
			product.setWeightInGms(resultSet.getString("weight_in_gms"));
			product.setMfgDate(mfgDate);
			product.setExpiryDate(resultSet.getDate("expiry_date").toLocalDate());

			products.add(product);

		}
		return products;

	}
}
package com.productapp.dao;

import java.util.List;

import com.productapp.model.Product;

public interface IProductDao {

	void addProduct(Product product);

	void updateProduct(int productId, double price);

	void deleteProduct(int productId);

	List<Product> getAll();

	List<Product> getByBrand(String brand);

	List<Product> getByCategory(String category);

	List<Product> getByLesserPrice(double price);

	Product getById(int productId); // returns one product

	List<String> getProductNames();

	List<Product> getByNameAndExpiry(String productName, String date);

	List<Product> getByBrandAndLesserPrice(String brand, double price);
}

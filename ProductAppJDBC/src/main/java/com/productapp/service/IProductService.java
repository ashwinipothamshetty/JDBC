package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductService {

	// CRUD operation
	void addProduct(Product product);

	void updateProduct(int productId, double price);

	void deleteProduct(int productId);

	List<Product> getAll();

	List<Product> getByBrand(String brand) throws ProductNotFoundException;

	List<Product> getByCategory(String category) throws ProductNotFoundException;

	List<Product> getByLesserPrice(double price)throws ProductNotFoundException;

	Product getById(int productId)throws ProductNotFoundException; // returns one product

	List<String> getProductNames()throws ProductNotFoundException;
	
	List<Product> getByNameAndExpiry(String productName, String date);

	List<Product> getByBrandAndLesserPrice(String brand, double price);
}

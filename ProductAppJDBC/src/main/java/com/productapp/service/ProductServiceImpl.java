package com.productapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.productapp.dao.IProductDao;
import com.productapp.dao.ProductDaoImpl;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;

public class ProductServiceImpl implements IProductService {

	private IProductDao productDao = new ProductDaoImpl();

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public void updateProduct(int productId, double price) {
		productDao.updateProduct(productId, price);
	}

	@Override
	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = productDao.getAll();
		return products.stream().sorted((p1, p2) -> p1.getProductName().compareTo(p2.getProductName()))
				.collect(Collectors.toList());

	}

	@Override
	public List<Product> getByBrand(String brand) {
		List<Product> products = productDao.getByBrand(brand);
		if (products.isEmpty()) {
			throw new ProductNotFoundException("Product with this brand is not available");
		}
		return products.stream().sorted(Comparator.comparing(Product::getProductName)).collect(Collectors.toList());
	}

	@Override
	public List<Product> getByCategory(String category) {
		List<Product> products = productDao.getByCategory(category);
		if (products.isEmpty()) {
			throw new ProductNotFoundException("Product with this category is not available");
		}
		return products.stream().sorted(Comparator.comparing(Product::getProductName)).collect(Collectors.toList());
	}

	@Override
	public List<Product> getByLesserPrice(double price) {
		List<Product> products = productDao.getByLesserPrice(price);
		if (products.isEmpty()) {
			throw new ProductNotFoundException("Products within this price are not available");
		}
		return products.stream().sorted(Comparator.comparing(Product::getProductName)).collect(Collectors.toList());
	}

	@Override
	public Product getById(int productId) {
		Product product = productDao.getById(productId);
		if (product == null)
			throw new ProductNotFoundException("Invalid Id");
		return product;
	}

	@Override
	public List<String> getProductNames() {
		return productDao.getProductNames().stream().sorted().collect(Collectors.toList());
	}

	@Override
	public List<Product> getByNameAndExpiry(String productName, String date) {
		List<Product> products= productDao.getByNameAndExpiry(productName, date);
		if (products.isEmpty()) {
			throw new ProductNotFoundException("Products with this name and expiry date are not available");
		}
		return products;
	}

	@Override
	public List<Product> getByBrandAndLesserPrice(String brand, double price) {
		List<Product> products= productDao.getByBrandAndLesserPrice(brand, price);
		if (products.isEmpty()) {
			throw new ProductNotFoundException("Products with this Brand and price within this range are not available");
		}
		return products;	}

}

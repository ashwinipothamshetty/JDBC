package com.productapp.main;

import java.time.LocalDate;
import java.util.List;

import com.productapp.model.Product;
import com.productapp.service.IProductService;
import com.productapp.service.ProductServiceImpl;
import com.productapp.util.ConnectionUtil;

public class Client {

	public static void main(String[] args) {
		ConnectionUtil.openConnection();
		Product product = new Product("Salt", "Tata", "groceries", 20.00, LocalDate.now(), LocalDate.of(2025, 12, 22),
				"500gms");

		IProductService productService = new ProductServiceImpl();
		productService.addProduct(product);
		productService.updateProduct(1, 100.00);
		productService.deleteProduct(2);

		List<Product> products = productService.getAll();
		products.forEach(System.out::println);

		productService.getByCategory("groceries").forEach(System.out::println);

		productService.getByLesserPrice(50).forEach(System.out::println);

		Product prod = productService.getById(5);

		System.out.println(prod);

		productService.getProductNames().forEach(System.out::println);

		productService.getByNameAndExpiry("Atta", LocalDate.now().toString()).forEach(System.out::println);
		;

		productService.getByBrandAndLesserPrice("Tata", 50).forEach(System.out::println);
		;

		ConnectionUtil.closeConnection();

	}

}

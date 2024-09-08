package com.training.productapp;

public class Product {

	String productName;
	String category;
	Integer productId;
	Double price;
	String brand;

	public Product() {
		super();
	}

	public Product(String productName, String category, Integer productId, Double price, String brand) {
		super();
		this.productName = productName;
		this.category = category;
		this.productId = productId;
		this.price = price;
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", category=" + category + ", productId=" + productId
				+ ", price=" + price + ", brand=" + brand + "]";
	}
	
	

}

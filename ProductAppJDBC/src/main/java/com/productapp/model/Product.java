package com.productapp.model;

import java.time.LocalDate;

public class Product {

	private String productName; // biscuit ,bread,chips,butter,sugar,
	private String brand;
	private String category;
	private double price;
	private LocalDate expiryDate;
	private LocalDate mfgDate;
	private String weightInGms;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, String brand, String category, double price,
			LocalDate expiryDate, LocalDate mfgDate, String weightInGms) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.expiryDate = expiryDate;
		this.mfgDate = mfgDate;
		this.weightInGms = weightInGms;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public LocalDate getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}

	public String getWeightInGms() {
		return weightInGms;
	}

	public void setWeightInGms(String weightInGms) {
		this.weightInGms = weightInGms;
	}

	
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", brand=" + brand + ", category=" + category + ", price="
				+ price + ", expiryDate=" + expiryDate + ", mfgDate=" + mfgDate + ", weightInGms=" + weightInGms + "]";
	}
	

}

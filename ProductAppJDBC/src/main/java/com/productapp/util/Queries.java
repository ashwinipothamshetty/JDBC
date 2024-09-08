package com.productapp.util;

public class Queries {

	public static final String CREATEQUERY = """
							 create table product(product_name varchar(20),
							 product_id int(20) primary key auto_increment,
							 brand varchar(20),
							 category varchar(20),
							 price float,
							 mfg_date date,
							expiry_date date,
							weight_in_gms varchar(20))
			""";

	public static final String INSERTQUERY = """

						insert into product(product_name,brand,category,price,mfg_date,expiry_date,weight_in_gms)values
								(?,?,?,?,?,?,?);
			""";

	public static final String UPDATEQUERY = """
			UPDATE product set price=? where product_id=?
			""";

	public static final String DELETEQUERY = """
			Delete from product where product_id=?
			""";

	public static final String GETALLQUERY = """
			select * from product;
			""";
	
	public static final String GETBYIDQUERY = """
			select * from product where product_id=?
			""";
	
	public static final String GETBYBRAND = """
			select * from product where brand=?
			""";
	
	public static final String GETBYCATEGORY = """
			select * from product where CATEGORY=?
			""";
	
	public static final String GETPRODUCTNAMEQUERY = """
			select product_name from product;
			""";

	public static final String GETBYLESSERPRICE = """
			select * from product where price<?;
			""";

	public static final String GETBYNAMEANDEXPIRY = """
			select * from product where product_name=? and expiry_date=?;
			""";

	public static final String GETBYBRANDANDLESSPRICE = """
			select * from product where brand=? and PRICE<?;
			""";
}

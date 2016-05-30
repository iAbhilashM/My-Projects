

productDetails.put(4598, new Product(4598, "Moto G3", "Best phone in market", new Date("12-May-2016"),
				new Date("14-Aug-2017"), 130000, new Category(1, "Electronics", "Electronics Items"),
				new SubCategory(101, "Mobile", new Category(1, "Electronics", "Electronic Items")),
				new Supplier(1001, "Rahul", "Raju", "Chamrajnagar", "Mysore", "Karnataka", "570016", "9439422696"),
				null, 12, 3.5f));



------------------------------------------


package com.flp.pms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;

public class ProductDaoImplForList implements IProductDao {

	// ----------------------------------------------------------------------------------------------
	// Central Repository
	// ----------------------------------------------------------------------------------------------
	Map<Integer, Product> productDetails = new HashMap<>();

	// ----------------------------------------------------------------------------------------------
	// Category Repository
	// ----------------------------------------------------------------------------------------------
	@Override
	public List<Category> getAllCategory() {

		List<Category> categories = new ArrayList<>();
		categories.add(new Category(1, "Electronics", "Electronics Items"));
		categories.add(new Category(2, "Clothing", "All Cloth Varity"));
		categories.add(new Category(3, "Health&Care", "All Health & Care Items"));
		categories.add(new Category(4, "HouseHolds", "All House Holds Items"));
		categories.add(new Category(5, "Sports", "All Sport Accessories"));

		return categories;
	}

	// ----------------------------------------------------------------------------------------------
	// Sub-category Repository
	// ----------------------------------------------------------------------------------------------
	@Override
	public List<SubCategory> getAllSubCategory() {

		List<SubCategory> subCategories = new ArrayList<>();
		subCategories.add(new SubCategory(101, "Mobile", new Category(1, "Electronics", "Electronic Items")));
		subCategories.add(new SubCategory(102, "PowerBank", new Category(1, "Electronics", "Electronic Items")));
		subCategories.add(new SubCategory(103, "Data Storage", new Category(1, "Electronics", "Electronic Items")));

		subCategories.add(new SubCategory(201, "T-Shirt", new Category(2, "Clothing", "All Cloth Varity")));
		subCategories.add(new SubCategory(202, "Kurta", new Category(2, "Clothing", "All Cloth Varity")));
		subCategories.add(new SubCategory(203, "Saree", new Category(2, "Clothing", "All Cloth Varity")));
		subCategories.add(new SubCategory(204, "Kids Wear", new Category(2, "Clothing", "All Cloth Varity")));

		subCategories
				.add(new SubCategory(301, "Diabetic Shoes", new Category(3, "Health&Care", "Health And Hospitality")));
		subCategories
				.add(new SubCategory(302, "Diabetic Metre", new Category(3, "Health&Care", "Health And Hospitality")));
		subCategories.add(
				new SubCategory(303, "Blood Pressure Metre", new Category(3, "Health&Care", "Health And Hospitality")));

		subCategories.add(new SubCategory(401, "Dining Sets", new Category(4, "HouseHolds", "HouseHold Items")));
		subCategories.add(new SubCategory(402, "Cooker", new Category(4, "HouseHolds", "HouseHold Items")));
		subCategories.add(new SubCategory(403, "Knife", new Category(4, "HouseHolds", "HouseHold Items")));
		subCategories.add(new SubCategory(404, "Glasses", new Category(4, "HouseHolds", "HouseHold Items")));

		subCategories.add(new SubCategory(501, "Cricket Bat", new Category(5, "Sports", "Games related Items")));
		subCategories.add(new SubCategory(502, "Cricket Ball", new Category(5, "Sports", "Games related Items")));
		subCategories.add(new SubCategory(503, "Hockey Bat", new Category(5, "Sports", "Games related Items")));
		subCategories.add(new SubCategory(504, "Hockey Ball", new Category(5, "Sports", "Games related Items")));
		subCategories.add(new SubCategory(505, "Volley Ball", new Category(5, "Sports", "Games related Items")));

		return subCategories;
	}

	// ----------------------------------------------------------------------------------------------
	// Discount Repository
	// ----------------------------------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	public List<Discount> getAllDiscounts() {

		List<Discount> discounts = new ArrayList<>();
		discounts.add(
				new Discount(111, "Mega Offer", "Mega offer From Jan to Feb", 12.4, new Date(2005 - 1900, 10, 02)));
		discounts.add(
				new Discount(222, "Diwali Offer", "Diwali offer From Oct to Nov", 18.0, new Date(2017 - 1900, 12, 02)));
		discounts.add(
				new Discount(333, "Holi Offer", "Holi offer From Mar to Jun", 20.0, new Date(2010 - 1900, 10, 02)));
		discounts.add(new Discount(444, "Dusehra Offer", "Dusehra offer From Jan to Feb", 20.4,
				new Date(2016 - 1900, 10, 02)));
		discounts.add(
				new Discount(555, "X-Mas Offer", "X-Mas offer From Dec to Jan", 12.4, new Date(2017 - 1900, 10, 02)));
		discounts.add(new Discount(666, "New Year Offer", "New Year offer From Jan to Feb", 12.4,
				new Date(2018 - 1900, 10, 02)));
		discounts.add(
				new Discount(777, "Pongal Offer", "Pongal offer From Jan to Feb", 12.4, new Date(2017 - 1900, 05, 02)));
		discounts.add(
				new Discount(888, "Onam Offer", "Onam offer From Jan to Feb", 12.4, new Date(2005 - 1900, 10, 02)));

		return discounts;
	}

	// ----------------------------------------------------------------------------------------------
	// Adding product to Central Repository
	// ----------------------------------------------------------------------------------------------
	@Override
	public void addProduct(Product product) {
		productDetails.put(product.getProductId(), product);
		System.out.println("Product is successfully added!!");
	}

	// ----------------------------------------------------------------------------------------------
	// To return Central Repository
	// ----------------------------------------------------------------------------------------------
	public Map<Integer, Product> getAllMapProducts() {
		return productDetails;
	}

}

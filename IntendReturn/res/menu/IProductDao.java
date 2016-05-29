package com.flp.pms.dao;

import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;

public interface IProductDao {

	public List<Category> getAllCategory();

	public List<SubCategory> getAllSubCategory();

	public List<Discount> getAllDiscounts();

	public void addProduct(Product product);

	public Map<Integer, Product> getAllMapProducts();
	
}

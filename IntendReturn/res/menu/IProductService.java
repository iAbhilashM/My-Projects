package com.flp.pms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;

public interface IProductService {

	public List<Category> getAllCategory();

	public List<SubCategory> getAllSubCategory();

	public List<Discount> getAllDiscounts();

	public void addProduct(Product product);

	public int generateProductId();

	public Map<Integer, Product> getAllMapProducts();

	public List<Product> getAllProducts();

	public Product searchByProductId(int productId);

	public List<Product> searchByProductName(String productName);

	public List<Product> searchBySupplier(String supplierName);

	public List<Product> searchByCategory(String categoryName);

	public List<Product> searchBySubCategory(String subCategoryName);

	public List<Product> searchByRating(float rating);

	public Product updateProductName(String productName, Product product);

	public Product updateProductDescription(String productDescription, Product product);

	public Product updateProductManufacturingDate(Date manufacturingDate, Product product);

	public Product updateProductExpiryDate(Date expiryDate, Product product);

	public Product updateProductQuantity(int quantity, Product product);

	public Product updateProductMaximumRetailPrice(double maximumRetailPrice, Product product);

	public Product updateProductMaximumRetailPrice(float maximumRetailPrice, Product product);

	public Product updateProductRating(float rating, Product product);

	public Product updateCategory(Category category, Product product);

	public Product updateSubCategory(SubCategory SubCategory, Product product);

	public Product updateSupplier(Supplier supplier, Product product);

	public Product deleteProduct(Product product);
}

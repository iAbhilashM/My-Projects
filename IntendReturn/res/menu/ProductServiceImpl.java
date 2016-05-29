package com.flp.pms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.pms.dao.IProductDao;
import com.flp.pms.dao.ProductDaoImplForList;
import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;
import com.flp.pms.view.BootClass;

public class ProductServiceImpl implements IProductService {

	// ----------------------------------------------------------------------------------------------
	private IProductDao iProductDao = new ProductDaoImplForList();

	// ----------------------------------------------------------------------------------------------
	public List<Category> getAllCategory() {
		return iProductDao.getAllCategory();
	}

	// ----------------------------------------------------------------------------------------------
	@Override
	public List<SubCategory> getAllSubCategory() {
		return iProductDao.getAllSubCategory();
	}

	// ----------------------------------------------------------------------------------------------
	@Override
	public List<Discount> getAllDiscounts() {
		return iProductDao.getAllDiscounts();
	}

	// ----------------------------------------------------------------------------------------------
	public void addProduct(Product product) {

		Map<Integer, Product> maps = iProductDao.getAllMapProducts();
		boolean flag = false;
		Set<Integer> productIds = maps.keySet();
		int generatedProductId = generateProductId();

		// Generate unique Product Id
		if (!maps.isEmpty()) {
			do {
				flag = false;
				generatedProductId = generateProductId();
				for (Integer productId : productIds) {
					if (productId == generatedProductId || ("" + generatedProductId).length() != 4) {
						flag = true;
						break;
					}
				}
			} while (flag);

		}
		product.setProductId(generatedProductId);

		iProductDao.addProduct(product);
	}

	// ----------------------------------------------------------------------------------------------
	public int generateProductId() {
		return (int) (Math.random() * 10000);
	}

	// ----------------------------------------------------------------------------------------------
	@Override
	public Map<Integer, Product> getAllMapProducts() {

		return iProductDao.getAllMapProducts();
	}

	// ----------------------------------------------------------------------------------------------
	@Override
	public List<Product> getAllProducts() {
		Collection<Product> collectionProduct = getAllMapProducts().values();
		List<Product> listProducts = new ArrayList<>();
		for (Product product : collectionProduct)
			listProducts.add(product);
		return listProducts;
	}

	// ----------------------------------------------------------------------------------------------
	public Product searchByProductId(int productId) {
		Product searchedProduct = null;
		List<Product> allProducts = getAllProducts();
		for (Product product : allProducts) {
			if (product.getProductId() == productId) {
				searchedProduct = product;
				break;
			}
		}
		return searchedProduct;
	}

	// ----------------------------------------------------------------------------------------------
	public List<Product> searchByProductName(String productName) {
		List<Product> searchedProducts = new ArrayList<>();
		List<Product> allProducts = getAllProducts();

		for (Product product : allProducts) {
			if (product.getProductName().substring(0, productName.length()).equalsIgnoreCase(productName))
				searchedProducts.add(product);
		}
		return searchedProducts;
	}

	// ----------------------------------------------------------------------------------------------
	public List<Product> searchBySupplier(String supplierName) {
		List<Product> searchedProducts = new ArrayList<>();
		List<Product> allProducts = getAllProducts();

		for (Product product : allProducts) {
			if (product.getSupplier().getFirstName().substring(0, supplierName.length()).equalsIgnoreCase(supplierName)
					|| product.getSupplier().getLastName().substring(0, supplierName.length())
							.equalsIgnoreCase(supplierName)
					|| (product.getSupplier().getFirstName() + " " + product.getSupplier().getLastName())
							.substring(0, supplierName.length()).equalsIgnoreCase(supplierName)
					|| (product.getSupplier().getLastName() + " " + product.getSupplier().getFirstName())
							.substring(0, supplierName.length()).equalsIgnoreCase(supplierName))
				searchedProducts.add(product);
		}
		return searchedProducts;
	}

	// ----------------------------------------------------------------------------------------------
	public List<Product> searchByCategory(String categoryName) {
		List<Product> searchedProducts = new ArrayList<>();
		List<Product> allProducts = getAllProducts();

		for (Product product : allProducts) {
			if (product.getCategory().getCategoryName().substring(0, categoryName.length())
					.equalsIgnoreCase(categoryName))
				searchedProducts.add(product);
		}
		return searchedProducts;
	}

	// ----------------------------------------------------------------------------------------------
	public List<Product> searchBySubCategory(String subCategoryName) {
		List<Product> searchedProducts = new ArrayList<>();
		List<Product> allProducts = getAllProducts();

		for (Product product : allProducts) {
			if (product.getSubCategory().getSubCategoryName().substring(0, subCategoryName.length())
					.equalsIgnoreCase(subCategoryName))
				searchedProducts.add(product);
		}
		return searchedProducts;
	}

	// ----------------------------------------------------------------------------------------------
	public List<Product> searchByRating(float rating) {
		List<Product> searchedProducts = new ArrayList<>();
		List<Product> allProducts = getAllProducts();
		for (Product product : allProducts) {
			if (product.getRating() == rating)
				searchedProducts.add(product);
		}
		return searchedProducts;
	}

	// ----------------------------------------------------------------------------------------------
	public Product updateProductName(String productName, Product product) {
		if (BootClass.userConfirmationForUpdate()) {
			product.setProductName(productName);
			iProductDao.getAllMapProducts().put(product.getProductId(), product);
			return product;
		}
		return null;
	}

	// ----------------------------------------------------------------------------------------------
	public Product updateProductDescription(String productDescription, Product product) {
		if (BootClass.userConfirmationForUpdate()) {
			product.setDescription(productDescription);
			iProductDao.getAllMapProducts().put(product.getProductId(), product);
			return product;
		}
		return null;
	}

	// ----------------------------------------------------------------------------------------------
	public Product updateProductManufacturingDate(Date manufacturingDate, Product product) {
		if (BootClass.userConfirmationForUpdate()) {
			product.setManufacturingDate(manufacturingDate);
			;
			iProductDao.getAllMapProducts().put(product.getProductId(), product);
			return product;
		}
		return null;
	}

	// ----------------------------------------------------------------------------------------------
	public Product updateProductExpiryDate(Date expiryDate, Product product) {
		if (BootClass.userConfirmationForUpdate()) {
			product.setExpiryDate(expiryDate);
			;
			iProductDao.getAllMapProducts().put(product.getProductId(), product);
			return product;
		}
		return null;
	}

	// ----------------------------------------------------------------------------------------------
	public Product updateProductQuantity(int quantity, Product product) {
		if (BootClass.userConfirmationForUpdate()) {
			product.setQuantity(quantity);
			iProductDao.getAllMapProducts().put(product.getProductId(), product);
			return product;
		}
		return null;
	}

	// ----------------------------------------------------------------------------------------------
	public Product updateProductMaximumRetailPrice(double maximumRetailPrice, Product product) {
		if (BootClass.userConfirmationForUpdate()) {
			product.setMaximumRetailPrice(maximumRetailPrice);
			iProductDao.getAllMapProducts().put(product.getProductId(), product);
			return product;
		}
		return null;
	}

	// ----------------------------------------------------------------------------------------------
	public Product updateProductMaximumRetailPrice(float maximumRetailPrice, Product product) {
		if (BootClass.userConfirmationForUpdate()) {
			product.setMaximumRetailPrice(maximumRetailPrice);
			iProductDao.getAllMapProducts().put(product.getProductId(), product);
			return product;
		}
		return null;
	}

	// ----------------------------------------------------------------------------------------------
	public Product updateProductRating(float rating, Product product) {
		if (BootClass.userConfirmationForUpdate()) {
			product.setRating(rating);
			iProductDao.getAllMapProducts().put(product.getProductId(), product);
			return product;
		}
		return null;
	}

	// ----------------------------------------------------------------------------------------------
	public Product updateCategory(Category category, Product product) {
		if (BootClass.userConfirmationForUpdate()) {
			product.setCategory(category);
			iProductDao.getAllMapProducts().put(product.getProductId(), product);
			return product;
		}
		return null;
	}

	// ----------------------------------------------------------------------------------------------
	public Product updateSubCategory(SubCategory SubCategory, Product product) {
		if (BootClass.userConfirmationForUpdate()) {
			product.setSubCategory(SubCategory);
			iProductDao.getAllMapProducts().put(product.getProductId(), product);
			return product;
		}
		return null;
	}

	// ----------------------------------------------------------------------------------------------
	public Product updateSupplier(Supplier supplier, Product product) {
		if (BootClass.userConfirmationForUpdate()) {
			product.setSupplier(supplier);
			iProductDao.getAllMapProducts().put(product.getProductId(), product);
			return product;
		} else
			return null;
	}

	// ----------------------------------------------------------------------------------------------
	public Product deleteProduct(Product product) {
		if (BootClass.userConfirmationForDelete()) {
			getAllMapProducts().remove(product.getProductId(), product);
			return product;
		} else
			return null;
	}
}

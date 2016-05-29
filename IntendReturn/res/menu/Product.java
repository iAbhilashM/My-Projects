package com.flp.pms.domain;

import java.util.Date;
import java.util.List;

public class Product {

	// Product instance variables
	private int productId;
	private String productName;
	private String description;
	private Date manufacturingDate;
	private Date expiryDate;
	private double maximumRetailPrice;
	private Category category;
	private SubCategory subCategory;
	private Supplier supplier;
	private List<Discount> discounts;
	private int quantity;
	private float rating;

	// no argument constructor
	public Product() {

	}

	// argument constructor
	public Product(int productId, String productName, String description, Date manufacturingDate, Date expiryDate,
			double maximumRetailPrice, Category category, SubCategory subCategory, Supplier supplier,
			List<Discount> discounts, int quantity, float rating) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.maximumRetailPrice = maximumRetailPrice;
		this.category = category;
		this.subCategory = subCategory;
		this.supplier = supplier;
		this.discounts = discounts;
		this.quantity = quantity;
		this.rating = rating;
	}

	// public getters and setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getMaximumRetailPrice() {
		return maximumRetailPrice;
	}

	public void setMaximumRetailPrice(double maximumRetailPrice) {
		this.maximumRetailPrice = maximumRetailPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	// toString() is overridden
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", manufacturingDate=" + manufacturingDate + ", expiryDate=" + expiryDate + ", maximumRetailPrice="
				+ maximumRetailPrice + ", category=" + category + ", subCategory=" + subCategory + ", supplier="
				+ supplier + ", discounts=" + discounts + ", quantity=" + quantity + ", rating=" + rating + "]";
	}

	// hashCode() is overridden
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((discounts == null) ? 0 : discounts.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((manufacturingDate == null) ? 0 : manufacturingDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(maximumRetailPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + quantity;
		result = prime * result + Float.floatToIntBits(rating);
		result = prime * result + ((subCategory == null) ? 0 : subCategory.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		return result;
	}

	// equals() is overridden
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discounts == null) {
			if (other.discounts != null)
				return false;
		} else if (!discounts.equals(other.discounts))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (manufacturingDate == null) {
			if (other.manufacturingDate != null)
				return false;
		} else if (!manufacturingDate.equals(other.manufacturingDate))
			return false;
		if (Double.doubleToLongBits(maximumRetailPrice) != Double.doubleToLongBits(other.maximumRetailPrice))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (quantity != other.quantity)
			return false;
		if (Float.floatToIntBits(rating) != Float.floatToIntBits(other.rating))
			return false;
		if (subCategory == null) {
			if (other.subCategory != null)
				return false;
		} else if (!subCategory.equals(other.subCategory))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		return true;
	}

}

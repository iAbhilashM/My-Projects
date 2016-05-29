package com.flp.pms.domain;

public class SubCategory {

	// SubCategory instance variables
	private int subCategoryId;
	private String subCategoryName;
	private Category category;

	// no argument constructor
	public SubCategory() {
	}

	// argument constructor
	public SubCategory(int subCategoryId, String subCategoryName, Category category) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.category = category;
	}

	// public getters and setters
	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	// toString() is overridden
	@Override
	public String toString() {
		return "SubCategory [subCategory_Id=" + subCategoryId + ", subCategoryName=" + subCategoryName
				+ ", category=" + category + "]";
	}

	// hashCode() is overridden
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + subCategoryId;
		result = prime * result + ((subCategoryName == null) ? 0 : subCategoryName.hashCode());
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
		SubCategory other = (SubCategory) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (subCategoryId != other.subCategoryId)
			return false;
		if (subCategoryName == null) {
			if (other.subCategoryName != null)
				return false;
		} else if (!subCategoryName.equals(other.subCategoryName))
			return false;
		return true;
	}

}

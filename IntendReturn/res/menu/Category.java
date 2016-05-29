package com.flp.pms.domain;

public class Category {

	// Category instance variables
	private int categoryId;
	private String categoryName;
	private String description;

	// no argument constructor
	public Category() {
	}

	// argument constructor
	public Category(int category_Id, String category_Name, String description) {
		super();
		this.categoryId = category_Id;
		this.categoryName = category_Name;
		this.description = description;
	}

	// public getters and setters
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int category_Id) {
		this.categoryId = category_Id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String category_Name) {
		this.categoryName = category_Name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// toString() is overridden
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description="
				+ description + ", getCategoryId()=" + getCategoryId() + ", getCategoryName()=" + getCategoryName()
				+ ", getDescription()=" + getDescription() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	// hashCode() is overridden
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Category other = (Category) obj;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

}

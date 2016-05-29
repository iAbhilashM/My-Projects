package com.flp.pms.domain;

import java.util.Date;

public class Discount {

	// Discount instance variables
	private int discountId;
	private String discountName;
	private String description;
	private double discountPercenatge;
	private Date validThrough;

	// no argument constructor
	public Discount() {
	}

	// argument constructor
	public Discount(int discountId, String discountName, String description, double discountPercenatge,
			Date validThrough) {
		super();
		this.discountId = discountId;
		this.discountName = discountName;
		this.description = description;
		this.discountPercenatge = discountPercenatge;
		this.validThrough = validThrough;
	}

	// public getters and setters
	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDiscountPercenatge() {
		return discountPercenatge;
	}

	public void setDiscountPercenatge(double discountPercenatge) {
		this.discountPercenatge = discountPercenatge;
	}

	public Date getValidThrough() {
		return validThrough;
	}

	public void setValidThrough(Date validThrough) {
		this.validThrough = validThrough;
	}

	// toString() is overridden
	@Override
	public String toString() {
		return "Discount [discountId=" + discountId + ", discountName=" + discountName + ", description=" + description
				+ ", discountPercenatge=" + discountPercenatge + ", validThrough=" + validThrough + "]";
	}

	// hashCode() is overridden
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + discountId;
		result = prime * result + ((discountName == null) ? 0 : discountName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discountPercenatge);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((validThrough == null) ? 0 : validThrough.hashCode());
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
		Discount other = (Discount) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discountId != other.discountId)
			return false;
		if (discountName == null) {
			if (other.discountName != null)
				return false;
		} else if (!discountName.equals(other.discountName))
			return false;
		if (Double.doubleToLongBits(discountPercenatge) != Double.doubleToLongBits(other.discountPercenatge))
			return false;
		if (validThrough == null) {
			if (other.validThrough != null)
				return false;
		} else if (!validThrough.equals(other.validThrough))
			return false;
		return true;
	}

}

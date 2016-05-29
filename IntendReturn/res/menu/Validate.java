package com.flp.pms.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validate {

	// ----------------------------------------------------------------------------------------------
	// Checking valid product name.
	// ----------------------------------------------------------------------------------------------
	public static boolean isValidProductName(String productName) {
		return productName.matches("[A-Z][A-Za-z1-9_$ ]*");
	}

	// ----------------------------------------------------------------------------------------------
	// Checking valid date format.
	// ----------------------------------------------------------------------------------------------
	public static boolean isValidDateFormat(String givenDate) {

		return givenDate.matches(
				"([0-2][1-9]|10|20|30|31)-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec|jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)-[12][7890]\\d{2}");

	}

	// ----------------------------------------------------------------------------------------------
	// Checking valid February date.
	// ----------------------------------------------------------------------------------------------
	public static boolean isValidFebruaryDate(String givenDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		sdf.setLenient(false);
		return (sdf.parse(givenDate, new ParsePosition(0)) != null);
	}

	// ----------------------------------------------------------------------------------------------
	// Checking valid expire date.(It should be a future date.)
	// ----------------------------------------------------------------------------------------------
	public static boolean isValidExpiryDate(Date expiryDate) {
		return expiryDate.after(new Date());
	}

	// ----------------------------------------------------------------------------------------------
	// Checking valid expire date.(It should be a after manufacturing date.)
	// ----------------------------------------------------------------------------------------------
	public static boolean isValidExpiryDateRespectToManufacturingDate(Date expiryDate, Date manufactutingDate) {
		return expiryDate.after(manufactutingDate);
	}

	// ----------------------------------------------------------------------------------------------
	// Checking valid manufacturing date.(It should be a before expire date.)
	// ----------------------------------------------------------------------------------------------
	public static boolean isValidManufacturingDateRespectToExpiryDate(Date manufactutingDate, Date expiryDate) {
		return manufactutingDate.before(expiryDate);
	}

	// ----------------------------------------------------------------------------------------------
	// Checking valid rating.
	// ----------------------------------------------------------------------------------------------
	public static boolean isValidRating(float ratings) {
		if (ratings >= 0.0f && ratings <= 5.0)
			return true;
		else
			return false;
	}

	// ----------------------------------------------------------------------------------------------
	// Checking valid contact number.
	// ----------------------------------------------------------------------------------------------
	public static boolean isValidContactNo(String contactNo) {
		return contactNo.matches("\\d{10}");
	}

	// ----------------------------------------------------------------------------------------------
	// Checking valid quantity.
	// ----------------------------------------------------------------------------------------------
	public static boolean isValidQuantity(int quantity) {
		return quantity > 0;
	}
}

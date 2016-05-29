package com.flp.pms.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;
import com.flp.pms.util.Validate;

public class UserInteraction {
	// ----------------------------------------------------------------------------------------------
	// For welcome greetings to user.
	// ----------------------------------------------------------------------------------------------
	public static void userGreetigs() {
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		System.out.println("Hi,\nPlease enter your name:");
		System.out.print("-> ");
		String name = scn.nextLine();
		String greeting = "";
		Calendar c = Calendar.getInstance();
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

		if (timeOfDay >= 0 && timeOfDay < 12) {
			greeting = "Good Morning";
		} else if (timeOfDay >= 12 && timeOfDay < 16) {
			greeting = "Good Afternoon";
		} else if (timeOfDay >= 16 && timeOfDay < 21) {
			greeting = "Good Evening";
		} else if (timeOfDay >= 21 && timeOfDay < 24) {
			greeting = "Good Night";
		}

		System.out.println(greeting + ", " + name + "!!");

	}

	// ----------------------------------------------------------------------------------------------
	// Taking all the fields from user for adding product.
	// ----------------------------------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	public Product addProduct(List<Category> categories, List<SubCategory> subCategories, List<Discount> discounts,
			List<Supplier> suppliers) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		boolean flagFeb = false;
		Product product = new Product();

		// prompting product name
		String productName;
		do {
			System.out.println("Enter Product Name:");
			productName = sc.nextLine();
			flag = Validate.isValidProductName(productName);
			if (!flag)
				System.out.println(
						"- Invalid Product Name!! [Start with a upper-case letter & no special characters allowed]");
		} while (!flag);
		product.setProductName(productName);

		// prompting product description
		System.out.println("Enter product Description:");
		String description = sc.nextLine();
		product.setDescription(description);

		// prompting product manufacturing date
		String manufacturingDate;
		// checking product manufacturing date is is in correct date format
		do {
			do {
				System.out.println("Enter Manufacturing Date: [In DD-MMM-YYYY format]");
				manufacturingDate = sc.next();
				flag = Validate.isValidDateFormat(manufacturingDate);
				if (!flag)
					System.out.println("- Invalid Date format!!");
			} while (!flag);
			flagFeb = Validate.isValidFebruaryDate(manufacturingDate);
			if (!flagFeb)
				System.out.println("- Invalid February month date!!");
		} while (!flagFeb);
		product.setManufacturingDate(new Date(manufacturingDate));

		// prompting product expire date
		String expiryDate;
		boolean expiryFlag = false;
		boolean expiryRespectToManufacturingFlag = false;

		do {
			do {
				do {
					do {
						System.out.println("Enter Expiry Date: [In DD-MMM-YYYY format]");
						expiryDate = sc.next();
						// checking product expire date is in correct date
						// format
						flag = Validate.isValidDateFormat(expiryDate);
						if (!flag) {
							System.out.println("- Invalid Date format!!");
						}
					} while (!flag);

					flagFeb = Validate.isValidFebruaryDate(expiryDate);
					if (!flagFeb)
						System.out.println("- Invalid February month date!!");
				} while (!flagFeb);
				// checking product expire date is a future date
				expiryFlag = Validate.isValidExpiryDate(new Date(expiryDate));
				if (!expiryFlag)
					System.out.println("- Invalid. Expiry date must be future Date!!");
			} while (!expiryFlag);
			// checking product expire date is after manufacturing date
			expiryRespectToManufacturingFlag = Validate
					.isValidExpiryDateRespectToManufacturingDate(new Date(expiryDate), new Date(manufacturingDate));
			if (!expiryRespectToManufacturingFlag)
				System.out.println("- Invalid. Expiry date must be after Manufacturing date!!");
		} while (!expiryRespectToManufacturingFlag);
		product.setExpiryDate(new Date(expiryDate));

		// prompting maximum retail price
		System.out.println("Enter Maximum Retail Price (MRP):");
		double mrprice = sc.nextDouble();
		product.setMaximumRetailPrice(mrprice);

		float rating = 0.0f;
		do {
			System.out.println("Enter Product Rating:");
			rating = sc.nextFloat();
			// checking valid rating
			flag = Validate.isValidRating(rating);
			if (!flag)
				System.out.println("- Invalid. Rating should be, in beetween (0-5)!!");
		} while (!flag);
		product.setRating(rating);
		System.out.println("---------------------------------------------");
		System.out.println("- Quite a few info, Aahaa? Just few more!! ;)\nPress any key and enter to continue.");
		@SuppressWarnings("unused")
		String move = sc.next();
		Category category = getCategory(categories);
		product.setCategory(category);

		SubCategory subCategory = getSubCategory(subCategories, category);
		product.setSubCategory(subCategory);

		Supplier supplier = getSuppliers(suppliers);
		product.setSupplier(supplier);

		String discountCheck = "";
		System.out.println("Do you want to avail discount? Y/N");
		discountCheck = sc.next().charAt(0) + "";
		if (discountCheck.equalsIgnoreCase("y")) {
			List<Discount> avalilableDiscounts = getDiscounts(discounts);
			product.setDiscounts(avalilableDiscounts);
		}

		int quantity = 0;
		do {
			System.out.println("Enter product Quantity:");
			quantity = sc.nextInt();
			// checking valid quantity
			flag = Validate.isValidQuantity(quantity);
			if (!flag)
				System.out.println("- Invalid. Quantity should be +ve integer!!");

		} while (!flag);
		product.setQuantity(quantity);

		System.out.println("-------------------------------------------");
		return product;
	}

	// ----------------------------------------------------------------------------------------------
	// To view and choosing categories.
	// ----------------------------------------------------------------------------------------------
	public Category getCategory(List<Category> categories) {

		Category category = null;
		int choice = 0;
		boolean flag = false;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			for (Category c : categories) {
				System.out.println(c.getCategoryId() + "\t" + c.getCategoryId() + "\t" + c.getDescription());
			}
			System.out.println("Enter Category Id:");
			choice = sc.nextInt();

			for (Category c : categories) {
				if (choice == c.getCategoryId()) {
					category = c;
					flag = true;
					break;
				}
			}

			if (!flag)
				System.out.println("- Invalid Category Id. Choose a valid one!!");
		} while (!flag);
		return category;

	}

	// ----------------------------------------------------------------------------------------------
	// To view and choosing sub-categories.
	// ----------------------------------------------------------------------------------------------
	public SubCategory getSubCategory(List<SubCategory> subCategories, Category category) {
		SubCategory subCategory = null;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int option;
		boolean flag = false;
		do {
			System.out.println("Choose Product Sub Category:");
			for (SubCategory sCatagory : subCategories) {
				if (sCatagory.getCategory().getCategoryId() == category.getCategoryId()) {
					System.out.println(sCatagory.getSubCategoryId() + "\t" + sCatagory.getSubCategoryName());
				}
			}
			option = sc.nextInt();

			for (SubCategory sCategory : subCategories) {
				if (option == sCategory.getSubCategoryId()) {
					subCategory = sCategory;
					flag = true;
					break;
				}
			}

			if (!flag)
				System.out.println("- Invalid Sub-Category Id. Choose a valid one!!");

		} while (!flag);
		return subCategory;

	}

	// ----------------------------------------------------------------------------------------------
	// To view and choosing suppliers.
	// ----------------------------------------------------------------------------------------------
	public Supplier getSuppliers(List<Supplier> suppliers) {
		Supplier supplier = null;
		int choice = 0;
		boolean flag = false;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			for (Supplier s : suppliers) {
				System.out.println(s.getSupplierId() + "\t" + s.getFirstName() + "\t" + s.getLastName() + "\t"
						+ s.getAddress() + "\t" + s.getCity() + "\t" + s.getState() + "\t" + s.getPincode() + "\t"
						+ s.getContactNo());
			}
			System.out.println("Enter Supplier Id:");
			choice = sc.nextInt();

			for (Supplier s : suppliers) {
				if (choice == s.getSupplierId()) {
					supplier = s;
					flag = true;
					break;
				}
			}

			if (!flag)
				System.out.println("- Invalid Supplier Id. Choose a valid one!!");
		} while (!flag);
		return supplier;

	}

	// ----------------------------------------------------------------------------------------------
	// To view and choosing discounts.
	// ----------------------------------------------------------------------------------------------
	public List<Discount> getDiscounts(List<Discount> discounts) {
		List<Discount> discountsApplied = new ArrayList<Discount>();
		List<Discount> discountsAvailable = new ArrayList<Discount>();
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean flag = false;
		String choice = "";
		out: do {
			flag = false;
			boolean flagCheckDuplicacy = true;

			do {
				flag = false;

				if (!discountsAvailable.isEmpty())
					if (discountsApplied.containsAll(discountsAvailable)) {
						System.out.println("- No more discount(s) available.");
						System.out.println("-->Proceeding to adding product.");
						break out;
					}

				System.out.println("Choose Dicounts for the Product:");
				for (Discount discount : discounts) {
					// Checking valid discounts
					if (discount.getValidThrough().after(new Date())) {
						discountsAvailable.add(discount);
						if (!discountsApplied.contains(discount))
							System.out.println(discount.getDiscountId() + "\t" + discount.getDiscountName() + "\t"
									+ discount.getDescription() + "\t" + discount.getDiscountPercenatge());
					}
				}
				option = sc.nextInt();
				flagCheckDuplicacy = true;
				for (Discount discountTaken : discountsApplied) {

					if (option == discountTaken.getDiscountId()) {
						flagCheckDuplicacy = false;
						flag = true;
						break;

					}
				}
				Discount discountFound = null;
				if (flagCheckDuplicacy) {

					for (Discount discount : discountsAvailable) {
						flag = false;
						if (discount.getDiscountId() == option) {
							flag = true;
							discountFound = discount;
							break;
						}
					}
				}
				if (flag) {
					if (!discountsApplied.isEmpty()) {
						double totalDiscount = 0.0;
						for (Discount discountTaken : discountsApplied)
							totalDiscount += discountTaken.getDiscountPercenatge();
						totalDiscount += discountFound.getDiscountPercenatge();
						if (totalDiscount > 40.0) {
							System.out.println("*Maximun 40% discount you can avail.\nYou have already availed:"
									+ (totalDiscount - discountFound.getDiscountPercenatge()) + "%");
							System.out.println("-->Proceeding to adding product.");
							break out;
						}
					}
					discountsApplied.add(discountFound);
				}

				if (!flag)
					System.out.println("- Invalid. Choose a valid Discount Id!!");
				else if (!flagCheckDuplicacy)
					System.out.println("- Choosen Discount is already applied!!");

			} while (!flag && flagCheckDuplicacy);
			if (flag && flagCheckDuplicacy)
				System.out.println("# Discount is applied.");
			System.out.println("Do you wish to add more discounts for this product? Y/N");
			choice = sc.next();
		} while (choice.equalsIgnoreCase("y"));
		return discountsApplied;
	}

	// ----------------------------------------------------------------------------------------------
	// Viewing products.
	// ----------------------------------------------------------------------------------------------
	public void viewProducts(List<Product> listProduct) {

		if (!listProduct.isEmpty()) {
			System.out.println(listProduct.size() + ": Result(s) found.");

			for (Product product : listProduct) {
				System.out.println(product);
			}
			System.out.println("- No more Result(s).");
		} else {
			System.out.println("- No result(s) found!! :(");
		}
	}

	// ----------------------------------------------------------------------------------------------
	// Viewing updated product status.
	// ----------------------------------------------------------------------------------------------
	public void viewUpdatedProductStatus(Product product) {
		if (product != null) {
			System.out.println("- Product is successfully updated.");
			System.out.println(product);
		} else {
			System.out.println("- Product is not updated.");
		}
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for product id.
	// ----------------------------------------------------------------------------------------------
	public int getProductIdFromUser() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product Id:");
		int productId = sc.nextInt();
		return productId;
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for product name.
	// ----------------------------------------------------------------------------------------------
	public String getProductNameFromUser() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product name/any related keyword:");
		String productName = sc.nextLine();
		return productName;
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for supplier name.
	// ----------------------------------------------------------------------------------------------
	public String getSupplierFromUser() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter supplier name/any related keyword:");
		String supplierName = sc.nextLine();
		return supplierName;
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for category name.
	// ----------------------------------------------------------------------------------------------
	public String getCategoryFromUser() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter category name/any related keyword:");
		String categoryName = sc.nextLine();
		return categoryName;
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for sub-category name.
	// ----------------------------------------------------------------------------------------------
	public String getSubCategoryFromUser() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sub-category name/any related keyword:");
		String subCategoryName = sc.nextLine();
		return subCategoryName;
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for rating.
	// ----------------------------------------------------------------------------------------------
	public float getRatingFromUser() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		float rating = 0.0f;
		boolean flag = false;
		do {
			System.out.println("Enter Product Rating:");
			rating = sc.nextFloat();
			// checking valid rating
			flag = Validate.isValidRating(rating);
			if (!flag)
				System.out.println("Rating should be, in beetween (0-5)!!");
		} while (!flag);
		return rating;
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for product name to update.
	// ----------------------------------------------------------------------------------------------
	public String getProductNameForUpdate() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String productName;
		boolean flag = false;
		do {
			System.out.println("Enter Product Name:");
			productName = sc.nextLine();
			flag = Validate.isValidProductName(productName);
			if (!flag)
				System.out.println("Invalid Product Name!!");
		} while (!flag);
		return productName;
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for product description to update.
	// ----------------------------------------------------------------------------------------------
	public String getProductDescriptionForUpdate() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product description:");
		String productDescription = sc.nextLine();
		return productDescription;
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for manufacturing date to update.
	// ----------------------------------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	public Date getManufacturingDateForUpdate(Date expiryDate) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		boolean flagFeb = false;
		boolean manufacturingRespectToExpiryFlag = false;
		String manufacturingDate;
		// checking product manufacturing date is is in correct date format
		do {
			do {
				do {
					System.out.println("Enter Manufacturing Date: [In DD-MMM-YYYY format]");
					manufacturingDate = sc.next();
					flag = Validate.isValidDateFormat(manufacturingDate);
					if (!flag) {
						System.out.println("- Invalid Date format!!");
					}
				} while (!flag);
				flagFeb = Validate.isValidFebruaryDate(manufacturingDate);
				if (!flagFeb)
					System.out.println("- Invalid February month date!!");
			} while (!flagFeb);
			manufacturingRespectToExpiryFlag = Validate
					.isValidManufacturingDateRespectToExpiryDate(new Date(manufacturingDate), expiryDate);
			if (!manufacturingRespectToExpiryFlag)
				System.out.println("- Invalid. Manufacturing date must be before Expiry date!!");
		} while (!manufacturingRespectToExpiryFlag);
		return new Date(manufacturingDate);
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for expire date to update.
	// ----------------------------------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	public Date getExpiryDateForUpdate(Date manufacturingDate) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String expiryDate;
		boolean flag = false;
		boolean expiryFlag = false;
		boolean expiryRespectToManufacturingFlag = false;
		boolean flagFeb = false;
		do {
			do {
				do {
					do {
						System.out.println("Enter Expiry Date: [In DD-MMM-YYYY format]");
						expiryDate = sc.next();
						// checking product expire date is in correct date
						// format
						flag = Validate.isValidDateFormat(expiryDate);
						if (!flag) {
							System.out.println("- Invalid Date format!!");
						}
					} while (!flag);
					flagFeb = Validate.isValidFebruaryDate(expiryDate);
					if (!flagFeb)
						System.out.println("- Invalid February month date!!");
				} while (!flagFeb);
				// checking product expire date is a future date
				expiryFlag = Validate.isValidExpiryDate(new Date(expiryDate));
				if (!expiryFlag)
					System.out.println("- Invalid. Expiry date must be future Date!!");
			} while (!expiryFlag);
			// checking product expire date is after manufacturing date
			expiryRespectToManufacturingFlag = Validate
					.isValidExpiryDateRespectToManufacturingDate(new Date(expiryDate), manufacturingDate);
			if (!expiryRespectToManufacturingFlag)
				System.out.println("- Invalid. Expiry date must be after Manufacturing date!!");
		} while (!expiryRespectToManufacturingFlag);
		return new Date(expiryDate);
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for product quantity to update.
	// ----------------------------------------------------------------------------------------------
	public int getProductQuantityForUpdate() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		int quantity = 0;
		do {
			System.out.println("Enter product Quantity:");
			quantity = sc.nextInt();
			// checking valid quantity
			flag = Validate.isValidQuantity(quantity);
			if (!flag)
				System.out.println("- Invalid. Quantity should be +ve integer!!");

		} while (!flag);
		return quantity;
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for MRP to update.
	// ----------------------------------------------------------------------------------------------
	public double getMaximumRetailPriceForUpdate() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		double maximumRetailPrice = 0.0;
		System.out.println("Enter product Maximum Retail Price:");
		maximumRetailPrice = sc.nextDouble();
		return maximumRetailPrice;
	}

	// ----------------------------------------------------------------------------------------------
	// To prompt for rating to update.
	// ----------------------------------------------------------------------------------------------
	public float getRatingForUpdate() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		float rating = 0.0f;
		do {
			System.out.println("Enter Product Rating:");
			rating = sc.nextFloat();
			// checking valid rating
			flag = Validate.isValidRating(rating);
			if (!flag)
				System.out.println("- Invalid. Rating should be, in beetween (0-5)!!");
		} while (!flag);
		return rating;
	}

	// ----------------------------------------------------------------------------------------------
	// Taking user confirmation to update.
	// ----------------------------------------------------------------------------------------------
	public boolean userConfirmationForUpdate() {
		String userConfirm = "";
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		System.out.println("Are you really want to update this product?(Y/N)\nNote: There is no Undo!!");
		userConfirm = scn.next();
		if (userConfirm.equalsIgnoreCase("y")) {
			return true;
		} else {

			return false;
		}
	}

	// ----------------------------------------------------------------------------------------------
	// Taking user confirmation to delete.
	// ----------------------------------------------------------------------------------------------
	public boolean userConfirmationForDelete() {
		String userConfirm = "";
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		System.out.println("Are you really want to delete this product?(Y/N)\nNote: There is no Undo!!");
		userConfirm = scn.next();
		if (userConfirm.equalsIgnoreCase("y")) {
			return true;
		} else {

			return false;
		}
	}

	// ----------------------------------------------------------------------------------------------
	// Showing delete status, according to user confirmation.
	// ----------------------------------------------------------------------------------------------
	public void viewDeletedProductStatus(Product product) {
		if (product != null)
			System.out.println("- Product having Product Id: " + product.getProductId() + " is deleted successfully!!");
		else
			System.out.println("- Product is not deleted!!");
	}
}

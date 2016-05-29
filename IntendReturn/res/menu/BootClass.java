package com.flp.pms.view;

import java.util.Scanner;

import com.flp.pms.domain.Product;
import com.flp.pms.service.IProductService;
import com.flp.pms.service.ISupplierService;
import com.flp.pms.service.ProductServiceImpl;
import com.flp.pms.service.SupplierServiceImpl;

public class BootClass {

	/*
	 * @author Abhilash Mishra | KIN # 71094_FS
	 */

	// ----------------------------------------------------------------------------------------------
	// Main method to start application
	// ----------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		System.out.println("-: Welcome to CG Product Management System :-");
		System.out.println("---------------------------------------------");
		UserInteraction.userGreetigs();
		System.out.println("---------------------------------------------");
		System.out.println("Now, you can continue with managing produts:");
		menuSelection();

	}

	// ----------------------------------------------------------------------------------------------
	// Menu for all operation.
	// ----------------------------------------------------------------------------------------------
	public static void menuSelection() {
		String option = "";
		String checkOption = "";
		String checkSearchOption = "";
		String checkUpdateOption = "";
		UserInteraction userInteraction = new UserInteraction();
		IProductService iProductService = new ProductServiceImpl();
		ISupplierService iSupplierService = new SupplierServiceImpl();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Create Product" + "\n2. Update Product" + "\n3. Remove Product"
					+ "\n4. View All Product" + "\n5. Search Product" + "\n6. Exit");
			System.out.println("Enter your Option:");
			option = sc.next();
			switch (option) {
			case "1":
				Product product = userInteraction.addProduct(iProductService.getAllCategory(),
						iProductService.getAllSubCategory(), iProductService.getAllDiscounts(),
						iSupplierService.getAllSupplier());
				iProductService.addProduct(product);
				break;
			case "2":

				do {
					int optionUpdate = 0;
					Product productToUpdate = iProductService.searchByProductId(userInteraction.getProductIdFromUser());
					if (productToUpdate != null) {
						System.out.println("Product found.");
						System.out.println(productToUpdate);
						System.out.println("What you want to update?");
						System.out.println("1. Product Name" + "\n2. Product Description" + "\n3. Manufacturing Date"
								+ "\n4. Expire Date" + "\n5. MRP" + "\n6. Quantity" + "\n7. Rating" + "\n8. Category"
								+ "\n9. Sub-Category" + "\n10. Supplier");
						optionUpdate = sc.nextInt();
						switch (optionUpdate) {
						case 1:
							userInteraction.viewUpdatedProductStatus(iProductService
									.updateProductName(userInteraction.getProductNameForUpdate(), productToUpdate));
							break;
						case 2:
							userInteraction.viewUpdatedProductStatus(iProductService.updateProductDescription(
									userInteraction.getProductDescriptionForUpdate(), productToUpdate));
							break;
						case 3:
							userInteraction.viewUpdatedProductStatus(iProductService.updateProductManufacturingDate(
									userInteraction.getManufacturingDateForUpdate(productToUpdate.getExpiryDate()), productToUpdate));
							break;
						case 4:
							userInteraction.viewUpdatedProductStatus(iProductService.updateProductExpiryDate(
									userInteraction.getExpiryDateForUpdate(productToUpdate.getManufacturingDate()),
									productToUpdate));
							break;
						case 5:
							userInteraction.viewUpdatedProductStatus(iProductService.updateProductMaximumRetailPrice(
									userInteraction.getMaximumRetailPriceForUpdate(), productToUpdate));

							break;
						case 6:
							userInteraction.viewUpdatedProductStatus(iProductService.updateProductQuantity(
									userInteraction.getProductQuantityForUpdate(), productToUpdate));
							break;
						case 7:
							userInteraction.viewUpdatedProductStatus(iProductService
									.updateProductRating(userInteraction.getRatingForUpdate(), productToUpdate));

							break;
						case 8:
							userInteraction.viewUpdatedProductStatus(iProductService.updateCategory(
									userInteraction.getCategory(iProductService.getAllCategory()), productToUpdate));
							break;
						case 9:
							userInteraction.viewUpdatedProductStatus(iProductService.updateSubCategory(userInteraction
									.getSubCategory(iProductService.getAllSubCategory(), productToUpdate.getCategory()),
									productToUpdate));
							break;
						case 10:
							userInteraction.viewUpdatedProductStatus(iProductService.updateSupplier(
									userInteraction.getSuppliers(iSupplierService.getAllSupplier()), productToUpdate));
							break;

						default:
							System.out.println("Invalid option choosen!!");
							break;
						}
					} else {
						System.out.println("Product not found!!");

					}
					System.out.println("Do you want to continue with updating? Y/N");
					checkUpdateOption = sc.next();
				} while (checkUpdateOption.equalsIgnoreCase("y"));
				System.out.println("Made an Exit: From updating section!!");
				break;
			case "3":

				Product productToDelete = iProductService.searchByProductId(userInteraction.getProductIdFromUser());
				if (productToDelete != null) {
					System.out.println("Product found.");
					System.out.println(productToDelete);
					userInteraction.viewDeletedProductStatus(iProductService.deleteProduct(productToDelete));
				} else
					System.out.println("Product not found!!");
				break;
			case "4":
				userInteraction.viewProducts(iProductService.getAllProducts());
				break;
			case "5":
				do {
					int searchOption = 0;
					System.out.println("Search by:" + "\n1. Product Name" + "\n2. Producer(Supplier)" + "\n3. Category"
							+ "\n4. Sub-Category" + "\n5. Rating");
					System.out.println("Enter search by option:");
					searchOption = sc.nextInt();
					switch (searchOption) {
					case 1:
						userInteraction.viewProducts(
								iProductService.searchByProductName(userInteraction.getProductNameFromUser()));
						break;
					case 2:
						userInteraction
								.viewProducts(iProductService.searchBySupplier(userInteraction.getSupplierFromUser()));
						break;
					case 3:
						userInteraction
								.viewProducts(iProductService.searchByCategory(userInteraction.getCategoryFromUser()));

						break;
					case 4:
						userInteraction.viewProducts(
								iProductService.searchBySubCategory(userInteraction.getSubCategoryFromUser()));

						break;
					case 5:
						userInteraction
								.viewProducts(iProductService.searchByRating(userInteraction.getRatingFromUser()));

						break;

					default:
						break;
					}
					System.out.println("Do you want to continue with searching? Y/N");
					checkSearchOption = sc.next();
				} while (checkSearchOption.equalsIgnoreCase("y"));
				System.out.println("Made an Exit: From searching section!!");
				break;
			case "6":
				System.out.println("Thank you!! Have a nice day.");
				System.exit(1);
				break;
			default:
				System.out.println("Invalid option choosen!!");
				break;
			}
			System.out.println("Do you want to continue? Y/N");
			checkOption = sc.next();
		} while (checkOption.equalsIgnoreCase("y"));
		System.out.println("Thank you!! Have a nice day.");
	}

	// ----------------------------------------------------------------------------------------------
	// Getting user confirmation for update from UserInteraction.
	// ----------------------------------------------------------------------------------------------
	public static boolean userConfirmationForUpdate() {
		UserInteraction userInteraction = new UserInteraction();
		return userInteraction.userConfirmationForUpdate();
	}

	// ----------------------------------------------------------------------------------------------
	// Getting user confirmation for delete from UserInteraction.
	// ----------------------------------------------------------------------------------------------
	public static boolean userConfirmationForDelete() {
		UserInteraction userInteraction = new UserInteraction();
		return userInteraction.userConfirmationForDelete();
	}
}
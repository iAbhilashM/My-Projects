package com.flp.pms.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.flp.pms.domain.Category;
import com.flp.pms.service.IProductService;
import com.flp.pms.service.ISupplierService;
import com.flp.pms.service.ProductServiceImpl;
import com.flp.pms.service.SupplierServiceImpl;
import static org.hamcrest.CoreMatchers.*;

public class ServiceTestCases {

	static IProductService iProductService;
	static ISupplierService iSupplierService;

	@BeforeClass
	public static void setUp() {
		iProductService = new ProductServiceImpl();
		iSupplierService = new SupplierServiceImpl();
	}

	@Test
	public void testLengthOfGeneratedProductId() {
		String stringGeneratedProductId = iProductService.generateProductId() + "";
		assertEquals(4, stringGeneratedProductId.length());
	}

	@Test
	public void testCountAllCategoriesWithAllOptions() {
		List<Category> categories = iProductService.getAllCategory();
		assertThat(categories.size(), allOf(is(5), instanceOf(Integer.class)));
	}

	@Test
	public void testGetAllCategory() {
		assertEquals(false, iProductService.getAllCategory().isEmpty());
	}

	@Test
	public void testGetAllSubCategory() {
		assertEquals(false, iProductService.getAllSubCategory().isEmpty());
	}

	@Test
	public void testGetAllDiscount() {
		assertEquals(false, iProductService.getAllDiscounts().isEmpty());
	}

	@Test
	public void testGetAllSupplier() {
		assertEquals(false, iSupplierService.getAllSupplier().isEmpty());
	}

	@Test
	public void testMapOfProducts() {
		assertEquals(true, iProductService.getAllMapProducts().isEmpty());
	}

	@Test
	public void testCountOfMapProduct() {
		assertEquals(0, iProductService.getAllMapProducts().size());
	}

	@Test
	public void testCountOfAllcategories() {
		assertEquals(5, iProductService.getAllCategory().size());
	}

	@Test
	public void testCountOfAllSubCategories() {
		assertEquals(19, iProductService.getAllSubCategory().size());
	}

	@Test
	public void testCountOfAllDiscounts() {
		assertEquals(8, iProductService.getAllDiscounts().size());
	}

	@Test
	public void testCountOfAllSuppliers() {
		assertEquals(6, iSupplierService.getAllSupplier().size());
	}
}

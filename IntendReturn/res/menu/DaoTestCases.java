package com.flp.pms.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.flp.pms.dao.IProductDao;
import com.flp.pms.dao.ISupplierDao;
import com.flp.pms.dao.ProductDaoImplForList;
import com.flp.pms.dao.SupplierDaoImplForList;

public class DaoTestCases {

	static IProductDao iProductDao;
	static ISupplierDao iSupplierDao;

	@BeforeClass
	public static void setUp() {
		iProductDao = new ProductDaoImplForList();
		iSupplierDao = new SupplierDaoImplForList();
	}

	@Test
	public void testGetAllCategory() {
		assertEquals(false, iProductDao.getAllCategory().isEmpty());
	}

	@Test
	public void testGetAllSubCategory() {
		assertEquals(false, iProductDao.getAllSubCategory().isEmpty());
	}

	@Test
	public void testGetAllDiscount() {
		assertEquals(false, iProductDao.getAllDiscounts().isEmpty());
	}

	@Test
	public void testGetAllSupplier() {
		assertEquals(false, iSupplierDao.getAllSupplier().isEmpty());
	}

	@Test
	public void testMapOfProducts() {
		assertEquals(true, iProductDao.getAllMapProducts().isEmpty());
	}

	@Test
	public void testCountOfMapProduct() {
		assertEquals(0, iProductDao.getAllMapProducts().size());
	}

	@Test
	public void testCountOfAllcategories() {
		assertEquals(5, iProductDao.getAllCategory().size());
	}

	@Test
	public void testCountOfAllSubCategories() {
		assertEquals(19, iProductDao.getAllSubCategory().size());
	}

	@Test
	public void testCountOfAllDiscounts() {
		assertEquals(8, iProductDao.getAllDiscounts().size());
	}

	@Test
	public void testCountOfAllSuppliers() {
		assertEquals(6, iSupplierDao.getAllSupplier().size());
	}

}

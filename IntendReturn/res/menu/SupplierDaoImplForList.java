package com.flp.pms.dao;

import java.util.ArrayList;
import java.util.List;

import com.flp.pms.domain.Supplier;

public class SupplierDaoImplForList implements ISupplierDao {

	// ----------------------------------------------------------------------------------------------
	// Supplier Repository
	// ----------------------------------------------------------------------------------------------
	@Override
	public List<Supplier> getAllSupplier() {

		List<Supplier> suppliers = new ArrayList<>();
		suppliers.add(
				new Supplier(1001, "Rahul", "Raju", "Chamrajnagar", "Mysore", "Karnataka", "570016", "9439422696"));
		suppliers.add(new Supplier(2001, "Tapan", "Teja", "Urs Road", "Mysore", "Karnataka", "570006", "9901397387"));
		suppliers.add(new Supplier(3001, "Abhi", "Mishra", "Domlur", "Bangalore", "Karnataka", "560017", "9439421111"));
		suppliers.add(
				new Supplier(4001, "Bantu", "Sahu", "Gachibowli", "Hyderabad", "Telengana", "500032", "9439422696"));
		suppliers.add(new Supplier(5001, "Abhijeet", "Mishra", "Saheed Nagar", "Bhubaneswar", "Odisha", "751030",
				"9439422696"));
		suppliers.add(new Supplier(6001, "Abhipsa", "Das", "Hebbal", "Mysore", "Karnataka", "570016", "9439400000"));

		return suppliers;
	}

}

package com.flp.pms.service;

import java.util.List;

import com.flp.pms.dao.ISupplierDao;
import com.flp.pms.dao.SupplierDaoImplForList;
import com.flp.pms.domain.Supplier;

public class SupplierServiceImpl implements ISupplierService {

	private ISupplierDao iSupplierDao = new SupplierDaoImplForList();

	// ----------------------------------------------------------------------------------------------
	public List<Supplier> getAllSupplier() {
		return iSupplierDao.getAllSupplier();
	}

}

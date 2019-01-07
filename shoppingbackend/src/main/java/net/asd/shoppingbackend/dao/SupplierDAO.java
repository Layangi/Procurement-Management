package net.asd.shoppingbackend.dao;

import java.util.List;

import net.asd.shoppingbackend.dto.Supplier;

public interface SupplierDAO {

	boolean add(Supplier supplier);
	boolean update(Supplier supplier);
	boolean delete(Supplier supplier);
	
	List<Supplier> list();
	List<Supplier> listOfSuppliersByProduct(int productId);
	Supplier getById(int supid);
	
}
 
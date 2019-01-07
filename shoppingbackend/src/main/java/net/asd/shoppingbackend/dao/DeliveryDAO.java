package net.asd.shoppingbackend.dao;

import java.util.List;

import net.asd.shoppingbackend.dto.Delivery;

public interface DeliveryDAO {

	Delivery get(int DelId);

	List<Delivery> list();

	boolean add(Delivery delivery);

	boolean update(Delivery delivery);

	boolean delete(Delivery delivery);

	// Business methods

	// List<Delivery> listActiveDelivery();
	// List<Product> listActiveProductsByCategory(int categoryId);
	// List<Product> getLatestActiveProducts(int count);
}

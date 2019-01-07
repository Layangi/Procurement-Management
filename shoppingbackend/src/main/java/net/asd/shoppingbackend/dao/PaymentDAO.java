package net.asd.shoppingbackend.dao;

import java.util.List;

import net.asd.shoppingbackend.dto.Payment;

public interface PaymentDAO {
	Payment get(int paymentId);
	List<Payment> list();
	boolean add(Payment payment);
	boolean update(Payment payment);
	boolean delete(Payment payment);
	
	//business methods
	List<Payment> listPayments();
	/*List<Payment> listActiveProducts();
	List<Payment> listActiveProductsByCategory(int categoryId);
	List<Payment> getLatestActiveProducts(int count);*/
}

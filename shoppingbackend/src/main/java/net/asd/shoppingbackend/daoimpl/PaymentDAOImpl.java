package net.asd.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.asd.shoppingbackend.dao.PaymentDAO;
import net.asd.shoppingbackend.dto.Payment;

@Repository("paymentDAO")
@Transactional
public class PaymentDAOImpl implements PaymentDAO{
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * 
	 * Single
	 */

	@Override
	public Payment get(int paymentId) {
		try {
			return sessionFactory.getCurrentSession().get(Payment.class, Integer.valueOf(paymentId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Payment> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM Payment",Payment.class).getResultList();

	}
	/*
	 * Insert
	 */

	@Override
	public boolean add(Payment payment) {
		try {
			sessionFactory.getCurrentSession().persist(payment);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;

	}
	/*
	 * Update
	 */

	@Override
	public boolean update(Payment payment) {
		try {
			sessionFactory.getCurrentSession().update(payment);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;

	}

	/*
	 * Delete
	 */
	@Override
	public boolean delete(Payment payment) {
		try {
			//payment.setID(ID);;
			// call update method
			return this.update(payment);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Payment> listPayments() {
		String selectPayments = "FROM Payment";
		return sessionFactory.getCurrentSession().createQuery(selectPayments , Payment.class)
				.setParameter("active", true).getResultList();
	
	}
}

package net.asd.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.asd.shoppingbackend.dao.DeliveryDAO;
import net.asd.shoppingbackend.dto.Delivery;
import net.asd.shoppingbackend.dto.Item;

@Repository("deliveryDAO")
@Transactional
public class DeliveryDAOImpl implements DeliveryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	/*
	 * 
	 * Getting single category based on id
	 */
	@Override
	public Delivery get(int DelId) {

		try {
			return sessionFactory.getCurrentSession().get(Delivery.class, Integer.valueOf(DelId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
		
		//return sessionFactory.getCurrentSession().get(Delivery.class, Integer.valueOf(DelId));
	}

	@Override
	public List<Delivery> list() {
	
		return sessionFactory.getCurrentSession().createQuery("FROM Delivery",Delivery.class).getResultList();
		
	}

	@Override
	public boolean add(Delivery delivery) {

		try {
			sessionFactory.getCurrentSession().persist(delivery);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}
	}

	@Override
	public boolean update(Delivery delivery) {
		try {
			// Updating a single delivery of the database table
			sessionFactory.getCurrentSession().update(delivery);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Delivery delivery) {
		
	//	delivery.setActive(false);
		try {
	
			// Updating a single category of the database table
			sessionFactory.getCurrentSession().update(delivery);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	/*@Override
	public List<Delivery> listActiveDelivery() {

		return null;
		//return sessionFactory.getCurrentSession().createQuery("FROM Delivery", Delivery.class).getResultList();
	}
*/
}

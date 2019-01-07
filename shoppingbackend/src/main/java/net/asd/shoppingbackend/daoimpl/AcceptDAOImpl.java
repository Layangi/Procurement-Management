package net.asd.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.asd.shoppingbackend.dao.AcceptDAO;
import net.asd.shoppingbackend.dto.Accept;
import net.asd.shoppingbackend.dto.Delivery;

@Repository("acceptDAO")
@Transactional
public class AcceptDAOImpl implements AcceptDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Accept get(int AcpId) {
		
		return sessionFactory.getCurrentSession().get(Accept.class, Integer.valueOf(AcpId));
	}

	@Override
	public List<Accept> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Accept",Accept.class).getResultList();
		
	}
	/*
	 * 
	 * Getting single accept based on id
	 */


	@Override
	public boolean add(Accept accept) {
		
		try {
			sessionFactory.getCurrentSession().persist(accept);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}
		
	}

	@Override
	public boolean update(Accept accept) {
		try {
			// Updating a single delivery of the database table
			sessionFactory.getCurrentSession().update(accept);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Accept accept) {
		
		try {
			
			// Updating a single accept of the database table
			sessionFactory.getCurrentSession().update(accept);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

}

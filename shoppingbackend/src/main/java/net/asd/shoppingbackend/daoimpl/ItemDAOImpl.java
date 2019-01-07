package net.asd.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.asd.shoppingbackend.dao.ItemDAO;
import net.asd.shoppingbackend.dto.Item;

@Repository("itemDAO")
@Transactional
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Item get(int itemId) {
		try {
			return sessionFactory.getCurrentSession().get(Item.class, Integer.valueOf(itemId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
		
		//return sessionFactory.getCurrentSession().get(Item.class, Integer.valueOf(itemId));
	}

	@Override
	public List<Item> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Item", Item.class).getResultList();
	}

	@Override
	public boolean add(Item item) {
		
		try {
			sessionFactory.getCurrentSession().persist(item);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}
	}

	@Override
	public boolean update(Item item) {

		try {
			// Updating a single delivery of the database table
			sessionFactory.getCurrentSession().update(item);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Item item) {
		
		try {
			item.setMatched(false);
			// call update method
			sessionFactory.getCurrentSession().update(item);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Item> listActiveItems() {
		
		String selectMatchedItems = "FROM Item WHERE matched = :matched";
		
		return sessionFactory.getCurrentSession().createQuery(selectMatchedItems, Item.class).setParameter("matched", true).getResultList();
	}

}

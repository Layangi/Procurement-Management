package net.asd.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.asd.shoppingbackend.dao.SupplierDAO;
import net.asd.shoppingbackend.dto.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Supplier> list() {

		System.out.println("list supplier inside impl");
		String suppliers = "FROM Supplier WHERE active =:active";
		Query query = sessionFactory.getCurrentSession().createQuery(suppliers,Supplier.class);
		query.setParameter("active", true);
		System.out.println("impl data "+query.getResultList());
		return query.getResultList();
	}
	
	//get single supplier based on id
	@Override
	public Supplier getById(int supid) {
		
		
		return sessionFactory.getCurrentSession().get(Supplier.class,Integer.valueOf(supid));
	}
	
	//add new supplier```````````````	
	@Override
	public boolean add(Supplier supplier) {

		try {
			sessionFactory.getCurrentSession().persist(supplier);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		return false;
		}
	}
	
	//update single supplier
	@Override
	public boolean update(Supplier supplier) {

		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		return false;
		}
	}
	@Override
	public boolean delete(Supplier supplier) {
		supplier.setActive(false);
		return this.update(supplier);
	}

	@Override
	public List<Supplier> listOfSuppliersByProduct(int productId) {
		
		String suppliersByProduct = "FROM Supplier WHERE active-:active AND Id=:productId";
		Query query = sessionFactory.getCurrentSession().createQuery(suppliersByProduct,Supplier.class);
		query.setParameter("active", true);
		query.setParameter("productId", productId);
		return query.getResultList();
	}

}

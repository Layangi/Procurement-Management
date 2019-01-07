package net.asd.shoppingbackend.dao;

import java.util.List;

import net.asd.shoppingbackend.dto.Item;
import net.asd.shoppingbackend.dto.Product;

public interface ItemDAO {

	Item get(int itemId);
	
	List<Item> list();
	
	boolean add(Item item);
	boolean update(Item item);
	boolean delete(Item item);
	
	//business methods
	List<Item> listActiveItems();
}

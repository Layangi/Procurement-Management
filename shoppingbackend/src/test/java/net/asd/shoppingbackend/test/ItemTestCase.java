package net.asd.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.asd.shoppingbackend.dao.ItemDAO;
import net.asd.shoppingbackend.dto.Item;

public class ItemTestCase {
	
	
	private static AnnotationConfigApplicationContext context;

	private static ItemDAO itemDAO;

	private Item item;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.asd.shoppingbackend");
		context.refresh();

		itemDAO = (ItemDAO)context.getBean("itemDAO");
	}

	/*@Test
	public void testAddItem() {

		item = new Item();

		item.setId(1);
		item.setDelid(1);
		item.setItemN("Tyres");
		item.setQuantity(2500);
		item.setMatched(true);

		assertEquals("Succesfuly added delivery details to the table", true, itemDAO.add(item));

	}
	 */
	/*
	 * @Test public void testGetDelivery() {
	 * 
	 * delivery = deliveryDAO.get(1);
	 * assertEquals("Successfully fetched a single delivery from the table", "Tyres",
	 * delivery.getItem()); }
	 */

/*	@Test
	public void testUpdateDelivery() {

		delivery = deliveryDAO.get(1);

		delivery.setItem("New Tyers");

		assertEquals("Successfully updated a single delivery from the table", true, deliveryDAO.update(delivery));
	}*/

	@Test
	public void testCRUDItem() {

		item = new Item();

		// add operation

		item.setId(1);
		item.setDelid(1);
		item.setItemN("Paper");
		item.setQuantity(2500);
		item.setMatched(true);

		assertEquals("Something went wrong while inserting new Product",true,itemDAO.add(item));

		item = new Item();

		item.setId(1);
		item.setDelid(1);
		item.setItemN("Cement");
		item.setQuantity(2000);
		item.setMatched(true);

		assertEquals("Successfull !", true, itemDAO.add(item));


/*		// fetching and updating delivery

		item = itemDAO.get(1);
		item.setItemN("New Tyres");
		assertEquals("Successfully updated !", true, itemDAO.update(item));

		// delete the category

		item = itemDAO.get(2);
	    assertEquals("Successfully deleted !", false,
	    itemDAO.delete(item));
*/
		// fetching the list
		// assertEquals("Successfully fetched a list of categories from the
		// table",1,categoryDAO.list().size());
	}
	
/*	@Test
	public void testlistActiveItems() {
		
		assertEquals("Something went wrong while fetching list of products",3,itemDAO.listActiveItems().size());
	}
*/	

}

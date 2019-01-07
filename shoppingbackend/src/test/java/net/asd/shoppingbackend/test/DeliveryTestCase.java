package net.asd.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.asd.shoppingbackend.dao.DeliveryDAO;
import net.asd.shoppingbackend.dto.Category;
import net.asd.shoppingbackend.dto.Delivery;

public class DeliveryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static DeliveryDAO deliveryDAO;

	private Delivery delivery;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.asd.shoppingbackend");
		context.refresh();

		deliveryDAO = (DeliveryDAO) context.getBean("deliveryDAO");
	}

	/*
	 * @Test public void testAddDelivery() {
	 * 
	 * delivery = new Delivery();
	 * 
	 * delivery.setId(1); delivery.setItem("Tyres"); delivery.setQuantity(1500);
	 * delivery.setDdate("2017-08-14"); delivery.setAmount(45000);
	 * 
	 * assertEquals("Succesfuly added delivery details to the table", true,
	 * deliveryDAO.add(delivery));
	 * 
	 * }
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

/*	@Test
	public void testDeleteDelivery() {

		delivery = deliveryDAO.get(1);
		assertEquals("Successfully deleted a single delivery from the table", true, deliveryDAO.delete(delivery));
	}*/
	
	@Test
	public void testCRUDDelivery() {
		 /*	
		delivery = new Delivery();
		
		// add operation
		delivery.setId(1);
		delivery.setBranch("Kandy");
		delivery.setAddress("No 12,Kandy");
		delivery.setDdate("2017-08-14");
		delivery.setNo("071-3452342");

		assertEquals("Succesfuly added delivery details to the table", true, deliveryDAO.add(delivery));

    	delivery = new Delivery();
		
		delivery.setId(1);
		delivery.setBranch("Kandy");
		delivery.setAddress("No 12,Kandy");
		delivery.setDdate("2017-08-14");
		delivery.setNo("071-3452342");

		assertEquals("Succesfuly added delivery details to the table", true, deliveryDAO.add(delivery));

		//fetching and updating delivery
		
		delivery = deliveryDAO.get(1);
		delivery.setItem("New Tyers");
		assertEquals("Successfully updated a single delivery from the table", true, deliveryDAO.update(delivery));
	*/	
		//delete the category
		
	//	delivery = deliveryDAO.get(1);
    //	assertEquals("Successfully deleted a single delivery from the table", false, deliveryDAO.delete(delivery));

		//fetching the list
	//	assertEquals("Successfully fetched a list of categories from the table",1,categoryDAO.list().size());
	}
}

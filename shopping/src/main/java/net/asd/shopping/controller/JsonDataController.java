package net.asd.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.asd.shoppingbackend.dao.AcceptDAO;
import net.asd.shoppingbackend.dao.DeliveryDAO;
import net.asd.shoppingbackend.dao.ItemDAO;
import net.asd.shoppingbackend.dao.OrdersDAO;
import net.asd.shoppingbackend.dao.PaymentDAO;
import net.asd.shoppingbackend.dao.ProductDAO;
import net.asd.shoppingbackend.dao.SupplierDAO;
import net.asd.shoppingbackend.dto.Accept;
import net.asd.shoppingbackend.dto.Delivery;
import net.asd.shoppingbackend.dto.Item;
import net.asd.shoppingbackend.dto.Orders;
import net.asd.shoppingbackend.dto.Payment;
import net.asd.shoppingbackend.dto.Product;
import net.asd.shoppingbackend.dto.Supplier;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private OrdersDAO ordersDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private DeliveryDAO deliveryDAO;
	@Autowired
	private AcceptDAO acceptDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin(){
		
		return productDAO.list();
	}
	
	@RequestMapping("/admin/all/orders")
	@ResponseBody
	public List<Orders> getAllOrddersForAdmin(){
		
		return ordersDAO.list();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id){
		
		return productDAO.listActiveProductsByCategory(id);
	}

	
	//supplier
	@RequestMapping("/all/supplier")
	@ResponseBody
	public List<Supplier> getAllSupplier(){
		
	//	System.out.println("all supplier json "+supplierDAO.list());
		
		return supplierDAO.list();
	}
	
	@RequestMapping("/supplier/{id}/products")
	@ResponseBody
	public List<Supplier> getSupplierByProducts(@PathVariable int id){
		
		return supplierDAO.listOfSuppliersByProduct(id);
	}
	
	
	//
	@RequestMapping("/all/items")
	@ResponseBody
	public List<Item> getAllItems(){
		
		return itemDAO.list();
	}
	
	@RequestMapping("/all/deliveries")
	@ResponseBody
	public List<Delivery> getAllDelivery(){
		
		return deliveryDAO.list();
	}
	
	@RequestMapping("/all/accepts")
	@ResponseBody
	public List<Accept> getAllAccept(){
		
		return acceptDAO.list();
	}
	
	
	
	//payment
	@RequestMapping("/all/payments")
	@ResponseBody
	public List<Payment> getAllPayments(){
		
		return paymentDAO.list();
	}
}

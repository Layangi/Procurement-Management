package net.asd.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.asd.shoppingbackend.dao.CategoryDAO;
import net.asd.shoppingbackend.dao.ProductDAO;
import net.asd.shoppingbackend.dao.SupplierDAO;
import net.asd.shoppingbackend.dto.Category;
import net.asd.shoppingbackend.dto.Product;
import net.asd.shoppingbackend.dto.Supplier;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private SupplierDAO supplierDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();
		// set few fields
		// nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		if (operation != null) {

			if (operation.equals("product")) {

				mv.addObject("message", "Product Submitted Sccessfuly");
			}

		}

		return mv;

	}

	// handling product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {
		// check if there are any errors
		System.out.println("insede product manage");
		if (results.hasErrors()) {

			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation Failed for product Submission");
			return "page";
		}

		logger.info(mProduct.toString());
		if (mProduct.getId()==0) {
			// create new product record
			productDAO.add(mProduct);
		}
		else {
			//update the product 
			productDAO.update(mProduct);
		}

		return "redirect:/manage/products?operation=product";
	}

	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		// fetch data from the database
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		// activating and de activating base on value of active field
		product.setActive(!product.isActive());
		// update the product
		productDAO.update(product);
		return (isActive) ? "You have succesfuly deactivated the product" + product.getId()
				: "You have succesfuly activated the product" + product.getId();
	}

	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");

		// fetch the product from database
		Product product = productDAO.get(id);

		// set the product from fetch the database
		mv.addObject("product", product);

		return mv;

	}

	@ModelAttribute("suppliers")
	public List<Supplier> getSuppliers() {

		return supplierDAO.list();

	}
}

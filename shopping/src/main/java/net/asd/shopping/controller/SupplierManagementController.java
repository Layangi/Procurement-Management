package net.asd.shopping.controller;

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
import org.springframework.web.servlet.ModelAndView;

import net.asd.shoppingbackend.dao.SupplierDAO;
import net.asd.shoppingbackend.dto.Supplier;

@Controller
@RequestMapping("/manage")
public class SupplierManagementController {

	@Autowired SupplierDAO supplierDAO;
	private static final Logger logger  = LoggerFactory.getLogger(SupplierManagementController.class);
	
	@RequestMapping(value="/supplier",method=RequestMethod.GET)
	public ModelAndView showManageSuppliers(@RequestParam(name="operation",required=false)String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickSupplierManagement",true);
		mv.addObject("title","Manage Suppliers");
		
		Supplier sup = new Supplier();
		sup.setActive(true);
		
		mv.addObject("supplier",sup);
		
		if(operation !=null) {
			if(operation.equals("supplier")) {
				mv.addObject("message","Supplier added Succesfuly");
				
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value="/supplier",method=RequestMethod.POST)
	public String AddSupplier(@Valid @ModelAttribute("supplier") Supplier mSupplier,BindingResult results,Model model) {
		
		if(results.hasErrors()) {
			
			model.addAttribute("userClickSupplierManagement",true);
			model.addAttribute("title","Manage Suppliers");
			
			return "page";
		}
		
		if (mSupplier.getId()==0) {
			// create new suppplier record
			supplierDAO.add(mSupplier);
		}
		else {
			//update the supplier 
			supplierDAO.update(mSupplier);
		}
		
		return "redirect:/manage/supplier?operation=supplier"; 
	}
	
	@RequestMapping(value = "/{id}/supplier", method = RequestMethod.GET)
	public ModelAndView editSupplier(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickSupplierManagement", true);
		mv.addObject("title", "Manage Supplier");

		// fetch the product from database
		Supplier sup = supplierDAO.getById(id);

		// set the product from fetch the database
		mv.addObject("supplier", sup);

		return mv;

	}
}

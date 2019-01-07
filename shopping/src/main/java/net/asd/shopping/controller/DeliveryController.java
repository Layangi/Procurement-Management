package net.asd.shopping.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.asd.shoppingbackend.dao.DeliveryDAO;
import net.asd.shoppingbackend.dto.Delivery;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	private DeliveryDAO deliveryDAO;
	private static final Logger logger = LoggerFactory.getLogger(DeliveryController.class);

	@RequestMapping(value = "/deliverydetails", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickDeliveryDetails", true);
		mv.addObject("title", "Delivery Details");

		Delivery nDelivery = new Delivery();

		// set few fields
		nDelivery.setId(1);
		nDelivery.setDdate("2017-01-11");

		mv.addObject("delivery", nDelivery);

		if (operation != null) {

			if (operation.equals("delivery")) {

				mv.addObject("message", "Delivery Details Submitted Successfully !");
			}

		}

		return mv;

	}
 
	//handling submission
	@RequestMapping(value = "/deliverydetails", method = RequestMethod.POST)

	public String handleOrderSubmission(@Valid @ModelAttribute("delivery") Delivery mdelivery, BindingResult results,
			Model model) {
		// check if there are errors

		if (results.hasErrors()) {

			model.addAttribute("userClickDeliveryDetails", true);
			model.addAttribute("title", "Delivery Details");
			return "page";

		}
		logger.info(mdelivery.toString());
		
		// create a new delivery record
		deliveryDAO.add(mdelivery);

		return "redirect:/delivery/deliverydetails?operation=delivery";
	}

	// returning deliveries for all the request mapping
	/*
	 * @ModelAttribute("deliveries") public List<Delivery> getnDeliveries() {
	 * 
	 * return deliveryDAO.list();
	 * 
	 * }
	 */
}
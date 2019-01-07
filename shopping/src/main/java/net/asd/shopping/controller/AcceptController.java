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

import net.asd.shoppingbackend.dao.AcceptDAO;
import net.asd.shoppingbackend.dto.Accept;

@Controller
@RequestMapping("/accept")
public class AcceptController {

	@Autowired
	private AcceptDAO acceptDAO;
	private static final Logger logger = LoggerFactory.getLogger(AcceptController.class);

	@RequestMapping(value = "/acceptdetails", method = RequestMethod.GET)
	public ModelAndView showAcceptDetails(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickAcceptDetails", true);
		mv.addObject("title", "Accept Details");

		Accept nAccept = new Accept();

		// set some fields
		nAccept.setId(1);

		mv.addObject("accept", nAccept);

		if (operation != null) {

			if (operation.equals("accept")) {

				mv.addObject("message", "Delivered Order has Successfully Confirmed !");
			}

		}
		return mv;

	}

	// handling submission

	@RequestMapping(value = "/acceptdetails", method = RequestMethod.POST)
	public String handleAcceptSubmission(@Valid @ModelAttribute("accept") Accept maccept, BindingResult results,
			Model model) {

		// check if there are errors

		if (results.hasErrors()) {

			model.addAttribute("userClickAcceptDetails", true);
			model.addAttribute("title", "Accept Delivery");
			return "page";

		}

		logger.info(maccept.toString());

		// create a new accept record
		acceptDAO.add(maccept);

		return "redirect:/accept/acceptdetails?operation=accept";
	}
}

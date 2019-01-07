package net.asd.shopping.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.asd.shoppingbackend.dto.Email;

@Controller
@RequestMapping("/email")
public class EmailController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	static String emailToRecipient, emailSubject, emailMessage;
	static final String emailFromRecipient = "malith.yashod@gmail.com";

	static ModelAndView mv;

	@Autowired
	private JavaMailSender mailSenderObj;

	@RequestMapping(value = "/emailForm", method = RequestMethod.GET)

	public ModelAndView showEmailForm(@RequestParam(name = "operation", required = false) String operation) {

		logger.info("Inside Psge Controller index Method - INFO");
		logger.debug("Inside Psge Controller index Method - DEBUG");
		mv = new ModelAndView("page");
		mv.addObject("userClickEmail", true);
		mv.addObject("title", "Send Email");

		Email email = new Email();

		mv.addObject("email", email);

		if (operation != null) {
			if (operation.equals("email")) {
				mv.addObject("message", "Email Submited Succesfuly");

			}
		}

		return mv;

	}

	// This Method Is Used To Prepare The Email Message And Send It To The Client
	@RequestMapping(value = "/emailForm", method = RequestMethod.POST)
	public ModelAndView sendEmailToClient(HttpServletRequest request,
			final @RequestParam CommonsMultipartFile attachFileObj) {
		logger.info("Inside Psge Controller index Method - INFO");
		logger.debug("Inside Psge Controller index Method - DEBUG");
		// Reading Email Form Input Parameters
		emailSubject = request.getParameter("subject");
		emailMessage = request.getParameter("message");
		emailToRecipient = request.getParameter("mailTo");

		// Logging The Email Form Parameters For Debugging Purpose
		System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= "
				+ emailMessage + "\n");

		mailSenderObj.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMsgHelperObj.setTo(emailToRecipient);
				mimeMsgHelperObj.setFrom(emailFromRecipient);
				mimeMsgHelperObj.setText(emailMessage);
				mimeMsgHelperObj.setSubject(emailSubject);

				// Determine If There Is An File Upload. If Yes, Attach It To The Client Email
				if ((attachFileObj != null) && (attachFileObj.getSize() > 0) && (!attachFileObj.equals(""))) {
					System.out.println("\nAttachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
					mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), new InputStreamSource() {
						public InputStream getInputStream() throws IOException {
							return attachFileObj.getInputStream();
						}
					});
				} else {
					System.out.println("\nNo Attachment Is Selected By The User. Sending Text Email!\n");
				}

			}

		});
		System.out.println("\nMessage Send Successfully....\n");

		// mv = new ModelAndView("page");

		return mv;
	}

}

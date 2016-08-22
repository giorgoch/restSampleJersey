package com.giorgoch.projectClient.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/**
	 * @author giorgos chatziefstratiou
	 * this demonstrates a basic  spring mvc controller
	 * 
	 */

	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//logger.info("Welcome home! ");	
		return "jsps/home";
	}

}

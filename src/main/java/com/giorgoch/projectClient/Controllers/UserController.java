package com.giorgoch.projectClient.Controllers;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.giorgoch.projectClient.Model.User;

@Controller
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.GET)
	public String registrationForm(Model model) {
		// logger.info("Welcome home! ");
		model.addAttribute("user", new User());
		return "user/registerform";
	}

	@RequestMapping(value = "/doCreate")
	public String createAccountXML(Model model,  @Valid User user, BindingResult result) {
		if (result.hasErrors()) {   
			System.out.println("::" + result + "::");
			return "user/createaccount";
		}
		if (!result.hasErrors()) {
		user.setId(1); 
				userService.createXMLFormFormData(user);
		}
		System.out.println(user + "user values");
		return "user/accountcreated";
	}

}

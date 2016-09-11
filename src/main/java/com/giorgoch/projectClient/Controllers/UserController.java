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

import com.giorgoch.projectClient.Model.*;
import com.giorgoch.projectClient.Service.UserService;
import com.giorgoch.projectClient.XMLParsers.Writers.XMLParserWriter;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	XMLParserWriter xmlParserwriter;

	@RequestMapping(value = "/createaccount", method = RequestMethod.GET)
	public String registrationForm(Model model) {
		model.addAttribute("user", new User());
		return "jsps/users/registerform";
	}

	@RequestMapping(value = "/doCreate")
	public String createAccountXML(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("::" + result + "::");
			return "jsps/users/createaccount";
		}
		if (!result.hasErrors()) {
			user.setId(1);
			xmlParserwriter.createXMLFormFormData(user);
		}
		System.out.println(user + "user values");
		return "jsps/users/accountcreated";
	}

}

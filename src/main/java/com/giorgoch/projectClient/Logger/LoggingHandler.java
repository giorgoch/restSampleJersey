package com.giorgoch.projectClient.Logger;

import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.giorgoch.projectClient.Model.User;

@Aspect
@Component
public class LoggingHandler {
	/**
	 * @author giorgos chatziefstratiou this demonstrates a basic aop spring
	 *         logger
	 * 
	 */

	 Logger log = LoggerFactory.getLogger(getClass());

	public void loggingUserRegistrationForm() {
		log.info("registration form user controller");
		 //System.out.println("registration form user controller");
	}
	
	 
	public void loggingCreateAccountXML() {
		 log.info("create account xml ");
		// System.out.println("registration form user controller");
	}

}

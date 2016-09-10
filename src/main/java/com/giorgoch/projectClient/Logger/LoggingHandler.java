package com.giorgoch.projectClient.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
		// System.out.println("registration form user controller");
	}

	public void loggingCreateAccountXML() {
		log.info("create account xml method in controller ");
		// System.out.println("registration form user controller");
	}

	@Before(value = "execution(* com.giorgoch.projectClient.XMLParsers.Writers.XMLPraserWriterImpl.createXMLFormFormData(..))")
	public void loggingcreateXMLFormFormDataStart() {
		log.info("Start creating xml with form data ");
	}

	@After(value = "execution(* com.giorgoch.projectClient.XMLParsers.Writers.XMLPraserWriterImpl.createXMLFormFormData(..))")
	public void loggingcreateXMLFormFormDataEnd() {
		log.info("End creating xml wwith form data");
	}

}

package com.giorgoch.projectClient.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
/*
	@Before("loggingXMLFormParserClass()")
	public void loggingcreateXMLFormFormDataStart() {
		log.info("Start creating xml with form data ");
	}

	@After("loggingXMLFormParserClass()")
	public void loggingcreateXMLFormFormDataEnd() {
		log.info("End creating xml wwith form data");
	}
*/
	@Pointcut("execution(* com.giorgoch.projectClient.XMLParsers.Writers.XMLPraserWriterImpl.createXMLFormFormData(..))")
	public void loggingXMLFormParserClass() {

	}

	@Pointcut("execution(* com.giorgoch.projectClient.Resource.UserResource.*())")
	public void loggingWSServices() {

	}

	@Before(value = "loggingWSServices()")
	public void beforeLoggingWsGetJson() {
		log.info("Start creating Json service. ");
	}

	@After(value = "loggingWSServices()")
	public void afterLoggingWsGetJson() {
		log.info("End Json service created!");
	}
	
	@Around("loggingXMLFormParserClass()")
	public void aroundAdvice(ProceedingJoinPoint p){
		log.info("Around advice .....before");
		
		
		try {
			p.proceed();
		} catch (Throwable e) {
			System.out.println("In around Advice ..."+e.getMessage());
		}
		
		log.info("Around advice.....after");
	}
}

package com.giorgoch.projectClient.Service;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingHandler {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(@org.springframework.sterotype.Controller *)")
	public void controller() {

	}

	@Pointcut("execution(* *.*(..)")
	public void allMethod() {

	}

	@Pointcut("execution(public * *(..))")
	protected void loggingPublicOperation() {
	}

	@Pointcut("execution(* *.*(..))")
	protected void loggingAllOperation() {
	}

	@Pointcut("within(org.learn.log..*)")
	private void logAnyFunctionWithinResource() {
	}

	// before -> Any resource annotated with @Controller annotation
	// and all method and function taking HttpServletRequest as first parameter
	@Before("controller() && allMethod() && args(..,request)")
	public void logBefore(JoinPoint joinPoint, HttpServletRequest request) {

		log.debug("Entering in Method :  " + joinPoint.getSignature().getName());
		log.debug("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
		log.debug("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
		log.debug("Target class : " + joinPoint.getTarget().getClass().getName());

		if (null != request) {
			log.debug("Start Header Section of request ");
			log.debug("Method Type : " + request.getMethod());
			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String headerName = headerNames.nextElement();
				String headerValue = request.getHeader(headerName);
				log.debug("Header Name: " + headerName + " Header Value : " + headerValue);
			}
			log.debug("Request Path info :" + request.getServletPath());
			log.debug("End Header Section of request ");
		}
	}
	
	

}

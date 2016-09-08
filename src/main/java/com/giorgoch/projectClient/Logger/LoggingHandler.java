package com.giorgoch.projectClient.Logger;

import org.aspectj.lang.annotation.Aspect;
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

	private final Logger log = LoggerFactory.getLogger(getClass());

	public void print() {
		log.info("print");
		System.out.println("logging print");
	}

	public void printData() {
		log.info("data");
		System.out.println("logging data ");
	}

}

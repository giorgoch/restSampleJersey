package com.giorgoch.projectClient.Service;

import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingHandler {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(@org.springframework.sterotype.Controller *)")
	public void controller() {

	}

	@Pointcut("execution(* *.*(..)")
	public void allMethod(){
		
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
	
	
	
	
	
	
}

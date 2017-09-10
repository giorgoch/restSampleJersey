package com.giorgoch.projectClient.Commons;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@Before("loggingXMLFormParserClass()")
	public void loggingcreateXMLFormFormDataStart() {
		log.info("Start creating xml with form data ");
	}

	@After("loggingXMLFormParserClass()")
	public void loggingcreateXMLFormFormDataEnd() {
		// log.info("End creating xml wwith form data");
	}

	@Pointcut("execution(* com.giorgoch.projectClient.XMLParsers.Writers.XMLPraserWriterImpl.createXMLFormFormData(..))")
	public void loggingXMLFormParserClass() {
		// log.info("testing the pointcut for xml parser");
	}

	@Pointcut("execution(* com.giorgoch.projectClient.Resource.UserResource.*())")
	public void loggingWSServices() {
		log.info("testing  the  logging ws services ");
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
	public void aroundAdvice(ProceedingJoinPoint p) {
		log.info("Around advice .....before");

		try {
			p.proceed();
		} catch (Throwable e) {
			System.out.println("In around Advice ..." + e.getMessage());
		}

		log.info("Around advice.....after");
	}

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controller() {

	}

	@Pointcut("execution(* *.*(..))")
	public void allMethod() {

	}

	@Pointcut("execution(public * *(..))")
	protected void loggingPublicOperation() {
	}

	@Pointcut("execution(* *.*(..) )")
	protected void loggingAllOperation() {
	}

	@Pointcut("within(com.giorgoch.projectClient..*)")
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

	// After -> All method within resource annotated with @Controller annotation
	// and return a value
	@AfterReturning(pointcut = "controller() && allMethod()", returning = "result")
	public void logAfter(JoinPoint joinPoint, Object result) {
		String returnValue = this.getValue(result);
		log.debug("Method Return value : " + returnValue);
	}

	// After -> Any method within resource annotated with @Controller annotation
	// throws an exception ...Log it
	@AfterThrowing(pointcut = "controller() && allMethod()", throwing = "exception")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
		log.error("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
		log.error("Cause : " + exception.getCause());
	}

	// Around -> Any method within resource annotated with @Controller
	// annotation
	@Around("controller() && allMethod()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		long start = System.currentTimeMillis();
		try {
			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			Object result = joinPoint.proceed();
			long elapsedTime = System.currentTimeMillis() - start;
			log.debug("Method " + className + "." + methodName + " ()" + " execution time : " + elapsedTime + " ms");

			return result;
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}

	private String getValue(Object result) {
		String returnValue = null;
		if (null != result) {
			if (result.toString().endsWith("@" + Integer.toHexString(result.hashCode()))) {
				returnValue = ReflectionToStringBuilder.toString(result);
			} else {
				returnValue = result.toString();
			}
		}
		return returnValue;
	}
}

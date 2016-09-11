package com.giorgoch.projectClient.Commons;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.commons.logging.Log;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceLogUtility {
/*
	@Pointcut("execution(* com.giorgoch.projectClient.Dao.UserDaoImpl.*(..))")
	public void timers() {

	}
	
	@Pointcut("execution(* com.giorgoch.projectClient.XMLParsers.*.*(..))")
	public void timersXML() {
 
	}


	@Before("timers()")
	public static Long startRecPerformance(Log log, String msg) {
		log.info(msg);
		return System.currentTimeMillis();
	}

	@After("timers()")
	public static void stoRecPerformance(Log log, Long startTime, String msg) {
		Long currentTimes = System.currentTimeMillis() - startTime;
		BigDecimal bigDec = BigDecimal.valueOf(currentTimes);
		bigDec = bigDec.divide(BigDecimal.valueOf(currentTimes));
		MathContext mc = new MathContext(3);
		log.info(msg + "[" + bigDec.round(mc) + "sec]");
	}
*/
}

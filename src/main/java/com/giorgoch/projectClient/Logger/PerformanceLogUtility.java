package com.giorgoch.projectClient.Logger;

import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.commons.logging.Log;

public class PerformanceLogUtility {

	public static Long startRecPerformance(Log log, String msg) {
		log.info(msg);
		return System.currentTimeMillis();
	}

	public static void stoRecPerformance(Log log, Long startTime, String msg) {
		Long currentTimes = System.currentTimeMillis() - startTime;
		BigDecimal bigDec = BigDecimal.valueOf(currentTimes);
		bigDec = bigDec.divide(BigDecimal.valueOf(currentTimes));
		MathContext mc = new MathContext(3);
		log.info(msg + "[" + bigDec.round(mc) + "sec]");
	}
}

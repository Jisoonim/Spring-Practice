package org.zerock.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class TimeChecker { //실행되기까지의 시간을 측정하는 코드.

	@Around("execution(* org.zerock.mapper.*.*(..))") //pointcut
	public Object checkTime(ProceedingJoinPoint pjp) {
		
		log.info("Target : " + pjp.getTarget());
		log.info("Method : " + pjp.getSignature());
		
		long start = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			result = pjp.proceed(pjp.getArgs());
			log.info("++++++++++++++++++++++++++++++++++++++++++++++");
			log.info(result);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		
		log.info("TIME : " + (end - start));
		
		return result;
	}
}

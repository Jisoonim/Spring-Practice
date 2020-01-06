package org.zerock.aop;

import java.util.Arrays;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before; //aspectj임! junit아니고
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
@Aspect
public class LogAdvice {

	//@Before("execution(* org.zerock.service.*.*(..))") //pointcut
	public void logbefore(JoinPoint jp) {
		
		
		log.info("-----------------------------");
		log.info("-----------------------------");
		log.info("-----------------------------");
		log.info("-----------------------------");
		log.info("-----------------------------");
		
		log.info(Arrays.toString(jp.getArgs()));
	}
}

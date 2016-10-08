package com.hanbit.spring.core.aop;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExampleAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleAspect.class);

	@Pointcut("execution(public * com.hanbit..*.*(..))")
	public void publicExecute() {}
	
	@Pointcut("execution(* get*(..))")
	public void getMethod() {}
	
	@Before("publicExecute() && getMethod()")
	public void runBeforePublicExe() {
		LOGGER.debug("runBefore");
	}
	
	@After("execution(public * com.hanbit..*.*(..)) && execution(* get*(..))")
	public void runAfterPublicExe() {
		LOGGER.debug("runAfter");
	}
	
	@Around("@annotation(org.springframework.web.bind.annotation.ResponseBody)")
	public Object runAroundResponse(ProceedingJoinPoint pjp) {
		
		// Before
		Object returnValue = null;
		
		try {
			returnValue = pjp.proceed();
		}
		catch (Throwable t) {
			// AfterThrowing
		}
		
		// AfterReturning
		if (returnValue instanceof Map) {
			Map result = (Map) returnValue;
			result.put("additional", "aop");
		}
		
		// After
		
		return returnValue;
	}
	
}

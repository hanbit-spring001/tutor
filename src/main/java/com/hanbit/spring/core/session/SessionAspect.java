package com.hanbit.spring.core.session;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SessionAspect {

	@Around("@annotation(com.hanbit.spring.core.session.SigninRequired)")
	public Object checkSignin(ProceedingJoinPoint pjp) throws Throwable {
		Object returnValue = pjp.proceed();
		
		return returnValue;
	}
	
}

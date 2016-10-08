package com.hanbit.spring.core.session;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.hanbit.spring.core.vo.UserVO;

@Component
@Aspect
public class SessionAspect {

	@Around("@annotation(com.hanbit.spring.core.session.SigninRequired)")
	public Object checkSignin(ProceedingJoinPoint pjp) throws Throwable {
		Map session = SessionHelper.getSession();
		
		if (session.get("loggedIn") == null) {
			MethodSignature signature = (MethodSignature) pjp.getSignature();
			Class returnType = signature.getReturnType();
			
			if (returnType == String.class) {
				return "login";
			}
			else if (returnType == UserVO.class) {
				UserVO userVO = new UserVO();
				
				userVO.setUserEmail("로그인이 필요합니다.");
				
				return userVO;
			}
			
			Map result = new HashMap<>();
			
			result.put("errorMsg", "로그인이 필요합니다.");
			
			return result;
		}
		
		Object returnValue = pjp.proceed();
		
		return returnValue;
	}
	
}

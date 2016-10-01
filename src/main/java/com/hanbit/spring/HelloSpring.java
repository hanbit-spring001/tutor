package com.hanbit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.hanbit.spring.core.service.UserService;
import com.hanbit.spring.core.vo.UserVO;

public class HelloSpring {
	
	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.xml");
			
			ApplicationContext applicationContext
				= new ClassPathXmlApplicationContext(
						"spring/applicationContext-core.xml",
						"spring/applicationContext-dao.xml");
			
			UserService userService 
				= applicationContext.getBean(UserService.class);
			
			UserVO userVO = new UserVO();
			userVO.setUserId(String.valueOf(System.currentTimeMillis()));
			userVO.setUserEmail("hanbit@bbbb.com");
			userVO.setUserPassword("abcd");
			//userVO.setUserTel("01011112222");
			
			userService.signUpUser(userVO);
			
			/*UserVO userVO = userService.getUserDetail("1475313355018");
			
			System.out.println(userVO.getUserEmail());
			System.out.println(userVO.getUserTel());*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

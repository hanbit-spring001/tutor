package com.hanbit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class HelloSpring {
	
	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.xml");
			
			ApplicationContext applicationContext
				= new ClassPathXmlApplicationContext(
						"spring/applicationContext-core.xml");
			
			FirstBean springBean = applicationContext.getBean(FirstBean.class);
			
			springBean.callSecond();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

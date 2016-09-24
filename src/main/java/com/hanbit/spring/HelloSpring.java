package com.hanbit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext
			= new ClassPathXmlApplicationContext(
					"spring/applicationContext-core.xml");
		
		FirstBean springBean = applicationContext.getBean(FirstBean.class);
		
		springBean.callSecond();
	}
	
}

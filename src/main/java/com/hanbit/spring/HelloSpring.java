package com.hanbit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.hanbit.spring.core.service.ExampleService;

public class HelloSpring {
	
	public static void main(String[] args) {
		try {
			Log4jConfigurer.initLogging("classpath:config/log4j.xml");
			
			ApplicationContext applicationContext
				= new ClassPathXmlApplicationContext(
						"spring/applicationContext-core.xml");
			
			ExampleService exampleServie 
				= applicationContext.getBean(ExampleService.class);
			
			exampleServie.addSomething("Spring");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

package com.hanbit.spring;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstBean {
	
	private static final Logger LOGGER
		= LoggerFactory.getLogger(FirstBean.class);

	@Autowired
	private SecondBean secondBean;
	
	public void callSecond() {
		secondBean.printName();
		
		LOGGER.debug("로거테스트");
	}
	
}

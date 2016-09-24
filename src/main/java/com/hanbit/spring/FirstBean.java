package com.hanbit.spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstBean {

	@Autowired
	private SecondBean secondBean;
	
	public void callSecond() {
		secondBean.printName();
	}
	
}

package com.hanbit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstBean {

	private SecondBean secondBean;
	
	@Autowired
	public void setSecondBean(SecondBean secondBean) {
		this.secondBean = secondBean;
	}
	
	public void callSecond() {
		secondBean.printName();
	}
	
}

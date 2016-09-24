package com.hanbit.spring;

import org.springframework.stereotype.Component;

@Component
public class SecondBean {
	
	public void printName() {
		System.out.println(getClass().getName());
	}
	
}

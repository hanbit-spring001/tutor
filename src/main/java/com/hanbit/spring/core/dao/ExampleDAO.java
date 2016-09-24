package com.hanbit.spring.core.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ExampleDAO {

	private static final Logger LOGGER
		= LoggerFactory.getLogger(ExampleDAO.class);
	
	public int insertSomething(String text) {
		
		return 0;
	}
	
}

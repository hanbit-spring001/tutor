package com.hanbit.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		
		return "welcome";
	}

	@RequestMapping("/api/data")
	@ResponseBody
	public Map getData() {
		Map map = new HashMap();
		
		map.put("name", "Hanbit");
		map.put("message", "hello");
		
		return map;
	}
	
}

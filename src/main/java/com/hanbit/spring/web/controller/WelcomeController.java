package com.hanbit.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.spring.core.session.SessionHelper;
import com.hanbit.spring.core.session.SigninRequired;

@Controller
public class WelcomeController {

	@SigninRequired
	@RequestMapping("/")
	public String welcome() {
		
		return "welcome";
	}

	@RequestMapping("/api/data")
	@ResponseBody
	public Map getData() {
		Map map = new HashMap();
		Map session = SessionHelper.getSession();
		
		map.put("name", "Hanbit");
		map.put("message", "hello");
		map.put("email", session.get("userEmail"));
		
		return map;
	}
	
}

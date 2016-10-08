package com.hanbit.spring.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.spring.core.service.UserService;
import com.hanbit.spring.core.vo.UserVO;

@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/list")
	@ResponseBody
	public List<UserVO> listUsers() {
		return userService.listUsers();
	}
	
	@RequestMapping("/user/detail/old")
	@ResponseBody
	public UserVO getUserDetailOld(
			HttpServletRequest request,
			HttpServletResponse response,
			Locale locale) {
		
		LOGGER.debug(locale.getCountry());
		
		String userId = request.getParameter("userId");
		
		return userService.getUserDetail(userId);
	}

	@RequestMapping("/user/detail/new")
	@ResponseBody
	public UserVO getUserDetailNew(
			@RequestParam("userId") String userId) {
		return userService.getUserDetail(userId);
	}
	
	@RequestMapping(value="/user/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public UserVO getUserDetail(
			@PathVariable("userId") String userId) {
		return userService.getUserDetail(userId);
	}
	
	@RequestMapping(value="/user/{userId}", method=RequestMethod.DELETE)
	@ResponseBody
	public Map removeUser(
			@PathVariable("userId") String userId) {
		boolean isRemoved = userService.removeUser(userId);
		
		Map result = new HashMap();
		result.put("removed", isRemoved);
		
		return result;
	}
	
}
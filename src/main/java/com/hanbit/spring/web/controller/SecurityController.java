package com.hanbit.spring.web.controller;

import java.applet.AppletContext;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.spring.core.service.SecurityService;
import com.hanbit.spring.core.service.UserService;
import com.hanbit.spring.core.session.SessionHelper;
import com.hanbit.spring.core.vo.UserVO;

@Controller
public class SecurityController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private SessionHelper sessionHelper;

	@RequestMapping("/security/session/test")
	@ResponseBody
	public Map testSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		//session.setAttribute("name", "Hanbit");
	
		String name = (String) session.getAttribute("name");
		
		Map result = new HashMap();
		result.put("sessionName", name);		
		
		return result;
	}
	
	@RequestMapping("/security/signin")
	@ResponseBody
	public Map signin(@RequestParam("userEmail") String userEmail,
			@RequestParam("userPassword") String userPassword) {
		
		UserVO userVO = userService.getUserDetailByEmail(userEmail);
		
		if (userVO == null) {
			throw new RuntimeException("가입되지 않은 이메일입니다.");
		}
		
		String encryptedPassword = userVO.getUserPassword();
		
		if (!securityService.matchPassword(userPassword, encryptedPassword)) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		
		Map session = SessionHelper.getSession();
		session.put("loggedIn", true);
		session.put("userEmail", userVO.getUserEmail());

		Map result = new HashMap();
		result.put("msg", "환영합니다.");
		
		return result;
	}
	
	@RequestMapping("/security/signout")
	public void signout(HttpServletResponse response) throws Exception {
		SessionHelper.getSession().clear();
		
		response.sendRedirect("/api/data");
	}
	
}

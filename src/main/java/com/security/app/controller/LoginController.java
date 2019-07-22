package com.security.app.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
	@GetMapping("/login")
	public String loginForm(HttpServletRequest req) {
		String referer = req.getHeader("Referer");
		req.getSession().setAttribute("prevPage", referer);
		return "login";
	}
	@GetMapping("/success")
	public String success(HttpSession session) {
//String sessionid=session.getId();

		Enumeration<String> str =session.getAttributeNames();
		//session.getValue("testsession1")'
		System.out.println("유저이름:"+session.getAttribute("username"));
		
		for(String s :session.getValueNames()) {
			System.out.println(s);
		}
		
		while(str.hasMoreElements()) {
			System.out.println(str.nextElement());
	//		session.getAttribute(str.);
		}
		
		System.out.println();
		
		return "success";
	}
}
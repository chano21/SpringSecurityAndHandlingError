package com.security.app.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.security.app.repositorys.MemberRepository;
import com.security.app.tables.Member;
import com.security.app.tables.MemberRole;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	MemberRepository memberRepository;
	
	
	@GetMapping("")
	public String getuserrole(Member member,HttpServletRequest request) {
	System.out.println(request.isUserInRole("ADMIN"));
	
		
		return "admin";
	}

}
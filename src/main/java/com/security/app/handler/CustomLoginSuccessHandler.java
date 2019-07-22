package com.security.app.handler;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.security.app.config.SecurityMember;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	public CustomLoginSuccessHandler(String defaultTargetUrl) {
        setDefaultTargetUrl(defaultTargetUrl);
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
    	Authentication authentication) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("아이디 : "+ ((SecurityMember) authentication.getPrincipal()).getUsername());
       //((SecurityMember)authentication.getPrincipal()).setSessiondata("setsessiontest");
        session.setAttribute("username", ((SecurityMember) authentication.getPrincipal()).getUsername());
        
       
        if (session != null) {
        	
        Enumeration<String> e=	session.getAttributeNames();
            while(e.hasMoreElements()) {
            	System.out.println(e.nextElement());
            }
        	
            String redirectUrl = (String) session.getAttribute("prevPage");
            if (redirectUrl != null) {
                session.removeAttribute("prevPage");
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
            } else {
            	System.out.println("1실행");
                super.onAuthenticationSuccess(request, response, authentication);
            }
        } else {

        	System.out.println("2실행");
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
package com.green.nowon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	//로그인페이지
	@GetMapping("/login")
	public void login(HttpServletRequest request) {
		String target=request.getHeader("referer");
		System.out.println("CommonController-referer :" +target);
		//주소에 login 이나 signup 이 들어오면 session에 저장하지않음 		
		if(!target.contains("/login")&&!target.contains("/signup")) {
			HttpSession session= request.getSession();
			session.setAttribute("prevPage", target);
			System.out.println("세션에저장됨");
		}
	}	
	//회원가입페이지
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("data", "sign");
		return "/signup";
	}
	
	//구독하기 화면 연결
	@GetMapping("/sub")
	public String sub() {
		return "sub";
	}
	
	
}

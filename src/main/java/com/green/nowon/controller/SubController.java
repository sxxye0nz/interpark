package com.green.nowon.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.service.SubService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SubController {
	
	private final SubService service;
	
	@PostMapping("/sub")
	public String sub(Authentication auth) {
		service.sub(auth); //로그인 아이디 또는 이메일
		return "redirect:/";
	}
}

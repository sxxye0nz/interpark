package com.green.nowon.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.dto.MemberDTO;
import com.green.nowon.dto.MemberSaveDTO;
import com.green.nowon.service.SignupService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SignupController {

	private final SignupService service;
	
	//패스워드암호화를 위한 PasswordEncoder 
	private final PasswordEncoder encoder;
	
	@PostMapping("/signup")
	public String signup(MemberSaveDTO dto) {
		System.out.println(">>>>> dto.getPass : " + dto.getPass());
		//입력된 패스워드를 가져와서(dto.getPass()) encoder 로 암호화 해준다음 passEncode로 넘김
		service.saveProcess(dto.passEncode(encoder.encode(dto.getPass())));
		return "redirect:/login";
		
		
	}	
}

package com.green.nowon.controller;

import java.util.ArrayList;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.green.nowon.dto.MymemoDTO;
import com.green.nowon.service.MyMemoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyMemoController {

	private final MyMemoService service;
	
	// 마이페이지 메모 글쓰기 연결
	@GetMapping("/mymemo")
	public String mymemo() {
		return "/memo/mymemo";
	}
	
	
	// 마이페이지 메모 저장
	@PostMapping("/mymemo")
	public String saveMemo(MymemoDTO dto, Model model, Authentication authentication) {
		//인증정보에서 email 불러와서 dto 의 email 에 저장하기
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		dto.setEmail(userDetails.getUsername());
		System.out.println("dto email 전달 ! : >>>>"+dto.getEmail());
		service.saveMemo(dto);
		
		//List 에 데이터저장
		ArrayList<MymemoDTO> memoList = service.list();
		model.addAttribute("list", memoList);
		
		return "/memo/mymemo-list";
	}
	
	// 마이페이지 메모 리스트연결
	@GetMapping("/mymemo-list")
	public String memolist(Model model) {
		ArrayList<MymemoDTO> memoList = service.list();
		model.addAttribute("list", memoList);
		
		return "/memo/mymemo-list";
	}
	
	// 마이페이지 메모 조회
	@GetMapping("/mymemo/{no}")
	public String detail(@PathVariable(name = "no") long mno, Model model) {
		service.detail(mno,model);
		return "/memo/mymemo-detail";
	}
	
	// 메모업데이트
	@PutMapping("/mymemo/{no}")
	public String update(@PathVariable(name = "no") long mno, MymemoDTO dto) {
		return service.updateProcess(mno, dto);
	}
	
	//메모 삭제
	@DeleteMapping("/mymemo/{no}")
	public String delete(@PathVariable(name = "no") long mno) {
		return service.deleteProcess(mno);
	}
	
}


























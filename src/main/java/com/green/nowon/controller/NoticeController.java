package com.green.nowon.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.nowon.dto.NoticeDTO;
import com.green.nowon.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController {

	private final NoticeService service;
	
	
	//게시글 등록 페이지 이동
	@GetMapping("/notice-write")
	public String noticeWrite() {
		return "/notices/notice-write";
	}
	
	//게시판 등록
	@PostMapping("/notice-save")
	public String noticeWriteAdd(Model model, NoticeDTO dto, Authentication authentication) {
		
		//현재 로그인 되어있는 이메일 정보 불러오기
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		dto.setEmail(userDetails.getUsername());
				
		service.noticeSave(dto);
		List<NoticeDTO> noticeList = service.list();
		model.addAttribute("list", noticeList);
		return "redirect:/notice";
	}	

	//게시판 등록 페이지 출력
	@GetMapping("/notice")
	public String noticeList(Model model) {
		
		List<NoticeDTO> noticeList = service.list();
		model.addAttribute("list", noticeList);
		return "/notices/notice";
	}
	
	//게시글 번호 -> 게시글 상세 조회
	@GetMapping("/notice/{no}")
	public String noticeDetail(@PathVariable(name = "no") int no, Model model) {
		service.noticeDetail(no, model);
		return "/notices/notice-detail";
	}
	
	//삭제하기위한 요청메서드 일때 @DeleteMapping 사용가능합니다.
	@DeleteMapping("/notice/{no}")
	public String delete(@PathVariable("no") long no) {
		service.delete(no);
		return "redirect:/notice";	
	}
	
	//수정작업하기위한 매핑메서드
	@PutMapping("/notice/{no}")
	public String update(@PathVariable long no, NoticeDTO dto) {
		service.update(dto);
		return "redirect:/notice/"+no;
	}


}

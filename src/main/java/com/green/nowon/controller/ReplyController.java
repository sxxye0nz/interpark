package com.green.nowon.controller;

import java.util.ArrayList;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.dto.ProductsDTO;
import com.green.nowon.dto.ReplyDTO;
import com.green.nowon.service.ProductsService;
import com.green.nowon.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ReplyController {
	
	private final ReplyService service;
	
	private final ProductsService proService;
	
	//상품 게시글의 댓글 입력
	@PostMapping("/reply/write")
	public String reWrite(Model model, ReplyDTO dto, Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		userDetails.getUsername();
		dto.setEmail(userDetails.getUsername());
		service.replySave(dto);
		
		ArrayList<ProductsDTO> productsList = proService.list();
		model.addAttribute("list", productsList);
		
		return "/products/products-list";
	}
	
}

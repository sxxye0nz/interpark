package com.green.nowon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.dto.ProductsDTO;
import com.green.nowon.dto.ReplyDTO;
import com.green.nowon.mapper.ProductsMapper;
import com.green.nowon.mapper.ReplyMapper;
import com.green.nowon.service.ProductsService;
import com.green.nowon.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReplyServiceProcess implements ReplyService{
	
	private final ReplyMapper mapper;

	
	@Override
	public void replySave(ReplyDTO dto) {
		mapper.replySave(dto);
	}


	@Override
	public ArrayList<ReplyDTO> findByPcodeList(int pcode, Model model) {
		ArrayList<ReplyDTO> replyList = mapper.replyList(pcode);
		model.addAttribute("replyList", replyList);
		return replyList;
	}
	
	

}

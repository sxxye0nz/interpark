package com.green.nowon.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.dto.NoticeDTO;
import com.green.nowon.mapper.NoticeMapper;
import com.green.nowon.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceProcess implements NoticeService {

	private final NoticeMapper mapper;
	

	//게시글 저장
	@Override
	public void noticeSave(NoticeDTO dto) {
		// TODO Auto-generated method stub
		mapper.save(dto); 
	}

	//게시글 리스트
	@Override
	public List<NoticeDTO> list() {
		List<NoticeDTO> noticeList = mapper.list();
		return noticeList;
	}


	//게시글 상세 조회
	@Override
	public void noticeDetail(int no, Model model) {
		NoticeDTO result = mapper.findByNo(no);
		model.addAttribute("detail", result);
	}

	//게시글 삭제
	@Override
	public void delete(long no) {
		// TODO Auto-generated method stub
		 mapper.deleteByNo(no);
	}
	
	//게시글 수정
	@Override
	public void update(NoticeDTO dto) {
		// TODO Auto-generated method stub
		mapper.updateByNo(dto);
	}


}

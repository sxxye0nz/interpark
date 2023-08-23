package com.green.nowon.service;

import java.util.List;

import org.springframework.ui.Model;

import com.green.nowon.dto.NoticeDTO;


public interface NoticeService {

	//게시글 등록
	void noticeSave(NoticeDTO dto);

	//게시글 리스트 조회
	public List<NoticeDTO> list();

	//게시글 상세 페이지 조회
	void noticeDetail(int no, Model model);

	//게시글 삭제
	void delete(long no);

	//게시글 수정
	void update(NoticeDTO dto);


}

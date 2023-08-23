package com.green.nowon.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.green.nowon.dto.MymemoDTO;

public interface MyMemoService {
	
	//메모 등록
	String saveMemo(MymemoDTO dto);

	//메모 리스트 조회
	ArrayList<MymemoDTO> list();

	// 메모 상세페이지 
	void detail(long mno, Model model);

	//메모업데이트
	String updateProcess(long mno, MymemoDTO dto);

	//메모 삭제
	String deleteProcess(long mno);

	

}

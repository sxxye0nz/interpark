package com.green.nowon.service.impl;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.dto.MymemoDTO;
import com.green.nowon.mapper.MyMemoMapper;
import com.green.nowon.service.MyMemoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MyMemoServiceProcess implements MyMemoService{

	private final MyMemoMapper mapper;
	
	@Override
	public String saveMemo(MymemoDTO dto) {
		mapper.save(dto);
		return "redirect:/mymemo";
	}

	@Override
	public ArrayList<MymemoDTO> list() {
		ArrayList<MymemoDTO> mymemoList = mapper.list();
		return mymemoList;
	}

	@Override
	public void detail(long mno, Model model) {
		MymemoDTO result = mapper.findByMno(mno);
		model.addAttribute("detail", result);
	}

	@Override
	public String updateProcess(long mno, MymemoDTO dto) throws NoSuchElementException{
		
		
		MymemoDTO dt =mapper.findByMno(mno);
		if(dt ==null) throw new NoSuchElementException("이미삭제된 데이터입니다.");
		
		mapper.updateByMno(dto.mno(mno));
		return "redirect:/mymemo/" +mno;
	}
	
	@Override
	public String deleteProcess(long mno) {
		mapper.deleteByMno(mno);
		return "redirect:/mymemo-list/";
	}

	
}

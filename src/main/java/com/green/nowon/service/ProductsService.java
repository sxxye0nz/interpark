package com.green.nowon.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.green.nowon.dto.ProductsDTO;
import com.green.nowon.dto.ReplyDTO;

public interface ProductsService {

	//상품 등록
	void productsSave(ProductsDTO dto);

	//상품 리스트 조회
	public ArrayList<ProductsDTO> list();

	//상품 상세 조회
	void detail(int pcode, Model model);

}

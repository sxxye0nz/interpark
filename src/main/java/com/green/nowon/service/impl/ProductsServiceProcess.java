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

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductsServiceProcess implements ProductsService{
	
	private final ProductsMapper mapper;
	

	@Override
	public void productsSave(ProductsDTO dto) {
		mapper.save(dto);
	}

	@Override
	public ArrayList<ProductsDTO> list() {
		ArrayList<ProductsDTO> productsList = mapper.list();
		return productsList;
	}

	@Override
	public void detail(int pcode, Model model) {
		ProductsDTO result = mapper.findByPcode(pcode);
		model.addAttribute("detail", result);
	}

	

}

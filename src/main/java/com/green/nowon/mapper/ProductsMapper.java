package com.green.nowon.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.dto.ProductsDTO;
import com.green.nowon.dto.ReplyDTO;

@Mapper
public interface ProductsMapper {

	//상품 등록
	void save(ProductsDTO dto);
	
	//상품 리스트
	ArrayList<ProductsDTO> list();
	
	//상품 상세 조회
	ProductsDTO findByPcode(int pcode);

}

package com.green.nowon.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.dto.MemberDTO;

@Mapper
public interface LoginMapper {

	Optional<MemberDTO> findById(String email);
	//DTO에 저장
	void save(MemberDTO dto);

	
}

package com.green.nowon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {
	
	//게시글 등록
	void save(NoticeDTO dto);

	//게시글 리스트
	List<NoticeDTO> list();

	//게시글 상세조회
	NoticeDTO findByNo(int no);

	//게시글 삭제
	void deleteByNo(long no);

	//게시글 수정
	void updateByNo(NoticeDTO dto);

	
}

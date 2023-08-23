package com.green.nowon.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.dto.ReplyDTO;

@Mapper
public interface ReplyMapper {
	//댓글 등록
	void replySave(ReplyDTO dto);

	//상품 번호에 맞는 댓글 리스트
	ArrayList<ReplyDTO> replyList(int pcode);
}

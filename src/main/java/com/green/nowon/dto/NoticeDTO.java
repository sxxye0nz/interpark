package com.green.nowon.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class NoticeDTO {

	private long no;
	private String title;	
	private String content;
	private LocalDateTime createdDate;	
	private LocalDateTime updatedDate;
	
	//green_member 테이블 외래키값
	private String email;
}

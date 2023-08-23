package com.green.nowon.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class MymemoDTO {

	private long mno;
	private String title;
	private String content;
	private String email;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
	public MymemoDTO mno(long mno) {
		this.mno=mno;
		return this;
	}
	
}

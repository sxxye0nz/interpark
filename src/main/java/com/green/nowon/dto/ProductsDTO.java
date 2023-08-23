package com.green.nowon.dto;

import java.time.LocalDateTime;
import java.util.List;

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
@Getter
@Setter
public class ProductsDTO {
	private String pcode;
	private String pname;
	private String pcontent;
	private int price;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
	//green_member 테이블 외래키값
	private String email;

}

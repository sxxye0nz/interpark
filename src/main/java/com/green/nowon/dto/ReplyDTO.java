package com.green.nowon.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyDTO {
	private int pcode;
	private String email;
	private String reply;
	private LocalDateTime createdDate;
}

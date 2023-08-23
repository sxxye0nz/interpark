package com.green.nowon.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;

import com.green.nowon.security.MyRole;

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
public class MemberDTO {
	
	private long no;
	private String email;
	private String pass;
	private String nickName;
	
	private Set<MyRole> roles;
	


	
}

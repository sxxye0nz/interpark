package com.green.nowon.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class MemberSaveDTO {
	
	private long no;
	private String email;
	private String pass;

	private long greenMemberEntityNo;
	private String roles;


	
	public MemberSaveDTO passEncode(String encodedPass) {
		//암호화된 encodedPass 를 SaveDTO에 있는 pass에 다시 저장
		pass=encodedPass;
		System.out.println(pass);
		return this;
	}
	
	public RoleDTO toRoleDTO() {
		return RoleDTO.builder()
				.greenMemberEntityNo(greenMemberEntityNo)
				.roles(roles)
				.build();
		
	}
	public MemberDTO toMemberDTO() {
		return MemberDTO.builder()
				.email(email).pass(pass)
				.build()
				;		
	}
}

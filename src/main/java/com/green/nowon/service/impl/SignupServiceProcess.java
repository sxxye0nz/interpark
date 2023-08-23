package com.green.nowon.service.impl;

import org.springframework.stereotype.Service;

import com.green.nowon.dto.MemberDTO;
import com.green.nowon.dto.MemberSaveDTO;
import com.green.nowon.dto.MyRoleSaveDTO;
import com.green.nowon.mapper.LoginMapper;
import com.green.nowon.mapper.MyRoleMapper;
import com.green.nowon.security.MyRole;
import com.green.nowon.service.SignupService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SignupServiceProcess implements SignupService {
	
	//회원가입시 값을 저장하기위한 mapper
	private final LoginMapper mapper;
	//회원가입시 Role부여를 위한 mapper
	private final MyRoleMapper orleMapper;
	
	@Override
	public void saveProcess(MemberSaveDTO dto) {
		
		MemberDTO entity = dto.toMemberDTO();
		System.out.println("저장전 no=0:"+entity);
		//login-mapper.xml 에서 no값이 생성됨
		mapper.save(entity);
		System.out.println("저장전 no=?:"+entity);
		
		//entity에서 role,no
		MyRoleSaveDTO roleDto=MyRoleSaveDTO.builder()
				.mno(entity.getNo()) //entity에서 no값(회원가입시 부여된 no값) 가져와서 넣기
				.role(MyRole.USER) //MyRole USER값 삽입
				.build();
		orleMapper.save(roleDto); //각각 삽입한 값을 save로 넘겨서 저장

	}
	

}

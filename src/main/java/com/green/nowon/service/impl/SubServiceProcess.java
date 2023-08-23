package com.green.nowon.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.green.nowon.dto.MemberDTO;
import com.green.nowon.dto.MyRoleSaveDTO;
import com.green.nowon.mapper.LoginMapper;
import com.green.nowon.mapper.MyRoleMapper;
import com.green.nowon.security.MyRole;
import com.green.nowon.service.SubService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubServiceProcess implements SubService{

	//VIP Role 추가를 위한 Mapper
	private final MyRoleMapper orleMapper;
	//loginMapper 에서 findById를 불러오기위해 선언
	private final LoginMapper loginMapper;
	
	@Override
	public void sub(Authentication auth) {
		//구독하기 누르면 VIP롤 적용
		//필요한 값 : role,no
		
		//findById 인증정보에서 현재 로그인된 name과 같은 정보들(no,pass 등등) 가져와서 result 에 넣기
		//email 정보만으로 no(pk)값 찾기 -- email 유니크하기때문에 가능
		MemberDTO result=loginMapper.findById(auth.getName()).orElseThrow();
		
		orleMapper.save(MyRoleSaveDTO.builder()
				.mno(result.getNo()) //result 에서 no(pk)값 가져오기
				.role(MyRole.VIP)
				.build());
		
		//인증정보 갱신처리 : 기존 로그인 되어있는 정보에서 VIP 권한 추가된 상황이기때문에 인증정보를 갱신해주어야함
		//갱신처리 해주지않으면 로그아웃 후 다시 로그인해야 권한갱신
		//auth.getAuthorities()
		//getAuthorities는 값을 직접변경할 수는 없고 hashset이나 list로 복사해서 사용해야함
		Set<GrantedAuthority> authorities=new HashSet<>(auth.getAuthorities());
		// MyRole에 VIP의 Name을 가져와서추가(=ROLE_VIP)
		authorities.add(new SimpleGrantedAuthority(MyRole.VIP.getRoleName()));
		//새로운 인증정보에 기존에있던 Principal() , 기존 Credentials() 넣고 새로운 인증정보 authorities 넣어주기
		Authentication newAuth =new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), authorities);
		//마지막으로 SecurityContextHolder에 저장
		SecurityContextHolder.getContext().setAuthentication(newAuth);
		System.out.println(">>>>vip 롤반영된 상황!");
	
	}

	
	
}

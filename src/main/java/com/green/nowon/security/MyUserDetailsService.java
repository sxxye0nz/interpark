package com.green.nowon.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.green.nowon.dto.MemberDTO;
import com.green.nowon.mapper.LoginMapper;

//로직변경은 Service 탭에서 변경
@Component
public class MyUserDetailsService implements UserDetailsService {

	//DAO 
	@Autowired
	private LoginMapper mapper;
	
	//could not initialize proxy - no Session
	//failed to lazily initialize a collection of 객체명
	//메세지 출력될 경우 쿼리를 한단위로 묶어주어야함  @Transactional --메서드가 끝날때까지 유지
	//@Transactional //즉시 로딩할때에는 role도 한번에 가져옴
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.out.println("로그인 페이지에서입력한 email" + email);
		//DB에 존재하는지 확인 
		//존재하지 않으면 UsernameNotFoundException 예외 발생
		MemberDTO result= mapper.findById(email).orElseThrow(()->new UsernameNotFoundException("존재하지않습니다"));
		System.out.println("회원이면 MemberEntity가 저장 됩니다.");
		System.out.println(result);
		//Set<MyRole> --> Set<SimpleGrantedAuthority>
		Set<SimpleGrantedAuthority> grantedAuthority=result.getRoles().stream()
															.map(myRole->new SimpleGrantedAuthority("ROLE_"+myRole))
															.collect(Collectors.toSet())
		;
		System.out.println("my_role테이블을 읽어옴");
		
		//User 에서 username 을 임의로 email 로 설정해놓았음 
		
		return new User(result.getEmail(), result.getPass(), grantedAuthority);
			
		
	}
	//SecurityContextHolder aa;
	//SecurityContext dd;
	//Authentication ee;
	
	
	
}


















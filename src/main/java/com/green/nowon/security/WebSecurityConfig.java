package com.green.nowon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class WebSecurityConfig {
	//spring-boot 1.5->2.x->3.x 버전에 따라 설정이 조금씩 변경되고있음
	//2023/05/22 기준 spring-boot 2.7.12 , springsecurity5 버전 적용 예 
	
	//AuthenticationManager ma;
	//DaoAuthenticationProvider provider;
	//로그인페이지에서 입력한 username(email 또는 id에 해당하는 정보)
	//를 이용해서 DB에 존재하는지 확인하고 존재하면 UserDetails 타입으로 정보를 리턴하면됨

	//1. url-->request HttpSecurity
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		//https://docs.spring.io/spring-security/reference/5.8/servlet/exploits/csrf.html
			//.csrf(csrf->csrf.disable()) //설정이 없으면 post요청시 csrf토큰 적용하여야함.
		
			//authorizeRequests ->5.5 authorizeHttpRequests 변경
			.authorizeHttpRequests(authorize->
				authorize
					.antMatchers("/css/**","/js/*","/images/**").permitAll()
					.antMatchers("/","/signin","/signup","/login", "/notice", "/notice-write", "/notice-detail","/mymemo").permitAll()//Specify that URLs are allowed by anyone.
					.antMatchers(HttpMethod.GET,"/board").permitAll()
					.antMatchers("/reply/*").hasAnyRole("USER", "ADMIN")
					.antMatchers("/boards/*").hasAnyRole("USER","ADMIN")
					.antMatchers("/admin/*").hasRole("ADMIN")
					//Can't configure antMatchers after anyRequest
					.anyRequest()//설정한 나머지 url 
						.authenticated()//인증user이어야합니다.-->user권한이 필요합니다.
				)
			.formLogin(login->//{}
				//*
				login
					.loginPage("/login") //로그인 페이지 이동
					.loginProcessingUrl("/login") //form action과 일치하게 설정 post
					.usernameParameter("email") //Defaults "username".
					.passwordParameter("pass") //Defaults "password".
					//.defaultSuccessUrl("/",true)
					.successHandler(mySuccessHandler())
					.permitAll())
			
			.logout(logout->logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/")
					.deleteCookies("JSESSIONID"))
				//*/
			
			;
			
		return http.build();
	}
	
	@Bean
	AuthenticationSuccessHandler mySuccessHandler() {
		return new MySuccessHandler();
	}

}

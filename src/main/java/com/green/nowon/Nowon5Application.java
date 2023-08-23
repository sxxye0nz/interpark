package com.green.nowon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.nowon.security.MyRole;

@SpringBootApplication
public class Nowon5Application {

	public static void main(String[] args) {
		SpringApplication.run(Nowon5Application.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(14);
	}
	
	

}

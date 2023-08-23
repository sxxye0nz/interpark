package com.green.nowon.service;

import org.springframework.security.core.Authentication;

public interface SubService {

	//void sub(String name);

	void sub(Authentication auth);

}

package com.green.nowon.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class MySuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String targetUrl=getDefaultTargetUrl();//현재 defalut가 "/" 임
		//인증이 필요한 url요청시 인증되지 않는 사용자는 로그인페이지로 리디렉션
		//인증이 정상적으로 완료되면 원래 이동하고자 하는 url 로 이동
		SavedRequest savedRequest = this.requestCache.getRequest(request, response);
		System.out.println("saveRequest :" + savedRequest);
		clearAuthenticationAttributes(request);
		if(savedRequest != null) {
			String redirectUrl=savedRequest.getRedirectUrl();
			if(!redirectUrl.contains("/login")) {
				targetUrl=redirectUrl;
				getRedirectStrategy().sendRedirect(request, response, targetUrl);
				return;
			}
		}
		
		
		//security 리디렉션하지않고 로그인을 직접클했을때 savedRequest 가 null이므로 
		//나머지 유형 처리를 위해 HttpSession을 이용해서 처리함.
		// Controller에서 로그인 페이지 이동하는 매핑메서드에서 session을 저장하여야함.
		
		HttpSession session= request.getSession();
		String prevPage=(String) session.getAttribute("prevPage");
		System.out.println("prevPage:"+prevPage);
		if(prevPage !=null){
			targetUrl=prevPage;
			session.removeAttribute("prevPage");
		}
		
		//System.out.println("targetUrl: "+targetUrl);
		this.requestCache.removeRequest(request, response);
		//redirectStrategy.sendRedirect(request, response, targetUrl);
		
		getRedirectStrategy().sendRedirect(request, response, targetUrl);
		
	}

	

}

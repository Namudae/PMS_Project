package com.team.pms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//System.out.println("필터 생성");
		
		this.encoding = filterConfig.getInitParameter("encoding");
		
		if (this.encoding == null || this.encoding.equals("")) {
			this.encoding = "UTF-8";
		}
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("필터 동작");
		
		//인코딩 처리
		request.setCharacterEncoding(this.encoding);
		
		//그 다음 필터를 호출 or 서블릿 호출
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		//System.out.println("필터 소멸");
	}
	
	
	
}

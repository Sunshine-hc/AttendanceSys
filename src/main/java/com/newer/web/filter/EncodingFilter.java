package com.newer.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{
	
	private String encoder;//字符集名称

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		//获取它的请求路径
		String requestURI = request.getRequestURI();
		//当检测到是以css后缀名结尾的时，直接放行
		if(requestURI.contains(".css") || requestURI.contains(".js")) {
			arg2.doFilter(arg0, arg1);
		}else {
			// 对请求和响应进行字符集转码操作
			arg0.setCharacterEncoding(encoder);
			arg1.setContentType("text/html;charset="+encoder);
			//System.out.println(encoder+"转码完成");
			arg2.doFilter(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoder=filterConfig.getInitParameter("encoder");
	}
	
	

}

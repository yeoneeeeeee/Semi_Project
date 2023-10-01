package com.semi.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class PasswordEncrytpFilter
 */
@WebFilter(servletNames = {
		"loginServlet",
		"memberInsertServlet",
		"updatePwdServlet",
		"deleteServlet"
})
// 로그인
// 회원정보 변경시
// 회원가입
public class PasswordEncrytpFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PasswordEncrytpFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PasswordEncryptWrapper pew = new PasswordEncryptWrapper((HttpServletRequest)request);
		
		chain.doFilter(pew, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

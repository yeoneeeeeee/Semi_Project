package com.semi.common;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordEncryptWrapper extends HttpServletRequestWrapper{
	
	public PasswordEncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	// getParameter 오버라이딩
	// 매개변수로 넘어온 password값 찾아서 암호화 하기
	@Override
	public String getParameter(String name) {
		
		if(name.equals("userPwd") || name.equals("checkPwd")) {
			
			// 암호화
			String userPwd = super.getParameter(name);
			String checkPwd = super.getParameter(name);
			
			if(!userPwd.equals(checkPwd)) {
				throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
			}
			
			String ep = getSHA512(userPwd);
			return ep;
		}
		return super.getParameter(name);
	}
	
	private String getSHA512(String val) {
		String encPwd = "";
		
		// 암호화 처리 객체 선언
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 암호화 시 bit단위로 연산하고, bit연산한 결과를 byte[]로 담아서 보관
		byte[] bytes = val.getBytes(Charset.forName("UTF-8"));
		md.update(bytes);
		
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		
		return encPwd;
	}
	

}

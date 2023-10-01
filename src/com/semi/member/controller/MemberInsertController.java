package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class InsertMemberController
 */
@WebServlet(urlPatterns = "/insert.me", name="memberInsertServlet")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String checkPwd = request.getParameter("checkPwd");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		
		address += (" " + detailAddress); 
		
		Member m = new Member(userId, userPwd, userName, phone, email, address);
		
		if(userId.length() > 3) {
			
			int result = new MemberService().insertMember(m);
			
			if(result > 0) {
				
				// 메인페이지로 이동
				request.getRequestDispatcher("views/7H_The_Town/login/MembershipSignUp4.jsp").forward(request, response);
				
			} else {
}
		}
			
	
		
	}
	
	
	
	
	
	
	
	

}

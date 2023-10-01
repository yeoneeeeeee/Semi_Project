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
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {			
			request.getRequestDispatcher("/views/7H_The_Town/mypage/MyPageAccount.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요.");
			response.sendRedirect(request.getContextPath()+"/main");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		String userId = loginUser.getUserId();
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		
		address += (" " + detailAddress); 
		
		Member m = new Member(userId, userName, phone, email, address);
		
		Member updateMember = new MemberService().updateMember(m);
		
		if(updateMember == null) {
			
			request.getSession().setAttribute("alertMsg", "회원정보 수정에 실패하였습니다.");
			response.sendRedirect(request.getContextPath() + "/update.me");
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "회원정보 수정에 성공하였습니다. 다시 로그인해주세요.");
			response.sendRedirect(request.getContextPath() + "/logout.me");
			
		}
				
		
		
	}

}

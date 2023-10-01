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
 * Servlet implementation class MemberDeleteController
 */
@WebServlet(urlPatterns = "/delete.me", name = "deleteServlet")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {			
			request.getRequestDispatcher("/views/7H_The_Town/mypage/MyPageSecession.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요.");
			response.sendRedirect(request.getContextPath()+"/main");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checkId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String checkPwd = request.getParameter("checkPwd");
		
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		
		String userId = loginUser.getUserId();
		
		if(userPwd.equals(checkPwd)) {
			
			int result = new MemberService().deleteMember(userId, userPwd);
			
			if(result > 0) {
				
				request.getSession().invalidate();
				
				request.getSession().setAttribute("alertMsg", "성공적으로 회원 탈퇴되었습니다. 이용해주셔서 감사합니다.");
				response.sendRedirect(request.getContextPath()+"/main");
				
			} else {
				
				request.getSession().setAttribute("alertMsg", "회원 탈퇴에 실패하였습니다.");
				response.sendRedirect(request.getContextPath() + "/delete.me");
				
			}
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "비밀번호가 일치하지 않습니다.");
			response.sendRedirect(request.getContextPath() + "/delete.me");
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

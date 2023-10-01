package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Board;
import com.semi.board.model.vo.FAQ;
import com.semi.donation.model.service.DonationService;
import com.semi.donation.model.vo.Donation;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Grade;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = "/login.me", name="loginServlet")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/7H_The_Town/login/MembershipLogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member loginUser = new MemberService().loginMember(userId, userPwd); 
		Grade userGrade = new MemberService().loginMember(userId);
		Donation userDona = new DonationService().selectDonation(userId);
		Donation countDona = new DonationService().memberDonation(userId);
		Board userBoard = new BoardService().selectBoard(userId);
		Board countBoard = new BoardService().memberBoard(userId);
		FAQ countFaqBoard = new BoardService().selectCountFaqBoard(userId);
		
		if(loginUser == null) {
			
			response.sendRedirect(request.getContextPath());
			request.getSession().setAttribute("alertMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			
		} else {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("userGrade", userGrade);
			session.setAttribute("userDona", userDona);
			session.setAttribute("countDona", countDona);
			session.setAttribute("userBoard", userBoard);
			session.setAttribute("countBoard", countBoard);
			session.setAttribute("countFaqBoard", countFaqBoard);
			
			session.setAttribute("alertMsg", loginUser.getUserName() + "님 반갑습니다.");
			
			response.sendRedirect(request.getContextPath());
		}
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
}

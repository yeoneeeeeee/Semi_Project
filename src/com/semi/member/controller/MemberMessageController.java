package com.semi.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.model.vo.PageInfo;
import com.semi.member.model.vo.Member;
import com.semi.postAll.model.service.PostAllService;
import com.semi.postAll.model.vo.PostAll;

/**
 * Servlet implementation class MemberMessageController
 */
@WebServlet("/message.me")
public class MemberMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMessageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {
			
			int listCount; 
			int currentPage; 
			int pageLimit; 
			int boardLimit;
			int maxPage;
			int startPage; 
			int endPage; 
			
		
			listCount = new PostAllService().PselectListCount();
			
			
			currentPage = Integer.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));
			
			
			pageLimit = 5;
			
			
			boardLimit = 6;
			
			maxPage = (int)Math.ceil((double)listCount/ boardLimit);
			 startPage = (currentPage -1 )/pageLimit * pageLimit +1 ; 
			
			
			endPage = startPage + pageLimit -1;
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			PageInfo pi = new PageInfo(listCount, currentPage, pageLimit,boardLimit, maxPage, startPage,endPage);
			
			request.setAttribute("pi", pi);
			
			String callerNo =  ((Member)(request.getSession().getAttribute("loginUser"))).getUserNo();
			//인풋타입 히든을 거기에 두고 거기에 섹션객체에서 받아온 유저의 no값을 넣어두고 reveiverNo에 값을 넣어둠
			//receiver에 세션객체에서 나의 회원정보를 집어넣고 이걸 보낸다 보낸걸 
			
			ArrayList<PostAll> list = new PostAllService().PostRSelect(pi, callerNo);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/7H_The_Town/mypage/MyPageMessage.jsp").forward(request, response);	
			
		} else {
			request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요.");
			response.sendRedirect(request.getContextPath()+"/main");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

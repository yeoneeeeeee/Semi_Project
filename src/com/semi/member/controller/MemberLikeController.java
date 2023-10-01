package com.semi.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.GetThePetService;
import com.semi.board.model.vo.Favorite;
import com.semi.common.model.vo.PageInfo;
import com.semi.member.model.vo.Member;
import com.semi.pet.model.vo.Pet;

/**
 * Servlet implementation class MemberLikeController
 */
@WebServlet("/like.me")
public class MemberLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {
			
			
			int listCount; // 현재 총 게시글 갯수(1000개)
			int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지)
			int pageLimit; // 페이지 하단에 보여질 최대 페이지 갯수(10개씩 예정)
			int boardLimit; // 한 페이지에 보여질 게시글의 최대 갯수(10개씩 예정)
			int maxPage; // 가장 마지막 페이지가 몇 번째 페이지인지(총 페이지 갯수)
			int startPage; // 페이지 하단에 보여질 페이징바의 시작수
			int endPage; // 페이지 하단에 보여질 페이징바의 마지막수
			
			listCount = new GetThePetService().selectListCountFavorite(loginUser.getUserNo());
			
			currentPage = Integer.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));
			
			pageLimit = 5;
			
			boardLimit = 6;
			
			maxPage = (int)Math.ceil((double)listCount/boardLimit);
			
			startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
			
			endPage = startPage + pageLimit - 1;
			
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
			
			request.setAttribute("pi", pi);
			
			ArrayList<Pet> pList = new GetThePetService().selectFavoritePet(loginUser.getUserNo(), pi);
			ArrayList<String> gList = new GetThePetService().selectFavoriteGet(loginUser.getUserNo(), pi);
			
			request.setAttribute("pList", pList);
			request.setAttribute("gList", gList);
			
			request.getRequestDispatcher("/views/7H_The_Town/mypage/MyPageLike.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요.");
			response.sendRedirect(request.getContextPath()+"/main");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		
		if(loginUser != null) {
			
			int result = 1;
			String del = request.getParameter("getNo");
			
			if(del != null && del != "") {
				String[] delArray = del.split(",");
				
				for(int i = 0; i < delArray.length; i++) {
					Favorite f = new Favorite(loginUser.getUserNo(), delArray[i]);
					result *= new GetThePetService().deleteFavorite(f);
				}
				
				request.getSession().setAttribute("alertMsg", "성공적으로 삭제되었습니다");
				response.sendRedirect(request.getContextPath()+"/like.me");
				
			}else {
				request.getSession().setAttribute("alertMsg", "잠시 후 다시 시도해주세요.");
				response.sendRedirect(request.getContextPath()+"/like.me");
			}
			
		} else {
			request.getSession().setAttribute("alertMsg", "로그인 후 다시 시도해주세요.");
			response.sendRedirect(request.getContextPath()+"/main");
		}
		
	}

}

package com.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.GetThePetService;
import com.semi.board.model.vo.Favorite;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class GetThePetFavoriteController
 */
@WebServlet("/favorite.get")
public class GetThePetInsertFavoriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetThePetInsertFavoriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("loginUser") != null) {			
			
			String userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
			String getNo = request.getParameter("getNo");
			
			Favorite f = new Favorite(userNo, getNo);
			
			int result1 = new GetThePetService().insertFavorite(f);
			
			int result = 0;
			
			if(result1 > 0) {
				result = 1;
				response.getWriter().print(result);
			}else {
				int result2 = new GetThePetService().deleteFavorite(f);
				if(result2 > 0) {
					result = 2;
					response.getWriter().print(result);
				}else {
					result = 3;
					response.getWriter().print(result);
				}
			}
		}else {
			int result = 4;
			response.getWriter().print(result);
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

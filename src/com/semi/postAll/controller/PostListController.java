package com.semi.postAll.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.common.model.vo.PageInfo;
import com.semi.postAll.model.service.PostAllService;
import com.semi.postAll.model.vo.PostAll;

/**
 * Servlet implementation class PostListController
 */
@WebServlet("/Plist.bo")
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ----------------- 페이징 처리 --------------------------
		int listCount; // 현재 총 게시글 갯수(1000개)
		int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지)
		int pageLimit; // 페이지 하단에 보여질 페이징바의 페이지 최대 갯수(10개씩 할예정)
		int boardLimit; // 한 페이지에 보여질 게시글의 최대갯수(10개씩 할예정)
		int maxPage; // 가장 마지막 페이지가 몇번쨰 페이지인지(총 페이지 개수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝수

		// * listCount : 총 게시글 갯수
		listCount = new PostAllService().PselectListCount();

		// * currentPage : 현재페이지(즉, 사용자가 요청한 페이지)
		currentPage = Integer
				.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));

		// * pageLimit : 페이지 하단에 보여질 페이징바의 페이지 최대 갯수(페이지 목록들을 몇개 단위로 출력할것인지)
		pageLimit = 5;

		// * boardLimit : 한 페이지에 보여질 게시글의 최대 갯수(게시글 몇개 단위로 출력할것인지)
		boardLimit = 5;

		maxPage = (int) Math.ceil((double) listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;

		endPage = startPage + pageLimit - 1;
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

		request.setAttribute("pi", pi);

		ArrayList<PostAll> list = new PostAllService().PselectList(pi);

		request.setAttribute("list", list);
		System.out.println(list);
		System.out.println(pi);

		request.getRequestDispatcher("views/7H_The_Town/mypage/MyPageMessage.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

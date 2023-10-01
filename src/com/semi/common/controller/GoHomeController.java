package com.semi.common.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.board.model.service.GetThePetService;
import com.semi.board.model.vo.GetThePet;
import com.semi.common.model.vo.PageInfo;
import com.semi.pet.model.vo.Pet;

/**
 * Servlet implementation class GoHomeController
 */
@WebServlet("/main")
public class GoHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoHomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount; // 현재 총 게시글 갯수(1000개)
		int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지)
		int pageLimit; // 페이지 하단에 보여질 최대 페이지 갯수(10개씩 예정)
		int boardLimit; // 한 페이지에 보여질 게시글의 최대 갯수(10개씩 예정)
		int maxPage; // 가장 마지막 페이지가 몇 번째 페이지인지(총 페이지 갯수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작수
		int endPage; // 페이지 하단에 보여질 페이징바의 마지막수
		
		listCount = new GetThePetService().selectListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));
		
		pageLimit = 1;
		
		boardLimit = 12;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		request.setAttribute("pi", pi);

		ArrayList<GetThePet> gList = new GetThePetService().selectGetThePetList(pi);
		ArrayList<Pet> pList = new GetThePetService().selectGetThePetInfoList(pi);
		
		request.setAttribute("gList", gList);
		request.setAttribute("pList", pList);
		
		request.getRequestDispatcher("views/7H_The_Town/Main_Page.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
